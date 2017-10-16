<%-- 
    Document   : login
    Created on : Oct 16, 2017, 8:10:28 AM
    Author     : 752039
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="login"%>

<%-- any content can be specified here e.g.: --%>
<form action="login" method="POST">
    <div>User name: <input type="text" name="username" value="${username}"></div>
    <div>Password: <input type="password" name="password"></div>
    <input type="submit" value="Submit">
    <div><input type="checkbox" name="remember" value="remember" ${remember}> Remember me</div>
</form>

${errorMessage}
${logout}