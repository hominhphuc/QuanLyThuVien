<%-- 
    Document   : AddDeal
    Created on : Jun 17, 2019, 1:20:25 PM
    Author     : USER
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/add/small.css">
</head>
<body>

    <form:form action="" cssStyle="border:1px solid #ccc" commandName="addingDeal">
        
        <div class="container">
            <h1>ADD DEAL</h1>
            <hr>

            <label  ><b>USER 's ID</b></label>
            <form:input type="text" placeholder="Enter " path="userID" required="true"/>

            <label  ><b> BOOK 's ID </b></label>
            <form:input type="text" placeholder="Enter " path="bookID" required="true"/>

            <label  ><b>Borrowing Day</b></label>
            <form:input type="text" placeholder="Enter " path="borrowDay" required="true"/>

            <label  ><b>Return Day</b></label>
            <form:input type="text" placeholder="Enter " path="returnDay" />
            
            
            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="reset" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">ADD</button>
            </div>
        </div>
    </form:form>
    
    <!--<form action="" style="border:1px solid #ccc">
        <div class="container">
            <h1>ADD DEAL</h1>
            <hr>

            <label  ><b>USER 's ID</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b> BOOK 's ID </b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>Borrowing Day</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>Return Day</b></label>
            <input type="number" placeholder="Enter "  required>
            
            <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
            </label>
            
            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="button" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">ADD</button>
            </div>
        </div>
    </form>-->
    <a href="<%= request.getContextPath()%>/listdeal/${usingUser.userID}.html">
        <button>Return to Search Board </button>
    </a>
</body>
</html>
