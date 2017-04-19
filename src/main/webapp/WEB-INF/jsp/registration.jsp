<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
    <jsp:include page="common/header.jsp"/> 
    <main class="main-content">
        <div class="fullwidth-block">
            <div class="container">
                <jsp:include page="common/errorSection.jsp"/>
                <div class="col-md-6 col-md-offset-1">
                    <h2 class="section-title">Register</h2>
                    <spring:url value='/register' var="register" />
                    <form:form id="registerForm" name='registerForm' cssClass="basic-form"
                               action="${register}" method='POST'   modelAttribute="user"
                               data-bv-message="This value is not valid">

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="row">
                            <div class="col-md-6"><input placeholder="Username..." type='text' name='userName'  required ="true"
                                                         data-bv-notempty="true" value="${user.userName}"
                                                         data-bv-notempty-message="username is required and cannot be empty" /></div>
                            <div class="col-md-6"><input placeholder="Email..." type='email' name='email'  required ="true"
                                                         data-bv-notempty="true" value="${user.email}"
                                                         data-bv-notempty-message="Email is required and cannot be empty" /></div>
                        </div>
                        <div class="row">
                            <div class="col-md-12"><input placeholder="Mobile..." type='text' name='mobile'  required ="true"
                                                          data-bv-notempty="true" value="${user.mobile}"
                                                          data-bv-notempty-message="Mobile is required and cannot be empty" /></div>
                        </div>
                        <div class="row">
                            <div class="col-md-12"><input placeholder="Password..." type='password' name='password'  required ="true"
                                                          data-bv-notempty="true" 
                                                          data-bv-notempty-message="Password is required and cannot be empty" /></div>
                        </div>
                        <div class="text-right">
                            <button type="submit" >submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>

</html>