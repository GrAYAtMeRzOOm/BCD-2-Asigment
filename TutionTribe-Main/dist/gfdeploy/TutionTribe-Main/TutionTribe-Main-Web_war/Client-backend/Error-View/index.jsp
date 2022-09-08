<%-- 
    Document   : error-page
    Created on : Sep 8, 2022, 11:21:14 AM
    Author     : grays
--%>
<%
    String errormsg = "";
    if(session.getAttribute("error")==null){
        errormsg = "Access Denied 403";
    }else{
        errormsg = (String) session.getAttribute("error");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Access Denied</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="../assets/vendors/mdi/css/materialdesignicons.min.css">
        <style>
            body{
                background-color: black;
                color: white;
            }
            h1 {
                color: red;
            }

            h6{
                color: red;
                text-decoration: underline;
            }


        </style>
    </head>
    <body>
        <div class="w3-display-middle">
            <h1 class="w3-jumbo w3-animate-top w3-center"><code>Access Denied</code></h1>
            <hr class="w3-border-white w3-animate-left" style="margin:auto;width:50%">
            <h3 class="w3-center w3-animate-right"><%= errormsg %></h3>
            <h3 class="w3-center w3-animate-zoom"><i class="mdi mdi-close-octagon"></i><i class="mdi mdi-close-octagon"></i><i class="mdi mdi-close-octagon"></i><i class="mdi mdi-close-octagon"></i></h3>
            <!--<h6 class="w3-center w3-animate-zoom">error code:403 forbidden</h6>-->
            <h6 class="w3-center w3-animate-zoom"><a href="/TutionTribe-Main-Web/Client-backend">Home</a></h6>
            
        </div>
    </body>
</html>
