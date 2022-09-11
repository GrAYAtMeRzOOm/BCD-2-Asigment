<%-- 
    Document   : student_index
    Created on : Sep 11, 2022, 10:53:56 PM
    Author     : grays
--%>

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
        UserAttendanceManagerRemote uamr = (UserAttendanceManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.attendance.UserAttendanceManagerRemote");
        User domainUser = (User) session.getAttribute("domain-user");
        List<UserAttendance> lectures = uamr.getuserAttendancebyUserId(domainUser.getId());
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
            <jsp:include page="partials/student_slidebar.jsp"/>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:partials/_settings-panel.html -->
                <jsp:include page="partials/_settings-panel.html"/>
                <!-- partial -->
                <!-- partial:partials/_navbar.html -->
                <jsp:include page="partials/student_navbar.jsp"/>
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
                                        <p class="m-0"><%= domainUser.getName()%></p>
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
                                                for (UserAttendance attend : lectures) {
                                                    Lecture lecture = attend.getAttendance().getLecture();
                                                    Date d = new Date(attend.getAttendance().getLecture().getStartedTime().getTime());
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
                                                        <th>Lecturer</th>
                                                        <th>Branch</th>
                                                        <th>Subject</th>
                                                        <th>Status</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="tbAttend">
                                                    <tr>
                                                        <td>sample</td> 
                                                        <td>sample</td>
                                                        <td>sample</td>
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
                                                        lectureId: $("#lecturewithId").val(),
                                                        studentId: <%= domainUser.getId()%>
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
    }%>