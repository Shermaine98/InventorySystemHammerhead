<%-- 
    Document   : nHome
    Created on : Dec 2, 2014, 9:39:33 AM
    Author     : Atayan, Lapidario, Sy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Evergrowth Garments Manufacturing Incorporated</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="navbar.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    </head>
    <body>


        <div class="container">

            <!-- Fixed navbar -->
            <div class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="Home.html"><img src="Images/logo.png" alt="logo"
                                                 height="50" width="150"> </a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active" ><a href="#">Home</a></li>
                            <li><a href="about.jsp">About</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                        </ul>
                        <div class="form-group">
                            <form class="navbar-form navbar-right" role="form" action="Login" method ="POST">
                                <input type="text" name="username" placeholder="Username" class="form-control"/>
                                <input type="password" name="password" placeholder="Password" class="form-control">
                                <input type="submit" class="btn btn-danger" value="Login"/>   
                                
                                
                                <a href="Register.jsp">
                                    <button type="button" class="btn btn-danger" value="Register" />Register</button></a>
                                
                            </form>                    
                                
                        </div>
                        
                    </div><!--/.nav-collapse -->
                </div>
            </div>
            <br> <br> <br>
            <div class="col-md-14">
                <img class="featurette-image img-responsive" src="Images/logo.png" alt="Hammerhead Logo">
                <center><img src="Images/motto.png"></center>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>

</html>
