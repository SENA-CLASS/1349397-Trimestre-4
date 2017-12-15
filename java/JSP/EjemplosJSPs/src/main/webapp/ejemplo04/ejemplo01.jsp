<%-- 
    Document   : ejemplo01
    Created on : 14/12/2017, 09:39:26 AM
    Author     : Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach begin="1" end="10" step="1" >
            hola mundo <br>
        </c:forEach>

        <%
            for (int i = 1; i <= 10; i++) {
                out.print("hola mundo");
            }
            


        %>

        <h1>Hello World!</h1>
    </body>
</html>
