<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
    <jsp:include page="../common/header.jsp"/> 
    <main class="main-content">
        <div class="fullwidth-block">
            <div class="container">
                <jsp:include page="../common/errorSection.jsp"/>
                <div class="col-md-6 col-md-offset-1">
                    <jsp:useBean id="today" class="java.util.Date" />

                    <h2 class="section-title">Add Predefined Note</h2> 

                    <spring:url value='/preNotes/add' var="actionUrl" />

                    <form:form id="sysNoteForm" name='sysNoteForm' cssClass="basic-form"
                               action="${actionUrl}" method='POST'   modelAttribute="systemNote"
                               data-bv-message="This value is not valid">

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="row">
                            <div class="col-md-12"><input placeholder="Note..." type='text' name='value'  required ="true"
                                                          data-bv-notempty="true" value="${preNote.value}"
                                                          data-bv-notempty-message="Note is required and cannot be empty" />
                            </div>
                            <div class="col-md-12"><input placeholder="min Temp..." type='text' name='minTemp'  required ="true"
                                                          data-bv-notempty="true" value="${preNote.minTemp}"
                                                          data-bv-notempty-message="Min Temp is required and cannot be empty" />
                            </div>
                            <div class="col-md-12"><input placeholder="Max Temp..." type='text' name='maxTemp'  required ="true"
                                                          data-bv-notempty="true" value="${preNote.maxTemp}"
                                                          data-bv-notempty-message="Max Temp is required and cannot be empty" />
                            </div>                      
                        </div>


                        <div class="text-right">
                            <button type="submit" >submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>

</html>