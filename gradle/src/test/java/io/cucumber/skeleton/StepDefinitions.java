package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitions {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Given("I wait for {int} seconds")
    public void waitFor(int seconds) throws InterruptedException {
        logger.info("Test Started");
        Thread.sleep(seconds * 1000L);
        logger.info("Test Finished");
    }
}
