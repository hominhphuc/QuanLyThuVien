<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/login/login.css">
    </head>
    <body>
        <h1 style="text-align: center">LOGIN</h1>
        <form:form method="post" modelAttribute="user" action="${pageContext.servletContext.contextPath}/listuser.html">
            
            <div class="container">
                <label ><b>Username</b></label>
                <form:input path="userID" value="4"/>
                <!--<input type="text" placeholder="Enter Username" name="uname" required>-->
                
                <label ><b>Password</b></label>
                <!--<input type="password" placeholder="Enter Password" name="psw" required>-->
                
                <form:input path="password"/>
                <button type="submit">Login</button>
            </div>
            
            <div class="container" style="background-color:#f1f1f1">
                <a href="#"><button type="button" class="cancelbtn">Cancel</button></a>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form:form>
        
        <!--<form action="searchboard-user.jsp" method="post">
            
            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>
            
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>
            
                <button type="">Login</button>
            </div>
            
            <div class="container" style="background-color:#f1f1f1">
                <a href="<%= request.getContextPath()%>/searchUser/list.html "><button type="button" class="cancelbtn">Cancel</button></a>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>-->
        
        <script src="<%= request.getContextPath()%>/javascript/main.js" async defer></script>
    </body>
</html>
