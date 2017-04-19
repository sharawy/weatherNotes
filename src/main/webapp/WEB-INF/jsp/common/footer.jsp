<%-- 
    Document   : footer
    Created on : Apr 12, 2017, 9:23:52 AM
    Author     : abdalrahman.sharawy
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<footer class="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <jsp:useBean id="date" class="java.util.Date" />
                <p class="colophon">Copyright <fmt:formatDate value="${date}" pattern="yyyy" /> Weather Notes. All rights reserved</p>

            </div>
            <div class="col-md-3 col-md-offset-1">
                <div class="social-links">
                    <a href="https://github.com/sharawy"><i class="fa fa-github"></i></a>
                    <a href="https://www.linkedin.com/in/abdalrahman-el-sharawy-b9968394/"><i class="fa fa-linkedin"></i></a>
                   
                </div>
            </div>
        </div>

    </div>
</footer> <!-- .site-footer -->
</div>

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins.js"/>"></script>
<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>