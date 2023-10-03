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
import modelo.Portatil;

/**
 *
 * @author CGAO
 */
@WebServlet(name = "ControladorPortatil", urlPatterns = {"/ControladorPortatil"})
public class ControladorPortatil extends HttpServlet {

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
            out.println("<title>Servlet ControladorPortatil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPortatil at " + request.getContextPath() + "</h1>");
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
        
        String id = request.getParameter("fIdPortatil");
        String marca = request.getParameter("fMarca");
        String codigo = request.getParameter("fCodigo");
        String accion = request.getParameter("fAccion");
        
        int idPortatil=0;
        try {
            idPortatil = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
        }
        
        Portatil unaPortatil = new Portatil();
        unaPortatil.setIdPortatil(idPortatil);            
        unaPortatil.setMarca(marca);
        unaPortatil.setCodigo(codigo);
        
        String mensaje="";
        switch (accion.toLowerCase()) {
            case "insertar":
                unaPortatil.insertar();
                mensaje="Inserto Celador";
            break;
            case "modificar":
                unaPortatil.modificar();
                mensaje="Modifico Celador";
            break;
            case "eliminar":
                unaPortatil.eliminar();
                mensaje="Elimino Celador";
            break;
        }
        request.getRequestDispatcher("/WEB-INF/formularioPortatil.jsp?msj="+mensaje).forward(request,response);
        
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
