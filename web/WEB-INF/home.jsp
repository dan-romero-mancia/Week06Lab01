<%-- 
    Document   : home
    Created on : Oct 2, 2017, 8:31:31 AM
    Author     : 752039
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <div>Hello ${username}</div>
        <a href="login?action=logout">Log out</a>
    </body>
    <br/>
    <sait:debug>
        Remote Host: ${pageContext.request.remoteHost}<br />
        Session ID: ${pageContext.session.id}
    </sait:debug>
</html>
