/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import BD.ConexionMongo;
import clases.Competition;
import clases.Sede;
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
@WebServlet(name = "CompetitionsController", urlPatterns = {"/CompetitionsController"})
public class CompetitionsController extends HttpServlet {

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
            out.println("<title>Servlet CompetitionsController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompetitionsController at " + request.getContextPath() + "</h1>");
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
        if(request.getParameter("page").equals("showCompetitions")){
            //ArrayList<Person> users =conexion.getPersons();
            //request.setAttribute("usuarios",users);
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Competition> competitions =conexion.getCompetitions();
            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
            conexion.cerrarConexion();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("createCompetition")){
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Sede> sedes =conexion.obtenerSedes();
            System.out.println(sedes);
            conexion.cerrarConexion();
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/competitions/createCompetition.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("editCompetition")){
            ConexionMongo conexion = new ConexionMongo();
            Competition competition =conexion.getCompetition(Integer.parseInt(request.getParameter("id")));
            ArrayList<Sede> headquarters =conexion.obtenerSedes();
            conexion.cerrarConexion();
            request.setAttribute("competition",competition);
            request.setAttribute("headquarters",headquarters);
            request.getRequestDispatcher("administrador/competitions/editCompetition.jsp").forward(request, response);
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
        //processRequest(request, response);
        if(request.getParameter("_method").equals("POST")){
            String title = request.getParameter("titleCompetition");
            String category = request.getParameter("categoryCompetition");
            int headquarterId = Integer.parseInt(request.getParameter("headquarterCompetition"));
            ConexionMongo conexion = new ConexionMongo();
            conexion.createCompetition(title, category, headquarterId);
            ArrayList<Competition> competitions =conexion.getCompetitions();
            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
            conexion.cerrarConexion();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        
        }else if(request.getParameter("_method").equals("PUT")){
            String title = request.getParameter("titleCompetition");
            String category = request.getParameter("categoryCompetition");
            int headquarterId = Integer.parseInt(request.getParameter("headquarterCompetition"));
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));

            ConexionMongo conexion = new ConexionMongo();
            conexion.editCompetition(title, category, headquarterId,competitionId);
            ArrayList<Competition> competitions =conexion.getCompetitions();
            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
            conexion.cerrarConexion();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("DELETE")){
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));

            ConexionMongo conexion = new ConexionMongo();
            conexion.deleteCompetition(competitionId);
            ArrayList<Competition> competitions =conexion.getCompetitions();
            Hashtable<Integer, String> headquartersH = conexion.getHeadquartersDiccionary();
            conexion.cerrarConexion();
            request.setAttribute("competitions",competitions);
            request.setAttribute("headquartersH",headquartersH);
            request.getRequestDispatcher("administrador/competitions/showCompetitions.jsp").forward(request, response);
        }
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
