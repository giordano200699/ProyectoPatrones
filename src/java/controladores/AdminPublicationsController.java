/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import BD.ConexionMongo;
import clases.Competition;
import clases.Competitor;
import clases.Person;
import clases.Publication;
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
@WebServlet(name = "AdminPublicationsController", urlPatterns = {"/AdminPublicationsController"})
public class AdminPublicationsController extends HttpServlet {

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
            out.println("<title>Servlet AdminPublicationsController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminPublicationsController at " + request.getContextPath() + "</h1>");
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
        if(request.getParameter("parametro").equals("showCompetition")){
            ConexionMongo conexion = new ConexionMongo();
            Competition competition =conexion.getCompetition(Integer.parseInt(request.getParameter("id")));
            ArrayList<Competitor> competitors =conexion.getCompetitorsForCompetition(competition.getCompetitionId());
            Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            Person person = (Person)request.getSession().getAttribute("person");
            Hashtable<Integer, Integer> cReactionsH = conexion.getReactionsCompetitorOfMe(person.getPersonId());
            conexion.cerrarConexion();
            request.setAttribute("competition",competition);
            request.setAttribute("competitors",competitors);
            request.setAttribute("personsH",personsH);
            request.setAttribute("cReactionsH",cReactionsH);
            request.getRequestDispatcher("administrador/publications/showCompetition.jsp").forward(request, response);
        }else if(request.getParameter("parametro").equals("getPublications")){
            int personId = Integer.parseInt(request.getParameter("personId"));
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));
            int parentId = Integer.parseInt(request.getParameter("parentId"));
            String txtPublication = request.getParameter("txtPublication");
            ConexionMongo conexion = new ConexionMongo();
            conexion.createPublication(txtPublication, personId, competitionId,parentId);
            ArrayList<Publication> publications;
            if(parentId==0){
                publications =conexion.getPublications(competitionId);
            }else{
                publications =conexion.getPublicationsChildren(parentId);
            }
            
            Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            Hashtable<Integer, Integer> pReactionsH = conexion.getReactionsPublicationOfMe(personId);
            conexion.cerrarConexion();
            /*String employeeJsonString = new Gson().toJson(1);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            out.flush();*/
            request.setAttribute("publications",publications);
            request.setAttribute("personsH",personsH);
            request.setAttribute("pReactionsH",pReactionsH);
            if(parentId==0){
                request.getRequestDispatcher("administrador/publications/publicationsAjax.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("user/competition/publicationsChildrenAjax.jsp").forward(request, response);
            }
            
            
        }else if(request.getParameter("parametro").equals("getPublicationsAlone")){
            int personId = Integer.parseInt(request.getParameter("personId"));
            int competitionId = Integer.parseInt(request.getParameter("competitionId"));
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Publication> publications =conexion.getPublications(competitionId);
            Hashtable<Integer, String> personsH = conexion.getPersonsDiccionary();
            Hashtable<Integer, Integer> pReactionsH = conexion.getReactionsPublicationOfMe(personId);
            conexion.cerrarConexion();
            request.setAttribute("publications",publications);
            request.setAttribute("personsH",personsH);
            request.setAttribute("pReactionsH",pReactionsH);
            request.getRequestDispatcher("administrador/publications/publicationsAjax.jsp").forward(request, response);
        }else if(request.getParameter("parametro").equals("reportPublication")){
            int personId = Integer.parseInt(request.getParameter("personId"));
            int publicationId = Integer.parseInt(request.getParameter("publicationId"));
            
            ConexionMongo conexion = new ConexionMongo();
            conexion.reportPublication(personId, publicationId);
            conexion.cerrarConexion();
            
            processRequest(request, response);
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
