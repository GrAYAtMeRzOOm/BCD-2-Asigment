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
                            <div class="col-xl-12 stretch-card grid-margin">
                                <div class="card">
                                    <div class="card-body pb-0">
                                        <h4 class="card-title mb-0">Student management review</h4>
                                    </div>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table custom-table text-dark">
                                                <thead>
                                                    <tr>
                                                        <th>Name</th>
                                                        <th>Sale Rate</th>
                                                        <th>Actual</th>
                                                        <th>Variance</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            <img src="../assets/images/faces/face2.jpg" class="me-2" alt="image" /> Jacob Jensen 
                                                        </td> 
                                                        <td>
                                                            <div class="d-flex">
                                                                <span class="pe-2 d-flex align-items-center">85%</span>
                                                                <select id="star-1" name="rating" autocomplete="off">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>32,435</td>
                                                        <td>40,234</td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <img src="../assets/images/faces/face3.jpg" class="me-2" alt="image" /> Cecelia Bradley 
                                                        </td> 
                                                        <td>
                                                            <div class="d-flex">
                                                                <span class="pe-2 d-flex align-items-center">55%</span>
                                                                <select id="star-2" name="rating" autocomplete="off">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>4,36780</td>
                                                        <td>765728</td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <img src="../assets/images/faces/face4.jpg" class="me-2" alt="image" /> Leah Sherman 
                                                        </td>
                                                        <td>
                                                            <div class="d-flex">
                                                                <span class="pe-2 d-flex align-items-center">23%</span>
                                                                <select id="star-3" name="rating" autocomplete="off">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>2300</td>
                                                        <td>22437</td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <img src="../assets/images/faces/face5.jpg" class="me-2" alt="image" /> Ina Curry 
                                                        </td> 
                                                        <td>
                                                            <div class="d-flex">
                                                                <span class="pe-2 d-flex align-items-center">44%</span>
                                                                <select id="star-4" name="rating" autocomplete="off">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>53462</td>
                                                        <td>1,75938</td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <img src="../assets/images/faces/face7.jpg" class="me-2" alt="image" /> Lida Fitzgerald 
                                                        </td> 
                                                        <td>
                                                            <div class="d-flex">
                                                                <span class="pe-2 d-flex align-items-center">65%</span>
                                                                <select id="star-5" name="rating" autocomplete="off">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>67453</td>
                                                        <td>765377</td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <img src="../assets/images/faces/face2.jpg" class="me-2" alt="image" /> Stella Johnson 
                                                        </td>
                                                        <td>
                                                            <div class="d-flex">
                                                                <span class="pe-2 d-flex align-items-center">49%</span>
                                                                <select id="star-6" name="rating" autocomplete="off">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>43662</td>
                                                        <td>96535</td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <img src="../assets/images/faces/face9.jpg" class="me-2" alt="image" /> Maria Ortiz 
                                                        </td>
                                                        <td>
                                                            <div class="d-flex">
                                                                <span class="pe-2 d-flex align-items-center">65%</span>
                                                                <select id="star-7" name="rating" autocomplete="off">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>76555</td>
                                                        <td>258546</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <a class="text-black font-13 d-block pt-2 pb-2 pb-lg-0 font-weight-bold ps-4" href="#">Show more</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 col-xl-4 stretch-card grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="card-title mb-2">Upcoming events (3)</div>
                                        <h3 class="mb-3">23 september 2019</h3>
                                        <div class="d-flex border-bottom border-top py-3">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input type="checkbox" class="form-check-input" checked /></label>
                                            </div>
                                            <div class="ps-2">
                                                <span class="font-12 text-muted">Tue, Mar 5, 9.30am</span>
                                                <p class="m-0 text-black"> Hey I attached some new PSD files? </p>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom py-3">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input type="checkbox" class="form-check-input" /></label>
                                            </div>
                                            <div class="ps-2">
                                                <span class="font-12 text-muted">Mon, Mar 11, 4.30 PM</span>
                                                <p class="m-0 text-black"> Discuss performance with manager </p>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom py-3">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input type="checkbox" class="form-check-input" /></label>
                                            </div>
                                            <div class="ps-2">
                                                <span class="font-12 text-muted">Tue, Mar 5, 9.30am</span>
                                                <p class="m-0 text-black">Meeting with Alisa</p>
                                            </div>
                                        </div>
                                        <div class="d-flex pt-3">
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input type="checkbox" class="form-check-input" /></label>
                                            </div>
                                            <div class="ps-2">
                                                <span class="font-12 text-muted">Mon, Mar 11, 4.30 PM</span>
                                                <p class="m-0 text-black"> Hey I attached some new PSD files? </p>
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
                                                <h4 class="font-weight-bold text-warning mb-0"> 12.45 </h4>
                                                <h6 class="text-muted">Schedule Meeting</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom mb-4 pb-2">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-danger">
                                                    <i class="mdi mdi-account-outline"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-danger mb-0">34568</h4>
                                                <h6 class="text-muted">Profile visits</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom mb-4 pb-2">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-success">
                                                    <i class="mdi mdi-laptop-chromebook"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-success mb-0"> 33.50% </h4>
                                                <h6 class="text-muted">Bounce Rate</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex border-bottom mb-4 pb-2">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-info">
                                                    <i class="mdi mdi-clock-outline"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-info mb-0">12.45</h4>
                                                <h6 class="text-muted">Schedule Meeting</h6>
                                            </div>
                                        </div>
                                        <div class="d-flex">
                                            <div class="hexagon">
                                                <div class="hex-mid hexagon-primary">
                                                    <i class="mdi mdi-timer-sand"></i>
                                                </div>
                                            </div>
                                            <div class="ps-4">
                                                <h4 class="font-weight-bold text-primary mb-0"> 12.45 </h4>
                                                <h6 class="text-muted mb-0">Browser Usage</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-xl-4 stretch-card grid-margin">
                                <div class="card color-card-wrapper">
                                    <div class="card-body">
                                        <img class="img-fluid card-top-img w-100" src="../assets/images/dashboard/img_5.jpg" alt="" />
                                        <div class="d-flex flex-wrap justify-content-around color-card-outer">
                                            <div class="col-6 p-0 mb-4">
                                                <div class="color-card primary m-auto">
                                                    <i class="mdi mdi-clock-outline"></i>
                                                    <p class="font-weight-semibold mb-0">Delivered</p>
                                                    <span class="small">15 Packages</span>
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
                    success: function (data, textStatus, jqXHR) {
                        alert("Success");
                    }, error: function (jqXHR, textStatus, errorThrown) {
                        alert("Error");
                    }
                });
                event.preventDefault();
            });

        </script>
    </body>
</html>
<%
    }%>