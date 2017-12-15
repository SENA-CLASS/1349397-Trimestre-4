<%-- 
    Document   : ejemplo03
    Created on : 12/12/2017, 08:55:00 AM
    Author     : Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        de esta pagina debe ir al error

        <%
            int a=5/0;
        %>


    </body>
</html>
