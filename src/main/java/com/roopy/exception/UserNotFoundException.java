package com.roopy.exception;

public class UserNotFoundException extends RuntimeException {

    /**
     * 생성자
     *
     * @param msg the detail message
     * @param cause the root cause
     */
    public UserNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * 생성자
     *
     * @param msg the detail message
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }


}
