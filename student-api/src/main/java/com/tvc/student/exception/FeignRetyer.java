package com.tvc.student.exception;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class FeignRetyer implements Retryer {

    private final int maxAttemts;
    private final long backOff;
    int attempt;

    /**
     * wait for 10
     * seconds before retrying
     */
    public FeignRetyer() {
        this(1000, 5);
    }

    public FeignRetyer(long backOff, int maxAttemts) {
        this.maxAttemts = maxAttemts;
        this.backOff = backOff;
        this.attempt = 1;
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        if (attempt++ >= maxAttemts) {
            throw e;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(backOff);
        } catch (InterruptedException iex) {

        }

        log.info("Retrying: " + e.request().url() + "attempt :" + attempt);

    }

    @Override
    public Retryer clone() {
        return new FeignRetyer(backOff, maxAttemts);
    }
}
