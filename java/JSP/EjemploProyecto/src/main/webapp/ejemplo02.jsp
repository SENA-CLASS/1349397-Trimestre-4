<%-- 
    Document   : ejemplo02
    Created on : 12/12/2017, 06:55:58 AM
    Author     : Enrique
--%>

<%@page import="co.edu.sena.ejemploproyecto.model.entities.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.ejemploproyecto.controller.ejbs.ClienteFacade"%>
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
            @EJB
            ClienteFacade clienteFacade = new ClienteFacade();
            // no es una buena practica por que los ejbs deben estar en los servlets para el mvc
            // ademas que el contenedor no sabe que hacer con la anotacion @EJB
            %>
            
            
            <%
                List<Cliente> lista = clienteFacade.findAll();
                for(Cliente c: lista){
                    out.print(c.getPrimerApellido()+"<br>");
                    
                }
            %>
        
    </body>
</html>
