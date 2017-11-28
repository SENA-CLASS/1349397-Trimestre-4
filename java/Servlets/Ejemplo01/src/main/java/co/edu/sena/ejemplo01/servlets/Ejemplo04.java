/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplo01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Enrique
 */
@WebServlet(name = "Ejemplo04", urlPatterns = {"/Ejemplo04"})
public class Ejemplo04 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ejemplo04</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ejemplo04 at " + request.getContextPath() + "</h1>");
            out.println("<h1>El nobmre que paso como atributo es:  " + request.getParameter("nombre") + "</h1>");
            request.setAttribute("perrito", "pilli");
            Enumeration<String> listaAtributos = request.getAttributeNames();
            
            while(listaAtributos.hasMoreElements()){
            String tempAtributeName = listaAtributos.nextElement();
             out.println("<h1>Atributo: " + tempAtributeName + "</h1><br>");
             out.println("<h1>Contenido Atributo: " + request.getAttribute(tempAtributeName)+ "</h1>");
            }
            
            out.println("<br><h1>tipo de contenido del cuerpo " + request.getCharacterEncoding() + "</h1>");
            
            Enumeration<String> parametros = request.getParameterNames();
            while(parametros.hasMoreElements()){
            String tempParameter =parametros.nextElement();
                out.println("Parametro nombre: " + tempParameter + "<br>");
             out.println("Contenido Parametro: " + request.getParameter(tempParameter)+"<br>");
            }
            out.println("<br><h1>nombre del server" + request.getServerName() + "</h1>");
            out.println("<br><h1>recibida la peticion desde: " + request.getServerName()+":"+request.getServerPort() + "</h1>");
            
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
