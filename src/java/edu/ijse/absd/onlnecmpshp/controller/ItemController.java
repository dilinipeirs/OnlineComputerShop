/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.controller;

import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
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
public class ItemController extends HttpServlet {

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

            if (action.equals("Add")) {
                String code = request.getParameter("code");
                String desc = request.getParameter("desc");
                double price = Double.parseDouble(request.getParameter("price"));
                int qty = Integer.parseInt(request.getParameter("qty"));

                ItemDto itemDto = new ItemDto(code, desc, qty, price);

                res = adminService.saveItem(itemDto);
            } else if (action.equals("Remove")) {
                String code = request.getParameter("code");
                ItemDto itemDto = new ItemDto();
                itemDto.setItemCode(code);
                res = adminService.deleteItem(itemDto);
            } else if (action.equals("Edit")) {
                String code = request.getParameter("code");
                String desc = request.getParameter("desc");
                double price = Double.parseDouble(request.getParameter("price"));
                int qty = Integer.parseInt(request.getParameter("qty"));

                ItemDto itemDto = new ItemDto(code, desc, qty, price);

                res = adminService.editItem(itemDto);
            } 
            
            
            if (action.equals("view")) {
                List<ItemDto> viewItems = adminService.showItems();
                request.setAttribute("items", viewItems);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewItemJsp.jsp");
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
