<%@page import="com.gray.tutiontribe.information.UserManagerRemote"%>
<%@page import="com.gray.tutiontribe.attendance.UserAttendanceManagerRemote"%>
<%@page import="com.gray.tutiontribe.entity.UserAttendance"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.gray.tutiontribe.information.LectureManagerRemote"%>
<%@page import="com.gray.tutiontribe.entity.Lecture"%>
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
        User domainUser = (User) session.getAttribute("domain-user");
        if (!domainUser.getUserRole().getRoleName().equals("Student")) {
            UserRoleManagerRemote urmr = (UserRoleManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.UserRoleManagerRemote");
            UserManagerRemote um = (UserManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.UserManagerRemote");
            BranchManagerRemote bmr = (BranchManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.BranchManagerRemote");
            LectureManagerRemote lmr = (LectureManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.LectureManagerRemote");
//            UserAttendanceManagerRemote uamr = (UserAttendanceManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.attendance.UserAttendanceManagerRemote");
            List<User> staff = um.getAllUsersByRole("Staff");
            List<User> students = um.getAllUsersByRole("Student");
            List<User> admins = um.getAllUsersByRole("Admin");
            List<Branch> branchs = bmr.getAllbranches(domainUser);
            List<UserRole> userRoles = urmr.getAllUserRoles(domainUser);
            List<Lecture> lectures = lmr.getAllLecture(domainUser);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");


%>
<c:set var="username" value="<%= domainUser.getName()%>" scope="page"/>
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
            <jsp:include page="partials/_sidebar.jsp"/>
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
                                <button onclick="toPDF()" class="btn btn-primary mb-2 mb-md-0"> Import document as PDF </button>
                                <button onclick="toJSON()" class="btn btn-primary mb-2 mb-md-0"> Import document as JSON </button>
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
                            <div class="col-xl-12 stretch-card grid-margin">
                                <div class="card">
                                    <div class="card-body pb-0">
                                        <h4 class="card-title mb-0">Student management review</h4>
                                        <select onchange="loadtable()" class="form-control" name="userRole" id="lecturewithId">
                                            <%
                                                for (Lecture lecture : lectures) {
                                                    Date d = new Date(lecture.getStartedTime().getTime());
                                            %>
                                            <option value="<%= lecture.getId()%>"><%= sdf.format(d) + " - " + lecture.getSubject() + " - " + lecture.getPresentedUser().getName()%></option><%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table custom-table text-dark">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Email</th>
                                                        <th>Name</th>
                                                        <th>Branch</th>
                                                        <th>Subject</th>
                                                        <th>Status</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="tbAttend">
                                                    <tr>
                                                        <td></td> 
                                                        <td></td>
                                                        <td></td>
                                                        <td>sample</td>
                                                        <td>sample</td>
                                                        <td>Present</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 col-xl-4 stretch-card grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="card-title mb-2">Lectures to date (3)</div>
                                        <select class="form-control" name="userRole" id="lecDate">
                                            <%
                                                for (Lecture lecture : lectures) {
                                                    Date d = new Date(lecture.getStartedTime().getTime());
                                            %><option><%= sdf.format(d)%></option><%
                                                }
                                            %>
                                        </select>
                                        <div id="lecloader">
                                            <div class="d-flex border-bottom border-top py-3">
                                                <div class="ps-2">
                                                    <span class="font-12 text-muted">Tue, Mar 5, 9.30am</span>
                                                    <p class="m-0 text-black"> Lecture name </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-xl-4 stretch-card grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex border-bottom mb-4 pb-2">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-warning">
                                                    <i class="mdi mdi-clock-outline"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-warning mb-0"> <%= lectures.size()%></h4>
                                                <h6 class="text-muted">Lectures Count</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom mb-4 pb-2">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-danger">
                                                    <i class="mdi mdi-account-outline"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-danger mb-0"><%= branchs.size()%></h4>
                                                <h6 class="text-muted">Branch Count</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom mb-4 pb-2">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-success">
                                                    <i class="mdi mdi-laptop-chromebook"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-success mb-0"><%= students.size()%></h4>
                                                <h6 class="text-muted">Student Count</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom mb-4 pb-2">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-info">
                                                    <i class="mdi mdi-clock-outline"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-info mb-0"><%= staff.size()%></h4>
                                                <h6 class="text-muted">Staff Count</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-primary">
                                                    <i class="mdi mdi-timer-sand"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-primary mb-0"> <%= admins.size()%> </h4>
                                                <h6 class="text-muted mb-0">Admins Count</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-xl-4 stretch-card grid-margin">
                                <div class="card color-card-wrapper">
                                    <div class="card-body">
                                        <img class="img-fluid card-top-img w-100" src="assets/images/dashboard/img_5.jpg" alt="" />
                                        <div class="d-flex flex-wrap justify-content-around color-card-outer">
                                            <div class="col-6 p-0 mb-4">
                                                <div class="color-card primary m-auto">
                                                    <i class="mdi mdi-clock-outline"></i>
                                                    <p class="font-weight-semibold mb-0">User Roles</p>
                                                    <span class="small"><%= userRoles.size()%> Roles</span>
                                                </div>
                                            </div>
                                            <div class="col-6 p-0 mb-4">
                                                <div class="color-card bg-success m-auto">
                                                    <i class="mdi mdi-tshirt-crew"></i>
                                                    <p class="font-weight-semibold mb-0">Ordered</p>
                                                    <span class="small">72 Items</span>
                                                </div>
                                            </div>
                                            <div class="col-6 p-0">
                                                <div class="color-card bg-info m-auto">
                                                    <i class="mdi mdi-trophy-outline"></i>
                                                    <p class="font-weight-semibold mb-0">Arrived</p>
                                                    <span class="small">34 Upgraded</span>
                                                </div>
                                            </div>
                                            <div class="col-6 p-0">
                                                <div class="color-card bg-danger m-auto">
                                                    <i class="mdi mdi-presentation"></i>
                                                    <p class="font-weight-semibold mb-0">Reported</p>
                                                    <span class="small">72 Support</span>
                                                </div>
                                            </div>
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
        <script src="assets/js/tableHTMLExport.js"></script>
        <!-- End custom js for this page -->
        <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/2.3.5/jspdf.plugin.autotable.min.js"></script>
        <script>
                                            document.onload = function () {
                                                $("#lb_userId").val("<%= domainUser.getName()%>");
                                            };
                                            $("#userRegi").submit(function (event) {
                                                var formData = {
                                                    name: $("#userName").val(),
                                                    number: $("#userNumber").val(),
                                                    email: $("#userEmail").val(),
                                                    password: $("#userPassword").val(),
                                                    address: $("#userAddress").val(),
                                                    age: $("#userAge").val(),
                                                    branch: $("#userBranch").val(),
                                                    role: $("#userRole").val(),
                                                    gender: $("#userGender").val()
                                                };
                                                $.ajax({
                                                    url: "/TutionTribe-Main-Web/servlet-user-register",
                                                    dataType: 'json',
                                                    data: formData,
                                                    type: 'POST',
                                                    success: function (data, textStatus, jqXHR) {
                                                        alert("Success");
                                                        window.location.reload();
                                                    }, error: function (jqXHR, textStatus, errorThrown) {
                                                        alert("Error");
                                                    }
                                                });
                                                event.preventDefault();
                                            });

                                            function logout() {
                                                if (confirm("<%= domainUser.getName()%> do you need to logout"))
                                                    $.ajax({
                                                        url: "/TutionTribe-Main-Web/servlet-logout",
                                                        dataType: 'json',
                                                        type: 'POST',
                                                        success: function (data, textStatus, jqXHR) {
                                                            alert("Success");
                                                            window.location.replace("/TutionTribe-Main-Web/Client-backend/User-login");
                                                        }, error: function (jqXHR, textStatus, errorThrown) {
                                                            window.location.replace("/TutionTribe-Main-Web/Client-backend/User-login");
                                                            alert("Error");
                                                        }
                                                    });

                                            }
                                            function loadtable() {
                                                $.ajax({
                                                    url: "/TutionTribe-Main-Web/servlet-get-student-by-lecture",
                                                    data: {
                                                        lectureId: $("#lecturewithId").val()
                                                    },
                                                    dataType: 'json',
                                                    success: function (data) {
                                                        let val;
                                                        $.each(data, function (key, value) {
                                                            val += '<tr ><td>' + value.id + '</td>';
                                                            val += '<td>' + value.email + '</td>';
                                                            val += '<td>' + value.name + '</td>';
                                                            val += '<td>' + value.branch + '</td>';
                                                            val += '<td>' + value.subject + '</td>';
                                                            if (value.status === undefined) {
                                                                val += '<td> UnMarked </td></tr>';
                                                            } else {
                                                                val += '<td>' + value.status + ' </td></tr>';
                                                            }
                                                        });
                                                        $('#tbAttend').html(val);
                                                    }
                                                });
                                            }
                                            function toJSON() {
                                                $("#tbAttend").tableHTMLExport({
                                                    type: 'json',
                                                    // file name
                                                    filename: 'sampleAsjson.json'

                                                });
                                            }
                                            function toPDF() {
                                                $("#tbAttend").tableHTMLExport({
                                                    type: 'pdf',
                                                    orientation: 'p',
                                                    filename: 'sampleAsPDF.json'

                                                });

                                            }

        </script>
    </body>
</html>
<%
        } else {
            response.sendRedirect("/TutionTribe-Main-Web/Client-backend/student_index.jsp");
        }
    }%>