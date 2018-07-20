package com.pszymczyk.singleresponsibility;

/**
 * @author pawel szymczyk
 */
class RetryExecutor {

    public void run() {

    }

    static class Builder {
        static Builder retryExecutor() {
            return new Builder();
        }

        Builder withRetryCount(int retryCount) {
            return this;
        }

        Builder retryOnException(Class<? extends Throwable> exception) {
            return this;
        }

        Builder withCustomFinalException(RuntimeException runtimeException) {
            return this;
        }

        RetryExecutor build(Runnable runnable) {
            return new RetryExecutor();
        }
    }

}
