package com.dominikcebula.aws.samples.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;

public class FunctionHandler implements RequestHandler<ScheduledEvent, Integer> {
    @Override
    public Integer handleRequest(ScheduledEvent event, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("EVENT TYPE: " + event.getClass());

        return 0;
    }
}
