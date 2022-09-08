/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gray.tutiontribe.interceptor;

import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.exception.AuthenticationException;
import com.gray.tutiontribe.exception.InterceptorInvokeException;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author grays
 */
@Interceptor
public class LogInterceptor {

    private static final Logger LOGGER = Logger.getLogger(LogInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception {
        try {
            Object[] parameters = ic.getParameters();
            User user = (User) parameters[0];
            if (user != null) {
                System.out.println("LogInterceptor :user " + user.getEmail() + " Accessed Method " + ic.getMethod().getName() + " using " + ic.getParameters().length + " Parameters");
//                LOGGER.info("LogInterceptor : parameters " + parameters.length + " sendbackParams ");
            } else {
                throw new AuthenticationException("Invalid user");
            }
        } catch (AuthenticationException e) {
//            LOGGER.error("LogInterceptor : "+ic.toString());
            System.out.println("LogInterceptor : " + ic.toString());
            throw new InterceptorInvokeException("Wrong User Parameters", e);
        } 
        return ic.proceed();
    }

}
