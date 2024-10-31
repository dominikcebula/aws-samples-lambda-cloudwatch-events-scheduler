variable "region" {
  default = "eu-central-1"
}

variable "lambda_function_name" {
  default = "aws-samples-lambda-eventbridge-scheduler"
}

variable "lambda_function_handler" {
  default = "com.dominikcebula.aws.samples.lambda.FunctionHandler"
}

variable "lambda_payload_filename" {
  default = "../target/aws-samples-lambda-eventbridge-scheduler-1.0-SNAPSHOT.jar"
}

variable "lambda_runtime" {
  default = "java21"
}
