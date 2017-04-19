<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <jsp:include page="common/header.jsp"/> 

    <div class="hero" data-bg-image="images/banner.png">
        <div class="container">
            <h2>Note:</h2>
            <p><strong>${todayWeather.note.value}</strong></p>

        </div>
    </div>
    <div class="forecast-table">
        <div class="container">
            <div class="forecast-container">
                <div class="today forecast">
                    <div class="forecast-header">
                        <div class="day">Today</div>
                        <div class="date">${todayWeather.date}</div>
                    </div> <!-- .forecast-header -->
                    <div class="forecast-content">
                        <div class="location">Cairo</div>
                        <div class="degree">
                            <div class="num">${todayWeather.temp}<sup>o</sup>C</div>
                            <div class="forecast-icon">
                                <img src="http://openweathermap.org/img/w/${todayWeather.icon}.png" alt="" width=90>
                            </div>	
                        </div>
                                <span><img src="<c:url value="/resources/images/icon-umberella.png"/>" alt="">20%</span>
                                <span><img src="<c:url value="/resources/images/icon-wind.png"/>" alt="">18km/h</span>
                        
                    </div>
                </div>

            </div>
        </div>
    </div>
    
    <jsp:include page="common/footer.jsp"/>

</html>