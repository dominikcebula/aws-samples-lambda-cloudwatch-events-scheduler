package com.dominikcebula.aws.samples.lambda;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import com.amazonaws.services.lambda.runtime.tests.annotations.Event;
import com.dominikcebula.aws.samples.lambda.test.utils.TestContext;
import org.junit.jupiter.params.ParameterizedTest;

class FunctionHandlerTest {
    @ParameterizedTest
    @Event(value = "events/scheduled-event.json", type = ScheduledEvent.class)
    void shouldInvokeHandlerCorrectly(ScheduledEvent scheduledEvent) {
        FunctionHandler functionHandler = new FunctionHandler();

        functionHandler.handleRequest(scheduledEvent, new TestContext());
    }
}
