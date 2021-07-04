package com.roopy.exception;

public class UserExistException extends RuntimeException {

    /**
     * 생성자
     *
     * @param msg the detail message
     * @param cause the root cause
     */
    public UserExistException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * 생성자
     * 
     * @param msg the detail message
     */
    public UserExistException(String msg) {
        super(msg);
    }


}
