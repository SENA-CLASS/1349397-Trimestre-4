/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejerciciosession.controller;

import co.edu.sena.ejerciciosession.controller.ejbs.UsuarioFacade;
import co.edu.sena.ejerciciosession.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Enrique
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Inject
    UsuarioFacade usuarioFacade;

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
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("password");
        Usuario user = null;
        if (usuario != null) {
            user = usuarioFacade.find(usuario);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");

            if (user != null) {
                if (usuario.equals(user.getDocumento())) {
                    if (pass.equals(user.getPassword())) {
                        request.getSession(true);
                        request.getSession().setAttribute("usuario", user.toString());
                        out.println("hola usuario<br>");
                        out.println("Atributos de la session<br>");
                        Enumeration<String> listaAtributos = request.getSession().getAttributeNames();
                        while (listaAtributos.hasMoreElements()) {
                            String nextElement = listaAtributos.nextElement();
                            out.println("Atriuto: " + nextElement + " Contenido: " + request.getSession().getAttribute(nextElement));

                        }
                        Cookie c1 = new Cookie("hola", "afsd fas");
                        response.addCookie(c1);

                    } else {
                        out.println("ojo su contseña no es valida");
                        request.getSession(false);
                    }

                } else {
                    out.println("ese usuario no es valido");
                    request.getSession(false);
                }
            } else {
                out.println("ese usuario no es valido");
                request.getSession(false);
            }

            out.println("<form action=\"Logout\" method=\"POST\">\n"
                    + "            <input type=\"submit\" value=\"Submit\">\n"
                    + "        </form>");

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
