package com.example.test_easy_bot.exception;

public class ProductIsNotFoundException extends RuntimeException {
    public ProductIsNotFoundException(Integer id) {
        super(String.format("Product with id %s was not found", id));
    }
}
