package com.example.webprog26.simplethread;

/**
 * Created by webprog26 on 15.11.2016.
 */

interface InterruptChecker {

    /**
     * Should be implemented in {@link Thread} to check interrupted state
     * @return boolean
     */
    boolean isThreadInterrupted();
}
