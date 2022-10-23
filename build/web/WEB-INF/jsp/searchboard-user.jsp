<%-- 
    Document   : searchboard-user
    Created on : Jun 16, 2019, 10:05:37 PM
    Author     : USER
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Library</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/mobile.css">
    </head>
    <body>
        <div class="menu-img">
            <img src="image/wooden.png" alt="" >
            
        </div>
        <div class="logo-bgr">
            <h1>Welcome to Library. Nguyễn Ngọc Minh</h1>
            <hr>
        </div>
        <div class="main">

            <!--Table for User-->
            <div class="user_area">
                <h2>
                    Search User 
                </h2>

                <input type="text" id="myInput" onkeyup="myFunction2()" placeholder="Search for names..">
                <table id="myTable">
                    <tr class="header">
                        <th style="width:10%;">Code</th>
                        <th style="width:70%;">User</th>
                        
                        <c:if test="${display == ''}">
                            <th style="width:20%;">Options</th>
                        </c:if>
                    </tr>
                    
                    <c:forEach var="us" items="${list}">
                        <tr>
                            <td>${us.userID}</td>
                            <td>${us.userSirName} &nbsp; ${us.userName}</td>
                            <c:if test="${display == ''}">
                                <th style="width:20%;">
                                    
                                    <button class="myBtn">LOOK UP</button>
                                    <!-- The Modal -->
                                    <div id="" class="modal myModal">

                                        <!-- Modal content -->
                                        <div class="modal-content">
                                            Fullname: ${us.userName } &nbsp; ${ us.userSirName} <br>
                                            Birth Day: ${us.birthDay} <br>
                                            Phone: ${us.phoneNumber} <br>
                                            ID Number: ${us.iD_Number} <br>
                                            Address: ${us.andress}
                                        </div>

                                    </div>
                                </th>
                            </c:if>
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
                    </tr>            -->    
                </table>
                
                <form:form method="post" commandName="usingUser" action="${pageContext.servletContext.contextPath}/addUser.html">
                    <form:input type="hidden" path="userID" value="${usingUser.userID}"/>
                    <button style="display: ${display}">Add user</button>
                </form:form>
                
                <form:form method="post" commandName="usingUser" action="${pageContext.servletContext.contextPath}/updateUser.html">
                    <form:input type="hidden" path="userID" value="${usingUser.userID}"/>
                    <button style="display: ${display}" >Update user</button>
                </form:form>
                
                <a href="<%= request.getContextPath()%>/listbook/${usingUser.userID}.html">
                    <button  type="button" >Board of books</button>
                </a>
                    
                <a href="<%= request.getContextPath()%>/listdeal/${usingUser.userID}.html">
                    <button  type="button" >Board of deals</button>
                </a>
            </div>

        </div>
    <script src="<%= request.getContextPath()%>/javascript/main.js"></script>
    </body>
</html>
