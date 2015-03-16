<%-- 
    Document   : nHome
    Created on : Dec 2, 2014, 9:39:33 AM
    Author     : Atayan, Lapidario, Sy
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Evergrowth Garments Manufacturing Incorporated</title>

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
            .img-responsive{
                max-width: 40%;
            }
            .width{
                width: 100px;
            }
            .width2{
                width: 180px;
            }
        </style>

    </head>

    <body>

    <center><img class="featurette-image img-responsive" src="Images/logo.png" alt="Hammerhead Logo">
        <img src="Images/motto.png" class="featurette-image img-responsive">
        <div class="container">

            <form class="form-signin" role="form" action="Login" method="POST">
                <h2 class="form-signin-heading width2">Sign In</h2><br/>
                <input type="text" name="username" placeholder="Username" class="form-control width2"/><br/>
                <input type="password" name="password" placeholder="Password" class="form-control width2"><br/>
                <input type="submit" class="btn btn-danger width" value="LOG IN"/><br/><br/>
                <a href="Register.jsp"><button type="button" class="btn btn-danger width" value="REGISTER" />REGISTER</button></a><br/>
            </form>

        </div> <!-- /container -->

    </center>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
