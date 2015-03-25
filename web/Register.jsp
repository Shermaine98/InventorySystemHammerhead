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
        <link href="css/signin.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <style>

            .form-control{
                width: 200px;
            }

            .jumbotron{
                width: 600px;
                margin-left: auto;
                margin-right: auto;
            }

            .red{
                color: navy blue;
            }

            .width{
                width: 100px;
            }
        </style>

    </head>
    <body>
        <div align="center"><h2 class="red"><b>Register</b></h2></div>
        <br/>
        <!--<div class="jumbotron">-->
    <center>
        <form action="Register" method ="POST">

            <div class="form-group">

                <input type="text" name="number" class="form-control" value="Number"/><br/>
                <input type="text" name="reqfirstname" class="form-control" value="First Name"/><br/>
                <input type="text" name="reqlastname" class="form-control" value="Last Name"/><br/>
                <select name ="reqposition">
                    <option value="Promo">Promo</option>
                    <option value="GManager">General Manger</option>
                    <option value="Secretary">Secretary</option>
                    <option value="Cutter">Cutter</option>
                </select><br/><br/>
                <input type="text" name="requsername" class="form-control" value="Username"/><br/>
                <input type="password" name="reqpassword" class="form-control" value="Password"/>
                <br/>
            </div> 
            <input type="submit" class="btn btn-primary width" value="Register"/>
        </form>
        <a href="index.jsp"><button class="btn btn-primary width">Cancel</button></a>
    </center>
    <!--</div>-->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>

</html>