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
        UserRoleManagerRemote urmr = (UserRoleManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.UserRoleManagerRemote");
        BranchManagerRemote bmr = (BranchManagerRemote) new InitialContext().lookup("com.gray.tutiontribe.information.BranchManagerRemote");
        User domainUser = (User) session.getAttribute("domain-user");
        List<Branch> branchs = bmr.getAllbranches(domainUser);
        List<UserRole> userRoles = urmr.getAllUserRoles(domainUser);


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
                                    <h4 class="card-title">Register User</h4>
                                    <p class="card-description">Register all your admins and students here</p>
                                    <form class="forms-sample" id="userRegi" onsubmit="return false">
                                        <div class="form-group">
                                            <label for="exampleInputName1">Name</label>
                                            <input type="text" class="form-control" name="name" id="userName" placeholder="Name">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputName1">Contact number</label>
                                            <input type="text" class="form-control" name="number" id="userNumber" placeholder="Contact number">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail3">Email address</label>
                                            <input type="email" class="form-control" name="email" id="userEmail" placeholder="Email">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword4">Password</label>
                                            <input type="password" class="form-control" name="password" id="userPassword" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputDob">Age</label>
                                            <input type="range" class="form-control" name="age" id="userAge" placeholder="18">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleSelectGender">Gender</label>
                                            <select class="form-control" name="gender" id="userGender">
                                                <option>Male</option>
                                                <option>Female</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleTextarea1">Address</label>
                                            <textarea class="form-control" name="address" id="userAddress" rows="4" placeholder="Address"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleSelectGender">Branch</label>
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
                                            <label for="exampleSelectGender">User Role</label>
                                            <select class="form-control" name="userRole" id="userRole">
                                                <%
                                                    for (UserRole ur : userRoles) {
                                                %><option><%= ur.getRoleName()%></option><%
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
                            <div class="col-lg-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Student lecture list</h4>
                                        <div class="table-responsive">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Profile</th>
                                                        <th>VatNo.</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Jacob</td>
                                                        <td>53275531</td>
                                                    </tr>
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
                    success: function (data) {
                        if(data.responseText==="Success"){
                            alert("User entered Successful");
                        }else{
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