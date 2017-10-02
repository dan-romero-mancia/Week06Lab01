<%-- 
    Document   : login
    Created on : Oct 2, 2017, 8:16:11 AM
    Author     : 752039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Remember Me Login Page</h1>
        
        <form action="login" method="POST">
            <div>User name: <input type="text" name="username" value="${username}"></div>
            <div>Password: <input type="password" name="password"></div>
            <input type="submit" value="Submit">
        </form>
        
        <div><input type="checkbox" name="remember"> Remember me</div>
        ${errorMessage}
        ${logout}
        
    </body>
</html>
