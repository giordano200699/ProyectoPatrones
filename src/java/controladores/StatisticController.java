/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import BD.ConexionMongo;
import clases.ClassIteratorHash;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giordano
 */
@WebServlet(name = "StatisticController", urlPatterns = {"/StatisticController"})
public class StatisticController extends HttpServlet {

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
            out.println("<title>Servlet StatisticController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StatisticController at " + request.getContextPath() + "</h1>");
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
        if(request.getParameter("parametro").equals("CompetitionStatistic")){
            ConexionMongo conexion = new ConexionMongo();
            //Competition competition =conexion.getCompetition(Integer.parseInt(request.getParameter("id")));
            //ArrayList<Competitor> competitors =conexion.getCompetitorsForCompetition(competition.getCompetitionId());
            //Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            //Person person = (Person)request.getSession().getAttribute("person");
            Hashtable<Integer, String> competitionH = conexion.getCompetitionDiccionary();
            ArrayList<ClassIteratorHash> lista = conexion.topCompetition();
            conexion.cerrarConexion();
            //request.setAttribute("competition",competition);
            //request.setAttribute("competitors",competitors);
            request.setAttribute("lista",lista);
            request.setAttribute("competitionH",competitionH);
            request.getRequestDispatcher("administrador/statistics/showStatistic.jsp").forward(request, response);
        }
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
