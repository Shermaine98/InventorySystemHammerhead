<%-- 
    Document   : Register
    Created on : Dec 7, 2014, 11:44:13 PM
    Author     : Atayan, Lapidario, Sy, Nunez
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

        <title>Register</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="navbar.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

        <style>

            .form-control{
                width: 200px;
            }

            .jumbotron{
                width: 600px;
                margin-left: auto;
                margin-right: auto;
            }


        </style>

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
                            <li class="active" ><a href="index.jsp">Home</a></li>
                            <li><a href="about.html">About</a></li>
                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>

            <br/> <br/> <br/><br/>
            <center><h1 style="font-family:Georgia">Register</h1></center>
            <br/>
            <div class="jumbotron">

                <form action="Register" method ="POST">
                    <center>
                        <div class="form-group">
                            
                            <label>Number</label>
                            <input type="text" name="number" class="form-control"/>
                            <label>First Name</label>
                            <input type="text" name="reqfirstname" class="form-control"/>
                            <br/>
                            <label>Last Name</label>
                            <input type="text" name="reqlastname" class="form-control"/>
                            <br/>
                            <br/><br/>
                            <label>Company Position</label>
                            <input type="text" name="reqposition" class="form-control"/>
                            <br/>
                            <label>Username</label>
                            <input type="text" name="requsername" class="form-control"/>
                            <br/>
                            <label>Password</label>
                            <input type="password" name="reqpassword" class="form-control"/>
                            <br/>
                        </div> 
                        <input type="submit" class="btn btn-primary" value="Register"/>
                    </center>
                </form>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>

</html>