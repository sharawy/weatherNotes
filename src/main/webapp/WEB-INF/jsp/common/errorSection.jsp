<%-- 
    Document   : errorSection
    Created on : Apr 11, 2017, 4:17:09 PM
    Author     : abdo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div style="color: #ef2b2b;" class="col-md-10 col-md-offset-1">
    <h3>${msg}</h3>
    <ul  class="col-md-offset-1">
        <c:forEach items="${errors}" var="error">
            <li><strong>${error.field} : ${error.defaultMessage}</strong></li>
        </c:forEach>
    </ul>
</div>
