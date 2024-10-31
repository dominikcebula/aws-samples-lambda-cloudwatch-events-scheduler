resource "aws_scheduler_schedule" "lambda_scheduler" {
  name       = "lambda-schedule"
  group_name = "default"

  flexible_time_window {
    mode = "OFF"
  }

  schedule_expression = "rate(1 minute)"

  target {
    arn      = aws_lambda_function.java_lambda_function.arn
    role_arn = aws_iam_role.scheduler_role.arn
    input = jsonencode({ "input" : "Message from EventBridge Scheduler!" })
  }
}

resource "aws_iam_role" "scheduler_role" {
  name               = "event-bridge-scheduler-role"
  assume_role_policy = data.aws_iam_policy_document.scheduler_role_policy_document.json
}

data "aws_iam_policy_document" "scheduler_role_policy_document" {
  statement {
    actions = ["sts:AssumeRole"]
    effect = "Allow"
    principals {
      type = "Service"
      identifiers = ["scheduler.amazonaws.com"]
    }
  }
}

resource "aws_iam_role_policy" "eventbridge_invoke_policy" {
  name   = "event-bridge-invoke-lambda-policy"
  role   = aws_iam_role.scheduler_role.id
  policy = data.aws_iam_policy_document.eventbridge_invoke_policy_document.json
}

data "aws_iam_policy_document" "eventbridge_invoke_policy_document" {
  statement {
    sid    = "AllowEventBridgeToInvokeLambda"
    actions = ["lambda:InvokeFunction"]
    effect = "Allow"
    resources = [aws_lambda_function.java_lambda_function.arn]
  }
}
