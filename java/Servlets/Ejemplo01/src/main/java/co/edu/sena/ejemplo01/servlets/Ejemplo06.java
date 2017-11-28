/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplo01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Enrique
 */
@WebServlet(name = "Ejemplo06", urlPatterns = {"/Ejemplo06"})
public class Ejemplo06 extends HttpServlet {

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
            out.println("<title>Servlet Ejemplo06</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Manejo de Parametros</h1>");
            //ejemplo de getParametet
            out.println(request.getParameter("primerNombre"));
            //ejemplo de getParameterNames
            Enumeration<String> nombresParametros = request.getParameterNames();
            while(nombresParametros.hasMoreElements()){
                String nombre = nombresParametros.nextElement();
                 out.println("<br>Nombre parametro: "+nombre);
                 out.println("  Contenido parametro: "+request.getParameter(nombre));
                 
            }
            //getParametervalues
            
            String [] valoresParametros =request.getParameterValues("lenguajes");
            if(valoresParametros != null)
            for (String valoresParametro : valoresParametros) {
                out.println("<br> lo que tienes el parametro lenguajes "+valoresParametro);
            }
             out.println("<br>");
               
            // ejemplo para collections tipo map
            Map<String, String[]> coleccionParametros =request.getParameterMap();
            for (String key : coleccionParametros.keySet()) {
                out.println("<br> Nombre Parameto colección: "+key);
                for (String valorParametro : coleccionParametros.get(key)) {
                    out.println("<br>Valor: "+valorParametro);
                }
            }
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            out.println(response.getBufferSize()+" Bytes");
            response.setStatus(codigo);
            
            
            out.println("<br> el tipo de contenido que se envio es: "+request.getContentType());
            
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
