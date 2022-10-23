<%-- 
    Document   : searchboard-deal
    Created on : Jun 17, 2019, 1:17:53 PM
    Author     : USER
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Library</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/mobile.css">
    </head>
    <body>
        <div class="menu-img">
            <img src="image/wooden.png" alt="" >
            
        </div>
        <div class="logo-bgr">
            <h1>Welcome to Library</h1>
            <hr>
        </div>
        <div class="main">
           
            <!--Table for Deal-->
            <div class="deal_area">
                <h2>
                    Search Deal 
                </h2>

                <input type="text" id="myInput" onkeyup="myFunction2()" placeholder="Search for names..">
                <table id="myTable">
                    <tr class="header">
                        <th style="width:10%;">Code</th>
                        <th style="width:10%;">User ID</th>
                        <th style="width:10%;">Book ID</th>
                        <th style="width:35%;">Date Of Borrowing</th>
                        <th style="width:35%;">Date Of Returning</th>
                    </tr>
                    
                    <c:forEach var="de" items="${list}">
                        <tr>
                            <td>${de.dealID}</td>
                            <td>${de.userID} </td>
                            <td>${de.bookID} </td>
                            <td>${de.borrowDay} </td>
                            <td>${de.returnDay} </td>
                            
                            
                        </tr>
                    </c:forEach>
                    
                    <!--<tr>
                        <td>2</td>
                        <td>Minh Khoi Is AWESOME</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Hiuy Phong Is AWESOME</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Minh Khoi Is AWESOME</td>
                    </tr>                -->
    
                </table>
                        
                <form:form commandName="usingUser" action="${pageContext.servletContext.contextPath}/addDeal.html">
                    <form:input path="userID" value="${usingUser.userID}" type="hidden"/>        
                    <button style="display: ${display}">Add Deal</button>
                </form:form>
                
                <form:form commandName="usingUser" action="${pageContext.servletContext.contextPath}/updateDeal.html">
                    <form:input path="userID" value="${usingUser.userID}" type="hidden"/>        
                    <button style="display: ${display}">Update Deal</button>
                </form:form>
                
                <a href="<%= request.getContextPath()%>/listbook/${usingUser.userID}.html">
                    <button  type="button" >Board of books</button>
                </a>
                    
                <form:form commandName="usingUser" action="${pageContext.servletContext.contextPath}/listuser2.html">
                    <form:input path="userID" value="${usingUser.userID}" type="hidden"/>
                    <button>Board of users</button>
                </form:form>
            </div>

        </div>
        <script src="<%= request.getContextPath()%>/javascript/main.js"></script>
    </body>
</html>
