<%-- 
    Document   : UpdateBook
    Created on : Jun 17, 2019, 1:22:28 PM
    Author     : USER
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/add/small.css">
</head>
<body>
    
    <form:form cssStyle="border:1px solid #ccc" method="POST" commandName="updatingBook"
            action="${pageContext.servletContext.contextPath}/listbookupdated/${usingUser.userID}.html" >
        
        <div class="container">
            <h1>ALTER BOOK</h1>
            <hr>
            
            <label  ><b>BOOK ID</b></label>
            <form:input placeholder="Enter " type="number" path="bookID" required="true"/>
            
            <label  ><b>NAME</b></label>
            <form:input placeholder="Enter " path="bookName" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->

            <label  ><b> AUTHOR </b></label>
            <form:input placeholder="Enter " path="author" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->

            <label  ><b>PUBLISHER</b></label>
            <form:input placeholder="Enter " path="publisher" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->

            <label  ><b>DAY OF PUBLISH</b></label>
            <form:input placeholder="Enter " path="dayOfPublish" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->

            <label ><b>QUANTITY</b></label>
            <form:input type="number" path="quantity" required="true"/>
            <!--<input type="number" placeholder="Enter "  required>-->

            <label ><b>POSITION</b></label>
            <form:input placeholder="Enter " path="position" required="true"/>
            <!--<input type="text" placeholder="Enter "  required>-->
            
            
            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="reset" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">UPDATE</button>
            </div>
        </div>
        
    </form:form>
    
    
    <hr style="background: red solid; height: 0.3em; color: red">
    
    <form:form cssStyle="border:1px solid #ccc" method="post" commandName="deleteBook" 
               action="${pageContext.servletContext.contextPath}/listbookdeleted/${usingUser.userID}.html" >
        <h1>DELETE BOOK</h1>
        <hr>
        <label ><b>BOOK ID</b></label>
        <form:input type="text" placeholder="Enter " path="bookID" required="true" />
        
        <div class="clearfix">
            <button type="reset" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">DELETE</button>
        </div>
    </form:form>
    <!--<form action="" style="border:1px solid #ccc">
        <div class="container">
            <h1>UPDATE BOOK</h1>
            <hr>

            <label  ><b>BOOK 'S ID</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>NAME</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b> AUTHOR </b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>PUBLISHER</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>DAY OF PUBLISH</b></label>
            <input type="number" placeholder="Enter "  required>

            <label ><b>QUANTITY</b></label>
            <input type="number" placeholder="Enter "  required>

            <label ><b>POSITION</b></label>
            <input type="text" placeholder="Enter "  required>
            
            <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
            </label>
            
            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">UPDATE</button>
            </div>
        </div>
    </form> -->
    <a href="<%= request.getContextPath()%>/listbook/${usingUser.userID}.html">
        <button  type="button" >Return to Search Board</button>
    </a>
</body>

</html>
