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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dilin
 */
public class UserController extends HttpServlet {

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

            String action = request.getParameter("action");
            boolean res = false;

            if (action.equals("Register")) {
                String username = request.getParameter("username");
                String pass = request.getParameter("pass");
                String passCon = request.getParameter("passCon");
                String mobile = request.getParameter("mobile");

                if (pass.equals(passCon)) {
                    UserDto userDto = new UserDto(username, passCon, mobile);
                    res = adminService.saveUser(userDto);
                } else {
                    out.print("The passwords do not match!");
                    return;
                }

            } else if (action.equals("Remove")) {
                String username = request.getParameter("username");
                UserDto userDto = new UserDto();
                userDto.setUsername(username);
                res = adminService.removeUser(userDto);
            } else if (action.equals("Edit")) {
               String username = request.getParameter("username");
                String pass = request.getParameter("pass");
                String passCon = request.getParameter("passCon");
                String mobile = request.getParameter("mobile");

                if (pass.equals(passCon)) {
                    UserDto userDto = new UserDto(username, passCon, mobile);
                    res = adminService.editUser(userDto);
                } else {
                    out.print("The passwords do not match!");
                    return;
                }
            }

            if (action.equals("view")) {
                List<UserDto> users = adminService.showUsers();
                request.setAttribute("users", users);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewUserJsp.jsp");
                requestDispatcher.forward(request, response);

            } else {
                out.print((res) ? "success" : "failed");
            }
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
