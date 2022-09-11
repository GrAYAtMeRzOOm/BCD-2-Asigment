<%-- 
    Document   : index
    Created on : Sep 8, 2022, 10:24:24 AM
    Author     : grays
--%>

<%
    
%>

<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>TutionTribe-Login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/logox50.png">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/fontawesome-all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="font/flaticon.css">
        <!-- Google Web Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&amp;display=swap" rel="stylesheet">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/login-page-style.css">
    </head>
    <body>
        <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
        <div id="wrapper" class="wrapper">
            <div class="fxt-template-animation fxt-template-layout5">
                <div class="fxt-bg-img fxt-none-767" data-bg-image="img/figure/figure-bg-1.jpg">
                    <div class="fxt-intro">
                        <div class="sub-title">Welcome To</div>
                        <h1>Our Tution Tribe Center</h1>
                        <p>Bad instructors teach you what to think, worse ones teach you how to think, but the good ones teach you how important it is to learn to think for yourself</p>
                    </div>
                </div>
                <div class="fxt-bg-color">
                    <div class="fxt-header">
                        <a href="login-5.html" class="fxt-logo"><img src="img/logox100.png" alt="Logo"></a>
                        <div class="fxt-page-switcher">
                            <a href="login-5.html" class="switcher-text switcher-text1 active">LogIn</a>
                            <!--<a href="register-5.html" class="switcher-text switcher-text2">Register</a>-->
                        </div>
                    </div>
                    <div class="fxt-form">
                        <form action="/TutionTribe-Main-Web/servlet-user-login" method="POST">
                            <div class="form-group fxt-transformY-50 fxt-transition-delay-1">
                                <input type="email" class="form-control" name="email" placeholder="Email Address" required="required">
                                <i class="flaticon-envelope"></i>
                            </div>
                            <div class="form-group fxt-transformY-50 fxt-transition-delay-2">
                                <input type="password" class="form-control" name="password" placeholder="Password" required="required">
                                <i class="flaticon-padlock"></i>
                                <a href="#" class="switcher-text3">Forgot Password</a>
                            </div>
                            <div class="form-group fxt-transformY-50 fxt-transition-delay-3">
                                <div class="fxt-content-between">
                                    <button type="submit" class="fxt-btn-fill">Log in</button>
                                    <div class="checkbox">
                                        <input id="checkbox1" type="checkbox">
                                        <label for="checkbox1">Keep me logged in</label>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="fxt-footer">
                        <!--                        <ul class="fxt-socials">
                                                    <li class="fxt-facebook fxt-transformY-50 fxt-transition-delay-5"><a href="#" title="Facebook"><i class="fab fa-facebook-f"></i></a></li>
                                                    <li class="fxt-twitter fxt-transformY-50 fxt-transition-delay-6"><a href="#" title="twitter"><i class="fab fa-twitter"></i></a></li>
                                                    <li class="fxt-google fxt-transformY-50 fxt-transition-delay-7"><a href="#" title="google"><i class="fab fa-google-plus-g"></i></a></li>
                                                    <li class="fxt-linkedin fxt-transformY-50 fxt-transition-delay-8"><a href="#" title="linkedin"><i class="fab fa-linkedin-in"></i></a></li>
                                                    <li class="fxt-pinterest fxt-transformY-50 fxt-transition-delay-9"><a href="#" title="pinterest"><i class="fab fa-pinterest-p"></i></a></li>
                                                </ul>-->
                    </div>
                </div>
            </div>
        </div>
        <!-- jquery-->
        <script src="js/jquery-3.5.0.min.js"></script>
        <!-- Popper js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Imagesloaded js -->
        <script src="js/imagesloaded.pkgd.min.js"></script>
        <!-- Validator js -->
        <script src="js/validator.min.js"></script>
        <!-- Custom Js -->
        <script src="js/main.js"></script>

    </body>


    <!-- Mirrored from affixtheme.com/html/xmee/demo/login-5.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 25 Apr 2021 21:04:46 GMT -->
</html>