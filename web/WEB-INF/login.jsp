<%-- 
    Document   : login
    Created on : Oct 2, 2017, 8:16:11 AM
    Author     : 752039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="login" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Remember Me Login Page</h1>
        
        <login:login/>
        
        <sait:debug>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>
    </body>
</html>
