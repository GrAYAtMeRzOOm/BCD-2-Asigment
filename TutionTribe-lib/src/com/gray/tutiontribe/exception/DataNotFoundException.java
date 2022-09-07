/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.gray.tutiontribe.exception;

/**
 *
 * @author grays
 */
public class DataNotFoundException extends RuntimeException{

    /**
     * Creates a new instance of <code>DataNotFoundException</code> without
     * detail message.
     */
    public DataNotFoundException() {
    }

    /**
     * Constructs an instance of <code>DataNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DataNotFoundException(String msg) {
        super(msg);
    }
}
