/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.gray.tutiontribe.exception;

/**
 *
 * @author grays
 */
public class DataDuplicationException extends RuntimeException {

    /**
     * Creates a new instance of <code>DataDuplicationException</code> without
     * detail message.
     */
    public DataDuplicationException() {
    }

    /**
     * Constructs an instance of <code>DataDuplicationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DataDuplicationException(String msg) {
        super(msg);
    }
}
