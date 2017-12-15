<%-- 
    Document   : ejemplo
    Created on : 11/12/2017, 08:28:51 AM
    Author     : Enrique
--%>

<%@page import="co.edu.sena.ejemploproyecto.model.entities.Aprendiz"%>
<%@page import="co.edu.sena.ejemploproyecto.model.entities.ClienteHasRol"%>
<%@page import="javax.inject.Inject"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.sena.ejemploproyecto.model.entities.Cliente"%>
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

        <%
            request.getRequestDispatcher("/ClienteServlet").include(request, response);
            List<Cliente> lista = (List<Cliente>) request.getAttribute("cliente");
        %>

        <table style="width:100%" border="1">
            <tr>
                <th>Tipo Documento</th>
                <th>Numero Documento</th> 
                <th>Primer Nombre</th>
                <th>Segundo Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th>Correo</th>
                <th>Roles</th>
            </tr>
            <%for(Cliente cliente : lista){%>
            <tr>
                <td><% out.print(cliente.getClientePK().getTipoDocumento());%></td>
                <td><%=cliente.getClientePK().getNumeroDocumento()%></td>
                <td><%=cliente.getPrimerNombre()%></td>
                <td><%
                    if(cliente.getSegundoNombre()== null){
                        out.print("");
                    }else{
                        out.print(cliente.getSegundoNombre());
                        
                    }
                    
                    %></td>
                <td><%=cliente.getPrimerApellido()%></td>
                <td><%
                    if(cliente.getSegundoApellido()==null){
                        out.print("");
                    }else{
                        out.print(cliente.getSegundoApellido());
                    }
                    %></td>
                    
                <td><%=cliente.getUsuario().getCorreo()%></td>
                
                
                <td><%
                    for(ClienteHasRol rolCliente :cliente.getClienteHasRolCollection()){
                        out.print(rolCliente.getRol1().getDescripcion()+",");
                    }
                    
                    %></td>
                <td><%
                    for(Aprendiz a :cliente.getAprendizCollection()){
                        out.print(a.getAprendizPK().getFicha()+",");
                    }
                    
                    %></td>
                
               
                
            </tr>
            <%}%>
        </table>




    </body>
</html>
