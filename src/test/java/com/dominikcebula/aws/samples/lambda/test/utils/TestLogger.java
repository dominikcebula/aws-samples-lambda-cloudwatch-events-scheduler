package com.dominikcebula.aws.samples.lambda.test.utils;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger implements LambdaLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);

    public void log(String message) {
        LOGGER.info(message);
    }

    public void log(byte[] message) {
        LOGGER.info(new String(message));
    }
}