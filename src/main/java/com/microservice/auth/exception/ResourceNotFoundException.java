
//Namespace
package com.microservice.auth.exception;

/**
 * Class that represents a ResourceNotFoundException
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
