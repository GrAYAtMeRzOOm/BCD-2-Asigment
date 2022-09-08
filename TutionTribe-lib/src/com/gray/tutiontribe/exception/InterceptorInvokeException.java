/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.gray.tutiontribe.exception;

/**
 *
 * @author grays
 */
public class InterceptorInvokeException extends RuntimeException {

    /**
     * Creates a new instance of <code>InterceptorInvokeException</code> without
     * detail message.
     */
    public InterceptorInvokeException() {
    }

    /**
     * Constructs an instance of <code>InterceptorInvokeException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     * @param throwable
     */
    public InterceptorInvokeException(String msg,Throwable throwable) {
        super(msg,throwable);
    }
}
