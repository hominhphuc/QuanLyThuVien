<%-- 
    Document   : UpdateDeal
    Created on : Jun 17, 2019, 1:23:37 PM
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

    <form:form cssStyle="border:1px solid #ccc" method="post" commandName="updatingDeal"
              action="${pageContext.servletContext.contextPath}/listdealupdated/${usingUser.userID}.html"  >
        
        <div class="container">
            <h1>UPDATE DEAL</h1>
            <hr>

            <label  ><b>USER 's ID</b></label>
            <form:input type="text" placeholder="Enter " path="" required="true"/>

            <label  ><b> BOOK 's ID </b></label>
            <form:input type="text" placeholder="Enter " path="" required="true"/>

            <label  ><b>Borrowing Day</b></label>
            <form:input type="text" placeholder="Enter " path="" required="true"/>

            <label  ><b>Return Day</b></label>
            <form:input type="text" placeholder="Enter " path="" />
            
            
            <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

            <div class="clearfix">
                <button type="reset" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">UPDATE</button>
            </div>
        </div>
    </form:form>
    
    <div style="background: red solid; height: 0.3em;"></div>
    
    <form:form cssStyle="border:1px solid #ccc" method="post" commandName="deleteDeal" 
               action="${pageContext.servletContext.contextPath}/listdealdeleted/${usingUser.userID}.html" >
        <h1>DELETE DEAL</h1>
        <hr>
        <label ><b>DEAL ID</b></label>
        <form:input type="text" placeholder="Enter " path="dealID" required="true" />
        
        <div class="clearfix">
            <button type="reset" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">DELETE</button>
        </div>
    </form:form>
    <!--<form action="" style="border:1px solid #ccc">
        <div class="container">
            <h1>UPDATE DEAL</h1>
            <hr>
            <label  ><b>USER 's ID</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>USER 's ID</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b> BOOK 's ID </b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>Borrowing Day</b></label>
            <input type="text" placeholder="Enter "  required>

            <label  ><b>Return Day</b></label>
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
    </form>-->
    <a href="<%= request.getContextPath()%>/listdeal/${usingUser.userID}.html">
        <button>Return to Search Board </button>
    </a>
</body>

</html>
