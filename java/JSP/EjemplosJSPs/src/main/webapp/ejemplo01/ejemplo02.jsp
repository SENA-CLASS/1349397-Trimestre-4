<%-- 
    Document   : ejemplo02
    Created on : 12/12/2017, 06:48:48 AM
    Author     : Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" info="este es un ejemplo de jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
           pageContext.setAttribute("nombre", "hernando");
           
            if(pageContext.getAttribute("nombre")!=null){
                out.print(pageContext.getAttribute("nombre"));
            }else{
                pageContext.setAttribute("nombre", "hernando");
            }
            
            
        %>
    </body>
</html>
