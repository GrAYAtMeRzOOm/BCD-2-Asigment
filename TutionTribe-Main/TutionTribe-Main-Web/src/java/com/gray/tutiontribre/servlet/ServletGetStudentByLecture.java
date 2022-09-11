/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gray.tutiontribre.servlet;

import com.google.gson.Gson;
import com.gray.tutiontribe.attendance.UserAttendanceManagerRemote;
import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.entity.UserAttendance;
import com.gray.tutiontribe.information.LectureManagerRemote;
import com.gray.tutiontribe.models.UserPayload;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
@WebServlet(name = "ServletGetStudentByLecture", urlPatterns = {"/servlet-get-student-by-lecture"})
//@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"Owner", "Admin"}))
public class ServletGetStudentByLecture extends HttpServlet {

    @EJB
    LectureManagerRemote remote;

    @EJB
    UserAttendanceManagerRemote attendanceManagerRemote;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        String lid = request.getParameter("lectureId");
        String uid = request.getParameter("studentId");
        if (lid != null && uid == null) {
            User dUser = (User) request.getSession().getAttribute("domain-user");
            Lecture lectureById = remote.getLectureById(dUser, Long.valueOf(lid));
            List<UserAttendance> list = attendanceManagerRemote.getuserAttendancebyLectureId(Long.valueOf(lid));
            List<UserPayload> payloads = new ArrayList<>();
            for (UserAttendance attendance : list) {
                UserPayload userPayload = new UserPayload();
                userPayload.setBranch(attendance.getUser().getBranch().getName());
                userPayload.setId(attendance.getUser().getId());
                userPayload.setStatus(attendance.getStatus());
                userPayload.setSubject(lectureById.getSubject());
                userPayload.setName(attendance.getUser().getName());
                userPayload.setEmail(attendance.getUser().getEmail());
                payloads.add(userPayload);
            }
            response.getWriter().print(gson.toJson(payloads));
        } else if (lid != null && uid != null) {
            User dUser = (User) request.getSession().getAttribute("domain-user");
            Lecture lectureById = remote.getLectureById(dUser, Long.valueOf(lid));
            List<UserAttendance> list = attendanceManagerRemote.getuserAttendancebyLectureIdAndUserId(Long.valueOf(lid), Long.valueOf(uid));
            List<UserPayload> payloads = new ArrayList<>();
            for (UserAttendance attendance : list) {
                UserPayload userPayload = new UserPayload();
                userPayload.setBranch(attendance.getUser().getBranch().getName());
                userPayload.setId(attendance.getUser().getId());
                userPayload.setStatus(attendance.getStatus());
                userPayload.setSubject(lectureById.getSubject());
                userPayload.setName(attendance.getAttendance().getLecturer().getName());
                userPayload.setEmail(attendance.getUser().getEmail());
                payloads.add(userPayload);
            }
            response.getWriter().print(gson.toJson(payloads));
        } else {
            response.sendError(404);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
