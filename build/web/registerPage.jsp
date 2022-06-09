<!--
Author: Colorlib
Author URL: https://colorlib.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title> Register Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Custom Theme files -->
        <link href="CSS/register.css" rel="stylesheet" type="text/css" media="all" />
        <!-- //Custom Theme files -->
        <!-- web font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
        <!-- //web font -->
    </head>
    <body>
        <!-- main -->
        <div class="main-w3layouts wrapper">
            <h1>Creative SignUp Form</h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <form action="Register" method="post">
                        <p>${fail}</p>
                        <input class="text" type="text" name="Username" placeholder="Username" value="${name}" required="">
                        <input class="text" type="text" name="phone" placeholder="Phone Number" value="${phone}" required="" pattern="[0-9]{3}[0-9]{2}[0-9]{3}" style="margin-top: 2em;">
                        <p class ="alert" style="display: block; margin-top: 1.25em; float: left;">${alter}</p>
                        <input class="text email" type="email" name="email" placeholder="Email" value="${email}" required="" style="margin-top:2em">
                        <input class="text" type="password" name="password" placeholder="Password" value="${password}" required="">
                        <p class ="alert" style="display: block; margin-top: 1.25em; float: left;">${alterPass}</p>
                        <input class="text w3lpass" type="password" name="rePassword" value="${repass}" placeholder="Confirm Password" required="">
                        <div class="wthree-text">
                            <label class="anim">
                                <input type="checkbox" class="checkbox" required="">
                                <span>I Agree To The Terms & Conditions</span>
                            </label>
                            <div class="clear"> </div>
                        </div>
                        <input type="submit" id ="signin" name ="action" value="Register">
                    </form>
                    <p>Have an Account? <a href="Login"> Login Now!</a></p>
                </div>
            </div>
            <!-- copyright -->
            <div class="colorlibcopy-agile">
                <p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="https://colorlib.com/" target="_blank">Colorlib</a></p>
            </div>
            <!-- //copyright -->
            <ul class="colorlib-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <!-- //main -->
    </body>
</html>
