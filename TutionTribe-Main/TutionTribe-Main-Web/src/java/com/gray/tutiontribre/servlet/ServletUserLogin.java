/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gray.tutiontribre.servlet;

import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.information.UserManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletUserLogin", urlPatterns = {"/servlet-user-login"})
public class ServletUserLogin extends HttpServlet {

   
    @EJB
    UserManagerRemote umr;

    @Override
    public void init() throws ServletException {
        System.out.println("servlet-user-login servlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("servlet-user-login servlet post with " + request.getParameterMap().size() + " params");
        String email = request.getParameter("email");
        String pw = request.getParameter("password");
        try {
            User userLogin = umr.userLogin(email, pw);
            if(userLogin!=null){
                request.getSession().setAttribute("domain-user", userLogin);
                response.sendRedirect("/TutionTribe-Main-Web/Client-backend/");
            }else{
                response.sendRedirect("/TutionTribe-Main-Web/Client-backend/User-login");
            }
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", e.getMessage());
            response.sendRedirect("/TutionTribe-Main-Web/Client-backend/Error-View");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
