package io.cucumber.skeleton;

import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunStarted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestEventHandler implements EventListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, (TestRunStarted event) -> {
            logger.info(
                    "Entering the before handler. \n" +
                            "Event time " + ZonedDateTime.ofInstant(event.getInstant(), ZoneId.systemDefault()) + "\n" +
                            "Current time " + ZonedDateTime.now(ZoneId.systemDefault())
            );
        });

        publisher.registerHandlerFor(TestRunFinished.class, (TestRunFinished event) -> {
            logger.info(
                    "Entering the after handler. \n" +
                            "Event time " + ZonedDateTime.ofInstant(event.getInstant(), ZoneId.systemDefault()) + "\n" +
                            "Current time " + ZonedDateTime.now(ZoneId.systemDefault())
            );
        });
    }
}
