/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gray.tutiontribre.servlet;

import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.entity.UserAttendance;
import com.gray.tutiontribe.information.LectureManagerRemote;
import java.io.IOException;
import java.util.Set;
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
@WebServlet(name = "ServletGetStudentByLecture", urlPatterns = {"/servlet-get-student-by-lecture"})
public class ServletGetStudentByLecture extends HttpServlet {

    @EJB
    LectureManagerRemote remote;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lid = request.getParameter("lid");
        User dUser = (User) request.getSession().getAttribute("domain-user");
        Lecture lectureById = remote.getLectureById(dUser, Long.valueOf(lid));
        Set<UserAttendance> userAttendances = lectureById.getAttendances().getUserAttendances();
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
