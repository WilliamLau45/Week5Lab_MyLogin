<%-- 
    Document   : home
    Created on : Oct 9, 2022, 8:51:25 PM
    Author     : William Lau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Welcome ${user.getUsername()}, you are finally here! :D</h2>
        <br>
        <a href="login?logout">Log Out</a>
    </body>
</html>
