<%-- 
    Document   : AddUser
    Created on : Jun 17, 2019, 1:19:01 PM
    Author     : USER
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/add/small.css">
</head>
<body>

    <form:form cssStyle="border:1px solid #ccc" action="${pageContext.servletContext.contextPath}/listuseradded/${usingUser.userID}.html"
               acceptCharset="UTF-8"                                                                                commandName="addingUser">
        
        <div class="container">
            <h1>ADD USER</h1>
            <hr>

            <label ><b>NAME</b></label>
            <form:input type="text" placeholder="Enter " path="userName" required="true" />
            <!--<input type="text" placeholder="Enter "  required>-->

            <label ><b>FAMILY 'S NAME</b></label>
            <form:input type="text" placeholder="Enter " path="userSirName" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->

            <label ><b>Birthday</b></label>
            <form:input type="text" placeholder="Enter " path="birthDay" required="true"/>
            <!--<input type="text" placeholder="Enter " required>-->

            <label ><b>phone Number</b></label>
            <form:input type="number" placeholder="Enter " path="phoneNumber" required="true"/>
            <!--<input type="number" placeholder="Enter " path="phoneNumber" required>-->

            <label ><b>Citizen ID or Passport</b></label>
            <form:input type="number" placeholder="Enter " path="iD_Number"  required="true"/>
            <!--<input type="number" placeholder="Enter "  required>-->

            <label ><b>Andress</b></label>
            <form:input type="text" placeholder="Enter " path="andress" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->
            
            <label ><b>Password</b></label>
            <form:input type="text" placeholder="Enter " path="password" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->
            
            <div class="clearfix">
                <button type="reset" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">ADD</button>
            </div>
        </div>
        
    </form:form>
    
    <!--<form action="" style="border:1px solid #ccc">
        <div class="container">
            <h1>ADD USER</h1>
            <hr>

            <label ><b>NAME</b></label>
            <input type="text" placeholder="Enter "  required>

            <label ><b>FAMILY 'S NAME</b></label>
            <input type="text" placeholder="Enter "  required>

            <label ><b>Birthday</b></label>
            <input type="text" placeholder="Enter "  required>

            <label ><b>phoneNumber</b></label>
            <input type="number" placeholder="Enter "  required>

            <label ><b>Citizen ID or Passport</b></label>
            <input type="number" placeholder="Enter "  required>

            <label ><b>Andress</b></label>
            <input type="text" placeholder="Enter "  required>
            
            <label ><b>Password</b></label>
            <input type="text" placeholder="Enter "  required>

            <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
            </label>
            
            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">ADD</button>
            </div>
        </div>
    </form>     -->
    <form:form method="post" commandName="usingUser" action="${pageContext.servletContext.contextPath}/listuser2.html">
        <form:input type="hidden" path="userID" value="${usingUser.userID}"/>
        <button type="submit">Return to SEARCH BOARD</button>
    </form:form>

</body>
</html>
