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
import modelo.Entrada;

/**
 *
 * @author CGAO
 */
@WebServlet(name = "ControladorEntrada", urlPatterns = {"/ControladorEntrada"})
public class ControladorEntrada extends HttpServlet {

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
            out.println("<title>Servlet ControladorEntrada</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEntrada at " + request.getContextPath() + "</h1>");
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
        
        String id = request.getParameter("fIdEntrada");
        String idC = request.getParameter("fIdCelador");
        String idA = request.getParameter("fIdAprendiz");
        String idP = request.getParameter("fIdPortatil");
        String fechaE = request.getParameter("fFechaE");
        String fechaS = request.getParameter("fFechaS");
        String accion = request.getParameter("fAccion");
        
        int idEntrada=0;
        try {
            idEntrada = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
        }
        
        int idCelador=0;
        try {
            idCelador = Integer.parseInt(idC);
        } catch (NumberFormatException nfe) {
        }
        
        int idAprendiz=0;
        try {
            idAprendiz = Integer.parseInt(idA);
        } catch (NumberFormatException nfe) {
        }
        
        int idPortatil=0;
        try {
            idPortatil = Integer.parseInt(idP);
        } catch (NumberFormatException nfe) {
        }
        
        Entrada unaEntrada = new Entrada();
        unaEntrada.setIdEntrada(idEntrada);            
        unaEntrada.setIdCelador(idCelador);            
        unaEntrada.setIdAprendiz(idAprendiz);            
        unaEntrada.setIdPortatil(idPortatil);            
        unaEntrada.setFechaE(fechaE);
        unaEntrada.setFechaS(fechaS);
        
        String mensaje="";
        switch (accion.toLowerCase()) {
            case "insertar":
                unaEntrada.insertar();
                mensaje="Inserto Entrada";
            break;
            case "modificar":
                unaEntrada.modificar();
                mensaje="Modifico Entrada";
            break;
            case "eliminar":
                unaEntrada.eliminar();
                mensaje="Elimino Entrada";
            break;
            case "salida":
                unaEntrada.salida();
                mensaje="Salida";
            break;
        }
        request.getRequestDispatcher("/WEB-INF/formularioEntrada.jsp?msj="+mensaje).forward(request,response);
        
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
