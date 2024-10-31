package com.dominikcebula.aws.samples.lambda.test.utils;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class TestContext implements Context {

    private final TestLogger testLogger = new TestLogger();

    public String getAwsRequestId() {
        return "93223ec7-999a-40e5-990b-5dada6d74c15";
    }

    public String getLogGroupName() {
        return "/aws/lambda/test-function";
    }

    public String getLogStreamName() {
        return "test-function-log-stream";
    }

    public String getFunctionName() {
        return "test-function";
    }

    public String getFunctionVersion() {
        return "1.0";
    }

    public String getInvokedFunctionArn() {
        return "arn:aws:lambda:eu-central-1:123456789012:function:test-function";
    }

    public CognitoIdentity getIdentity() {
        return null;
    }

    public ClientContext getClientContext() {
        return null;
    }

    public int getRemainingTimeInMillis() {
        return 300000;
    }

    public int getMemoryLimitInMB() {
        return 256;
    }

    public LambdaLogger getLogger() {
        return testLogger;
    }
}
