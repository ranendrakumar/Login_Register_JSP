<%-- 
    Document   : header
    Created on : 28 Sept 2024, 8:43:28 pm
    Author     : ranen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- header.jsp -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>My JSP Website</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            footer {
                position: fixed;
                bottom: 0;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <%
            if (session.getAttribute("uname") == null) {
                response.sendRedirect("login_register.jsp");
            }
        %>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-primary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#" style="color: white">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav" >
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#" style="color: white">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" style="color: white">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/Login_Registration/logout" style="color: white">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <main>
