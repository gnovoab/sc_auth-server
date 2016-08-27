
//Namespace
package com.microservice.auth.exception;

/**
 * Class that represents a UserNotActiveException
 */
public class UserNotActiveException extends RuntimeException {
    public UserNotActiveException(final String message) {
        super(message);
    }
}
