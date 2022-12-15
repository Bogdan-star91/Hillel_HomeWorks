package com.game.error;

public class ErrorGameImpl extends RuntimeException {
    public ErrorGameImpl(String message) {
        super(message);
    }
}
