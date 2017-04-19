<%-- 
    Document   : header
    Created on : Apr 12, 2017, 9:23:45 AM
    Author     : abdalrahman.sharawy
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

    <title>Weather Notes</title>

    <!-- Loading third party fonts -->
    <link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/fonts/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <!-- Loading main css file -->
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">



</head>


<body>

    <div class="site-content">
        <div class="site-header">
            <div class="container">
                <a href="<c:url value="/home"/>" class="branding">
                    <img src="<c:url value="/resources/images/logo.png" />" alt="" class="logo">
                    <div class="logo-type">
                        <h1 class="site-title">Weather Notes</h1>
                        <small class="site-description">Weather Forecasting</small>
                    </div>
                </a>

                <!-- Default snippet for navigation -->
                <div class="main-navigation">
                    <button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
                    <ul class="menu">
                        <li class="menu-item"><a href="<c:url value="/home"/>" >Home</a></li>
                            <sec:authorize access="hasRole('Admin')">
                            <li class="menu-item"><a href="<c:url value="/systemNotes"/>">System Notes</a></li>
                            <li class="menu-item"><a href="<c:url value="/preNotes"/>">PreDefined Notes</a></li>
                            </sec:authorize>  
                            <sec:authorize  access="isAuthenticated()">
                            <li class="menu-item">
                                <spring:url value="/j_spring_security_logout" var="logoutUrl" />

                                <form action="${logoutUrl}" method="POST" id="logoutForm">
                                    <input type="hidden" 
                                           name="${_csrf.parameterName}"
                                           value="${_csrf.token}" />

                                    <input type="submit" value="logout"/>
                                </form>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                        <li class="menu-item">
                            <a href="<c:url value="/registration"/>">
                                Register</a>
                        </li>
                        </sec:authorize>
                    </ul> <!-- .menu -->
                </div> <!-- .main-navigation -->

                <div class="mobile-navigation"></div>

            </div>
        </div> <!-- .site-header -->

