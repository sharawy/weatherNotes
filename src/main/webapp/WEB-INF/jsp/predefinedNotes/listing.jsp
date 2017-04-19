<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
    <jsp:include page="../common//header.jsp"/> 
    
    <main class="main-content">
        <div class="fullwidth-block">
            <div class="container">
                <h2><a href="<c:url value="/preNotes/add"/>">Add Predefined Note</a></h2>
                 <table id="mytable" class="table table-bordered table-responsive">
                   
                   <thead>
                   
               
               <th>Min</th>
               <th>Max</th>
                     <th>Note Value</th>
                    <th>Edit</th>
                      
             <!--            <th>Delete</th>-->
                   </thead>
    <tbody>
     <c:forEach items="${preNotes}" var="preNote">
    <tr>
        <td>${preNote.minTemp}</td>
        <td>${preNote.maxTemp}</td>
    <td>${preNote.value}</td>
    <td><p data-placement="top" data-toggle="tooltip" title="Edit"><a href="<c:url value="/preNotes/${preNote.id}"/>" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" >Edit</a></span></button></p></td>
    </tr>
     </c:forEach>
    </tbody>
        
</table>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>

</html>