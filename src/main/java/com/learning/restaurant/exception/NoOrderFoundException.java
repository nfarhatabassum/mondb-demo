package com.learning.restaurant.exception;

public class NoOrderFoundException extends Throwable {
    public NoOrderFoundException(String noOrderForToday) {
    super(noOrderForToday);
    }
}
