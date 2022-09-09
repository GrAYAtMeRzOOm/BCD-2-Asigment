/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gray.tutiontribre.servlet;

import com.gray.tutiontribe.attendance.UserAttendanceManagerRemote;
import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.information.LectureManagerRemote;
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
@WebServlet(name = "ServletAddStudentToLecture", urlPatterns = {"/servlet-add-student-to-lecture"})
public class ServletAddStudentToLecture extends HttpServlet {


    @EJB
    LectureManagerRemote lmr;
    
    @EJB
    UserManagerRemote umr;
    
    @EJB
    UserAttendanceManagerRemote uamr;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String student = request.getParameter("slist");
        String lecture = request.getParameter("leclist");
        
        User duser = (User) request.getSession().getAttribute("domain-user");
        
        String sid = student.split("-")[0];
        String lid = lecture.split("-")[0];
        
        Lecture lectureById = lmr.getLectureById(duser, Long.valueOf(lid)); 
        User userById = umr.getUserById(duser, Long.valueOf(sid));
        
        uamr.setUserToLecture(userById, lectureById);
        
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
