<%-- 
    Document   : ejemplo01
    Created on : 11/12/2017, 07:13:59 AM
    Author     : Enrique
--%>

<%@page import="javax.ejb.EJB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%! 
            private int a; 
            private String nombre;
                
        %>
        
        
        <% //Scriptlet
            int numero=5;
            for(int i = 1; i<=10;i++){
            out.println(numero+" * "+i+" = "+(numero*i)+"<br>"   );
            }
        %>

        <% //Scriptlet
            int numero2=5;
            for(int i = 1; i<=10;i++){
                
        %>
        <%=numero2%> * <%=i%> = <%=(numero2*i)%><br>
        <%}%>
        
        
        
        
        
    </body>
</html>
