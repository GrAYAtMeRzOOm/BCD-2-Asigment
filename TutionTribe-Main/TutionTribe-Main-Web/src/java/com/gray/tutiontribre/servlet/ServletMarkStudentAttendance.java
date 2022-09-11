/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gray.tutiontribre.servlet;

import com.google.gson.Gson;
import com.gray.tutiontribe.attendance.UserAttendanceManagerRemote;
import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.information.LectureManagerRemote;
import com.gray.tutiontribe.information.UserManagerRemote;
import com.gray.tutiontribe.models.ResponsePayload;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author grays
 */
@WebServlet(name = "ServletMarkStudentAttendance", urlPatterns = {"/servlet-mark-student-attendance"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"Owner", "Admin"}))
public class ServletMarkStudentAttendance extends HttpServlet {

    @EJB
    LectureManagerRemote lmr;

    @EJB
    UserManagerRemote umr;

    @EJB
    UserAttendanceManagerRemote uamr;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();

        String student = request.getParameter("student");
        String lecture = request.getParameter("lecture");
        String status = request.getParameter("status");

        System.out.println(student + " " + lecture + " " + status);

        User duser = (User) request.getSession().getAttribute("domain-user");

        String sid = student.split("-")[0];
        String lid = lecture.split("-")[0];

        System.out.println(sid + " ******* " + lid);

        Lecture lectureById = lmr.getLectureById(duser, Long.valueOf(lid));
        User userById = umr.getUserByContact(duser, sid);

        Boolean markUserAttendance = uamr.markUserAttendance(userById, lectureById, status);
        ResponsePayload responsePayload = new ResponsePayload();
        System.out.println("--------------markUserAttendance  "+markUserAttendance);
        if (markUserAttendance) {
            responsePayload.setCode(200);
            responsePayload.setMassage("Success");
        } else {
            responsePayload.setCode(200);
            responsePayload.setMassage("Fail");
        }
        response.getWriter().write(gson.toJson(responsePayload));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
