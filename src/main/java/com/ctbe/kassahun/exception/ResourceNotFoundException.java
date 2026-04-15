package com.ctbe.kassahun.exception;

public class ResourceNotFoundException extends RuntimeException {

    private final Long id;

    public ResourceNotFoundException(Long id) {
        super("Product " + id + " not found");
        this.id = id;
    }

    public Long getId() { return id; }
}
