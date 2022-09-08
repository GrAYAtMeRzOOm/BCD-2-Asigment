<%-- 
    Document   : home
    Created on : Sep 6, 2022, 7:24:34 PM
    Author     : RuRiYo
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="com.gray.tutiontribe.entity.UserRole"%>
<%@page import="com.gray.tutiontribe.information.UserRoleManagerRemote"%>
<%@page import="javax.ejb.EJB"%>
<%

    UserRoleManagerRemote urmr = (UserRoleManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.UserRoleManagerRemote");


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Tution Tribe User Registration</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="Client-backend/assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="Client-backend/assets/vendors/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="Client-backend/assets/vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <link rel="stylesheet" href="Client-backend/assets/vendors/select2/select2.min.css" />
        <link rel="stylesheet" href="Client-backend/assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css" />
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="Client-backend/assets/css/demo_2/style.css" />
        <!-- End layout styles -->
        <link rel="shortcut icon" href="Client-backend/User-login/img/logox50.png" />
    </head>
    <body>
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Register User</h4>
                <p class="card-description">Register all your admins and students here</p>
                <form class="forms-sample" method="POST" action="RegisterUser">
                    <div class="form-group">
                        <label for="exampleInputName1">Name</label>
                        <input type="text" class="form-control" name="name" id="exampleInputName1" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName1">Contact number</label>
                        <input type="text" class="form-control" name="number" id="exampleInputName1" placeholder="Contact number">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail3">Email address</label>
                        <input type="email" class="form-control" name="email" id="exampleInputEmail3" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword4">Password</label>
                        <input type="password" class="form-control" name="password" id="exampleInputPassword4" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="exampleSelectGender">Gender</label>
                        <select class="form-control" name="gender" id="exampleSelectGender">
                            <option>Male</option>
                            <option>Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleTextarea1">Address</label>
                        <textarea class="form-control" name="address" id="exampleTextarea1" rows="4" placeholder="Address"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleSelectGender">Branch</label>
                        <select class="form-control" name="branch" id="exampleSelectGender">
                            <option>Branch 1</option>
                            <option>Branch 2</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleSelectGender">User Role</label>
                        <select class="form-control" name="userRole" id="exampleSelectGender">
                            <%                                for (UserRole ur : urmr.getAllUserRoles()) {
                            %><option><%= ur.getRoleName()%></option><%
                                }
                            %>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary me-2"> Save user </button>
                </form>
            </div>
        </div>
    </body>
</html>

