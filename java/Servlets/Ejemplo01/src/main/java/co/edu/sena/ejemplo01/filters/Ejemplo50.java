/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.ejemplo01.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Enrique
 */
@WebFilter(filterName = "Ejemplo50", servletNames = {"Ejemplo23"}, dispatcherTypes = {DispatcherType.ASYNC,DispatcherType.INCLUDE, DispatcherType.FORWARD})
public class Ejemplo50 implements Filter {
    
 
    
    public Ejemplo50() {
    }    
    

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
       
        System.out.println("estoy en el metodo doFilter");
        chain.doFilter(request, response);
        
       
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
       
    }

  
}
