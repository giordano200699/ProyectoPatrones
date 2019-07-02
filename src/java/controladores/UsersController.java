/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import BD.ConexionMongo;
import clases.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giordano
 */
@WebServlet(name = "UsersController", urlPatterns = {"/UsersController"})
public class UsersController extends HttpServlet {

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
            out.println("<title>Servlet UsersController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsersController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        if(request.getParameter("page").equals("showUsers")){
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Person> users =conexion.getPersons();
            conexion.cerrarConexion();
            request.setAttribute("usuarios",users);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("createUser")){
            request.getRequestDispatcher("administrador/users/createUser.jsp").forward(request, response);
        }else if(request.getParameter("page").equals("editUser")){
            ConexionMongo conexion = new ConexionMongo();
            Person person =conexion.getPerson(Integer.parseInt(request.getParameter("id")));
            conexion.cerrarConexion();
            request.setAttribute("persona",person);
            request.getRequestDispatcher("administrador/users/editUser.jsp").forward(request, response);
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
            String nombre = request.getParameter("nombreUser");
            String apellidos = request.getParameter("apellidosUser");
            int edad ;
            if(request.getParameter("edadUser")!=null && !request.getParameter("edadUser").equals("")){
                edad = Integer.parseInt(request.getParameter("edadUser"));
            }else{
                edad = 0;
            }
            String direccion = request.getParameter("direccionUser");
            String tipo = request.getParameter("tipoUser");
            String correo = request.getParameter("correoUser");
            String contrasenia = request.getParameter("contraseniaUser");
            ConexionMongo conexion = new ConexionMongo();
            //conexion.crearSede(nombre,direccion,aforo);
            conexion.createUser(nombre, apellidos, edad, direccion, tipo, correo, contrasenia);
            ArrayList<Person> users =conexion.getPersons();
            conexion.cerrarConexion();
            request.setAttribute("usuarios",users);
            //request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("PUT")){
            String nombre = request.getParameter("nombreUser");
            String apellidos = request.getParameter("apellidosUser");
            int edad ;
            if(request.getParameter("edadUser")!=null && !request.getParameter("edadUser").equals("")){
                edad = Integer.parseInt(request.getParameter("edadUser"));
            }else{
                edad = 0;
            }
            String direccion = request.getParameter("direccionUser");
            String tipo = request.getParameter("tipoUser");
            int personId = Integer.parseInt(request.getParameter("personId"));

            ConexionMongo conexion = new ConexionMongo();
            conexion.editPerson(nombre, apellidos, edad, direccion, tipo, personId);
            ArrayList<Person> users =conexion.getPersons();
            conexion.cerrarConexion();
            request.setAttribute("usuarios",users);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("DELETE")){
            int personId = Integer.parseInt(request.getParameter("personId"));

            ConexionMongo conexion = new ConexionMongo();
            conexion.deletePerson(personId);
            ArrayList<Person> users =conexion.getPersons();
            conexion.cerrarConexion();
            request.setAttribute("usuarios",users);
            request.getRequestDispatcher("administrador/users/showUsers.jsp").forward(request, response);
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
