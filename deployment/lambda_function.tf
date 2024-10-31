resource "aws_lambda_function" "java_lambda_function" {
  runtime          = "${var.lambda_runtime}"
  function_name    = "${var.lambda_function_name}"
  filename         = "${var.lambda_payload_filename}"
  source_code_hash = "${filesha256(var.lambda_payload_filename)}"

  handler     = "${var.lambda_function_handler}"
  timeout     = 60
  memory_size = 256
  role        = aws_iam_role.iam_for_lambda.arn

  depends_on = [
    aws_iam_role_policy_attachment.lambda_logs,
    aws_cloudwatch_log_group.log_group,
  ]
}

resource "aws_iam_role" "iam_for_lambda" {
  name               = "iam_for_lambda"
  assume_role_policy = data.aws_iam_policy_document.assume_role.json
}

data "aws_iam_policy_document" "assume_role" {
  statement {
    effect = "Allow"

    principals {
      type = "Service"
      identifiers = ["lambda.amazonaws.com"]
    }

    actions = ["sts:AssumeRole"]
  }
}
