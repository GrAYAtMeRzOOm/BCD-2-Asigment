<%-- 
    Document   : institutemanager
    Created on : Sep 8, 2022, 11:33:08 PM
    Author     : grays
--%>

<%@page import="com.gray.tutiontribe.entity.Lecture"%>
<%@page import="com.gray.tutiontribe.information.LectureManagerRemote"%>
<%@page import="java.util.Set"%>
<%@page import="com.gray.tutiontribe.information.UserManagerRemote"%>
<%@page import="com.gray.tutiontribe.information.UserManager"%>
<%@page import="java.util.List"%>
<%@page import="com.gray.tutiontribe.entity.User"%>
<%@page import="com.gray.tutiontribe.entity.Branch"%>
<%@page import="com.gray.tutiontribe.information.BranchManagerRemote"%>
<%@page import="com.gray.tutiontribe.entity.UserRole"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="com.gray.tutiontribe.information.UserRoleManagerRemote"%>
<!DOCTYPE html>
<%

    if (session.getAttribute("domain-user") == null) {
        response.sendRedirect("/TutionTribe-Main-Web/Client-backend/User-login/");
    } else {
        UserRoleManagerRemote umr = (UserRoleManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.UserRoleManagerRemote");
        BranchManagerRemote bmr = (BranchManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.BranchManagerRemote");
        LectureManagerRemote lmr = (LectureManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.LectureManagerRemote");
        User domainUser = (User) session.getAttribute("domain-user");
        List<Branch> branchs = bmr.getAllbranches(domainUser);
        Set<User> userRoles = umr.getRoleByName(domainUser, "Staff").getRoleUsers();
        List<Lecture> lectures = lmr.getAllLecture(domainUser);

%>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Tution-Tribe Admin</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <link rel="stylesheet" href="assets/vendors/jquery-bar-rating/css-stars.css" />
        <link rel="stylesheet" href="assets/vendors/font-awesome/css/font-awesome.min.css" />
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="assets/css/demo_1/style.css" />
        <!-- End layout styles -->
        <link rel="shortcut icon" href="assets/images/favicon.png" />
    </head>
    <body>
        <div class="container-scroller">
            <!-- partial:partials/_sidebar.html -->
            <jsp:include page="partials/_sidebar.html"/>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:partials/_settings-panel.html -->
                <jsp:include page="partials/_settings-panel.html"/>
                <!-- partial -->
                <!-- partial:partials/_navbar.html -->
                <jsp:include page="partials/_navbar.html"/>
                <!-- partial -->
                <div class="main-panel">
                    <div class="content-wrapper pb-0">
                        <div class="page-header flex-wrap">
                            <div class="header-left">
                                <button class="btn btn-primary mb-2 mb-md-0 me-2"> Create new document </button>
                                <button class="btn btn-outline-primary bg-white mb-2 mb-md-0"> Import documents </button>
                            </div>
                            <div class="header-right d-flex flex-wrap mt-2 mt-sm-0">
                                <div class="d-flex align-items-center">
                                    <a href="#">
                                        <p class="m-0 pe-3">Dashboard</p>
                                    </a>
                                    <a class="ps-3 me-4" href="#">
                                        <p class="m-0">ADE-00234</p>
                                    </a>
                                </div>
                                <button type="button" class="btn btn-primary mt-2 mt-sm-0 btn-icon-text">
                                    <i class="mdi mdi-plus-circle"></i> Add Prodcut </button>
                            </div>
                        </div>
                        <!-- first row starts here -->
                        <!-- doughnut chart row starts -->
                        <div class="row">
                            <div class="col-sm-12 stretch-card">
                                <div class="card-body">
                                    <h4 class="card-title">Add Lecture</h4>
                                    <p class="card-description">Register all your admins and students here</p>
                                    <form class="forms-sample" id="userRegi" onsubmit="return false">
                                        <div class="form-group">
                                            <label for="subject">Lecture Subject</label>
                                            <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject">
                                        </div>
                                        <div class="form-group">
                                            <label for="sTime">Start Time</label>
                                            <input type="datetime-local" class="form-control" name="sTime" id="sTime" >
                                        </div>
                                        <div class="form-group">
                                            <label for="eTime">End Time</label>
                                            <input type="datetime-local" class="form-control" name="eTime" id="eTime" >
                                        </div>
                                        <div class="form-group">
                                            <label for="userBranch">Branch</label>
                                            <select class="form-control" name="branch" id="userBranch">
                                                <%                                                    for (Branch b : branchs) {
                                                %>
                                                <option><%= b.getName()%></option>

                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="user">Set Presenting lecturer</label>
                                            <select class="form-control" name="user" id="user">
                                                <%
                                                    for (User u : userRoles) {
                                                %><option><%= u.getContact() + "-" + u.getName()%></option><%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-primary me-2"> Save user </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Add Student</h4>
                                        <p class="card-description">Add Student to Lecture</p>
                                        <form class="forms-sample">
                                            <div class="form-group">
                                                <label for="exampleInputUsername1">Username</label>
                                                <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username" />
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Email address</label>
                                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" />
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputPassword1">Password</label>
                                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleInputConfirmPassword1">Confirm Password</label>
                                                <input type="password" class="form-control" id="exampleInputConfirmPassword1" placeholder="Password" />
                                            </div>
                                            <div class="form-check form-check-flat form-check-primary">
                                                <label class="form-check-label">
                                                    <input type="checkbox" class="form-check-input" /> Remember me </label>
                                            </div>
                                            <button type="submit" class="btn btn-primary me-2"> Submit </button>
                                            <button class="btn btn-light">Cancel</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Mark Attendance</h4>
                                        <p class="card-description">mark student attendance of lecture</p>
                                        <form class="forms-sample">
                                            <div class="form-group row">
                                                <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Email</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="exampleInputUsername2" placeholder="Username" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Email</label>
                                                <div class="col-sm-9">
                                                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="exampleInputMobile" class="col-sm-3 col-form-label">Mobile</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="exampleInputMobile" placeholder="Mobile number" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="exampleInputPassword2" class="col-sm-3 col-form-label">Password</label>
                                                <div class="col-sm-9">
                                                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" />
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="exampleInputConfirmPassword2" class="col-sm-3 col-form-label">Re Password</label>
                                                <div class="col-sm-9">
                                                    <input type="password" class="form-control" id="exampleInputConfirmPassword2" placeholder="Password" />
                                                </div>
                                            </div>
                                            <div class="form-check form-check-flat form-check-primary">
                                                <label class="form-check-label">
                                                    <input type="checkbox" class="form-check-input" /> Remember me </label>
                                            </div>
                                            <button type="submit" class="btn btn-primary me-2"> Submit </button>
                                            <button class="btn btn-light">Cancel</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Student lecture list</h4>
                                        <div class="table-responsive">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Subject.</th>
                                                        <th>Start Time.</th>
                                                        <th>End Time</th>
                                                        <th>Presenting By</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        for (Lecture lecture : lectures) {
                                                    %>
                                                    <tr>
                                                        <td><%= lecture.getId()%></td>
                                                        <td><%= lecture.getSubject()%></td>
                                                        <td><%= lecture.getStartedTime()%></td>
                                                        <td><%= lecture.getEndedTime()%></td>
                                                        <td><%= lecture.getPresentedUser().getName()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Student attendance</h4>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>User</th>
                                                        <th>Product</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Jacob</td>
                                                        <td>Photoshop</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- content-wrapper ends -->
                    <!-- partial:partials/_footer.html -->
                    <jsp:include page="partials/_footer.html"/>
                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <script src="assets/vendors/jquery-bar-rating/jquery.barrating.min.js"></script>
        <script src="assets/vendors/chart.js/Chart.min.js"></script>
        <script src="assets/vendors/flot/jquery.flot.js"></script>
        <script src="assets/vendors/flot/jquery.flot.resize.js"></script>
        <script src="assets/vendors/flot/jquery.flot.categories.js"></script>
        <script src="assets/vendors/flot/jquery.flot.fillbetween.js"></script>
        <script src="assets/vendors/flot/jquery.flot.stack.js"></script>
        <script src="assets/js/jquery.cookie.js"></script>
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="assets/js/off-canvas.js"></script>
        <script src="assets/js/hoverable-collapse.js"></script>
        <script src="assets/js/misc.js"></script>
        <script src="assets/js/settings.js"></script>
        <script src="assets/js/todolist.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page -->
        <script src="assets/js/dashboard.js"></script>
        <!-- End custom js for this page -->
        <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
        <script>
                                        $("#userRegi").submit(function (event) {
                                            var formData = {
                                                subject: $("#subject").val(),
                                                eTime: $("#eTime").val(),
                                                sTime: $("#sTime").val(),
                                                branch: $("#userBranch").val(),
                                                user: $("#user").val()
                                            };
                                            $.ajax({
                                                url: "/TutionTribe-Main-Web/servlet-add-lecture",
                                                dataType: 'json',
                                                data: formData,
                                                type: 'POST',
                                                success: function (data) {
                                                    if (data.responseText === "Success") {
                                                        alert("User entered Successful");
                                                    } else {
                                                        alert("Error In Data Insertion");
                                                    }
                                                },
                                                error: function (data) {
                                                    console.log(data);
                                                }});
                                            event.preventDefault();
                                        });

        </script>
    </body>
</html>
<%
    }%>