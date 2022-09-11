/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gray.tutiontribre.servlet;

import com.google.gson.Gson;
import com.gray.tutiontribe.entity.Branch;
import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.information.BranchManagerRemote;
import com.gray.tutiontribe.information.LectureManagerRemote;
import com.gray.tutiontribe.information.UserManagerRemote;
import com.gray.tutiontribe.models.ResponsePayload;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletAddLecture", urlPatterns = {"/servlet-add-lecture"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"Owner","Admin"}))
public class ServletAddLecture extends HttpServlet {

    @EJB
    private LectureManagerRemote lmr;

    @EJB
    private BranchManagerRemote branchManager;

    @EJB
    private UserManagerRemote umr;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            Gson gson = new Gson();
            
            User duser = (User) request.getSession().getAttribute("domain-user");
            String sTime = request.getParameter("sTime");
            String eTime = request.getParameter("eTime");
            String subject = request.getParameter("subject");
            String user = request.getParameter("user");
            String branch = request.getParameter("branch");

            String userContact = user.split("-")[0];

            User userByContact = umr.getUserByContact(duser, userContact);

            Branch branchByName = branchManager.getBranchByName(duser, branch);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

            Date dateSTime = sdf.parse(sTime);
            Date dateETime = sdf.parse(eTime);

            Lecture lecture = new Lecture();
            lecture.setEndedTime(new Timestamp(dateETime.getTime()));
            lecture.setStartedTime(new Timestamp(dateSTime.getTime()));
            lecture.setSubject(subject);
            lecture.setBranch(branchByName);
            lecture.setPresentedUser(userByContact);

            Lecture saveLecture = lmr.saveLecture(duser, lecture);
            ResponsePayload responsePayload = new ResponsePayload();
            if (saveLecture != null) {
                responsePayload.setCode(200);
                responsePayload.setMassage("Success");
                responsePayload.setPayload(lmr);
            } else {
                responsePayload.setCode(200);
                responsePayload.setMassage("Error in Data Saving");
            }
            response.getWriter().write(gson.toJson(responsePayload));
        } catch (ParseException ex) {
            Logger.getLogger(ServletAddLecture.class.getName()).log(Level.SEVERE, null, ex);
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
