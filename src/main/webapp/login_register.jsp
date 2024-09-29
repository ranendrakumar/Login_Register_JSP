<%-- 
    Document   : login
    Created on : 29 Sept 2024, 7:51:48 am
    Author     : ranen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/loginstyles.css" rel="stylesheet" type="text/css"/>
        <title>Login and Register</title>
    </head>
    <body>
        <section class="wrapper">
            <div class="form login">
                <header>Login</header>
                <form action="login" method="post">
                    <input type="text" placeholder="Email address" required name="uname" id="uname" autocomplete="off" />
                    <input type="password" placeholder="Password" required name="pass" id="pass" autocomplete="off"/>
                    <a href="#">Forgot password?</a>
                    <input type="submit" value="Login" />
                </form>
            </div>
            <div class="form signup">
                <header>Sign up</header>
                <form action="register" method="post">
                    <input type="text" placeholder="Full name" required name="fullname" id="fullname" autocomplete="off"/>
                    <input type="text" placeholder="User name" required name="username" id="username" autocomplete="off"/>
                    <input type="password" placeholder="Password" required name="password" id="password" autocomplete="off"/>
                    <div class="checkbox">
                        <input type="checkbox" id="signupCheck" />
                        <label for="signupCheck">I accept all terms & conditions</label>
                    </div>
                    <input type="submit" value="Signup" />
                </form>
            </div>

            <script>
                const wrapper = document.querySelector(".wrapper"),
                        signupHeader = document.querySelector(".signup header"),
                        loginHeader = document.querySelector(".login header");
                loginHeader.addEventListener("click", () => {
                    wrapper.classList.add("active");
                });
                signupHeader.addEventListener("click", () => {
                    wrapper.classList.remove("active");
                });
            </script>
        </section>
    </body>
</html>
