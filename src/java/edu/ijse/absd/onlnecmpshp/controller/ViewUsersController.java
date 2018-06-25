/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.controller;

import edu.ijse.absd.onlnecmpshp.dto.UserDto;
import edu.ijse.absd.onlnecmpshp.service.AdminService;
import edu.ijse.absd.onlnecmpshp.service.ServiceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dilin
 */
@WebServlet(name = "ViewUsersController", urlPatterns = {"/ViewUsersController"})
public class ViewUsersController extends HttpServlet {

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
            AdminService adminService = (AdminService) ServiceFactory.getServiceFactory().getService(ServiceFactory.DaoEnum.ADMIN);
            List<UserDto> showUsers = adminService.showUsers();
            out.print("<center>"
                    + "<h1>System Users</h1>"
                    + "<table border=1>"
                    + " <tr>"
                    + "     <th>Username</th>"
                    + "     <th>Mobile</th>"
                    + " </tr>");
            for (UserDto showUser : showUsers) {
                out.print("<tr>"
                        + "     <td>" + showUser.getUsername() + "</td>"
                        + "     <td>" + showUser.getMobile() + "</td>"
                        + "</tr>");
            }
            out.print("</table>"
                    + "<a href='AdminDashboardJsp.jsp'>Home</a>"
                    + "</center>");

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
