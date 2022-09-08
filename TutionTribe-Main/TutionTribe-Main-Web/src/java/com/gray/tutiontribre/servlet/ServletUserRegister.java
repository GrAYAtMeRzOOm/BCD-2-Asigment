/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gray.tutiontribre.servlet;

import com.google.gson.Gson;
import com.gray.tutiontribe.entity.Branch;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.entity.UserRole;
import com.gray.tutiontribe.information.BranchManagerRemote;
import com.gray.tutiontribe.information.UserManager;
import com.gray.tutiontribe.information.UserManagerRemote;
import com.gray.tutiontribe.information.UserRoleManagerRemote;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author grays
 */
@WebServlet(name = "ServletUserRegister", urlPatterns = {"/servlet-user-register"})
public class ServletUserRegister extends HttpServlet {

    @EJB
    private UserManagerRemote umr;

    @EJB
    private UserRoleManagerRemote userroleManager;

    @EJB
    private BranchManagerRemote branchManager;

    @Override
    public void init() throws ServletException {
        System.out.println("servlet-user-register servlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User dUser = (User) request.getSession().getAttribute("domain-user"); 
        
        
        System.out.println("servlet-user-register servlet post with " + request.getParameterMap().size() + " params");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String branch = request.getParameter("branch");
        String age = request.getParameter("age");
        String userRole = request.getParameter("role");

        UserRole roleByName = userroleManager.getRoleByName(dUser,userRole);
        
        System.out.println("roleByName "+roleByName.toString());
        
        Branch branchObj = branchManager.getBranchByName(dUser, branch);
        System.out.println("branchByName "+branchObj.toString());

        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setAge(Integer.valueOf(age));
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setContact(number);

        User saveUser = umr.saveUser(user,roleByName,branchObj);
        if (saveUser != null) {
            response.getWriter().write("Success");
        } else {
            response.getWriter().write("Error On adding user");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
