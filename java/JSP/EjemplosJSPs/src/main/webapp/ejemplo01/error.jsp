<%-- 
    Document   : error
    Created on : 12/12/2017, 09:32:32 AM
    Author     : Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>estoy en la pagina de error</h1>
        <%
            out.print("Error: "+exception.getMessage()+"<br>");
            out.print("Traza: <br>");
            StackTraceElement [] traza = exception.getStackTrace();
            for (int i = 0; i < traza.length; i++) {
                    out.print(traza[i]+"<br>");
                }
            %>
            
    </body>
</html>
