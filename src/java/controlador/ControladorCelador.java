/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Celador;

/**
 *
 * @author CGAO
 */
@WebServlet(name = "ControladorCelador", urlPatterns = {"/ControladorCelador"})
public class ControladorCelador extends HttpServlet {

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
            out.println("<title>Servlet ControladorCelador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCelador at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("fIdCelador");
        String nombre = request.getParameter("fNombre");
        String ident = request.getParameter("fIdent");
        String accion = request.getParameter("fAccion");
        
        int idCelador=0;
        try {
            idCelador = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
        }
        
        Celador unaCelador = new Celador();
        unaCelador.setIdCelador(idCelador);            
        unaCelador.setNombre(nombre);
        unaCelador.setIdent(ident);
        
        String mensaje="";
        switch (accion.toLowerCase()) {
            case "insertar":
                unaCelador.insertar();
                mensaje="Inserto Celador";
            break;
            case "modificar":
                unaCelador.modificar();
                mensaje="Modifico Celador";
            break;
            case "eliminar":
                unaCelador.eliminar();
                mensaje="Elimino Celador";
            break;
        }
        request.getRequestDispatcher("/WEB-INF/formularioCelador.jsp?msj="+mensaje).forward(request,response);
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
