<%-- 
    Document   : ejemplo04
    Created on : 14/12/2017, 09:25:11 AM
    Author     : Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jspf" %>

<%
    for (int i = 1; i <= 10; i++) {
            out.print(i+"<br>");
        }

%>

<p></p>



<%@include file="footer.jspf" %>
