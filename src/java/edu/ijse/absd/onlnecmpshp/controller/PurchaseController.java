/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.controller;

import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import edu.ijse.absd.onlnecmpshp.service.CustomerService;
import edu.ijse.absd.onlnecmpshp.service.ServiceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "PurchaseController", urlPatterns = {"/PurchaseController"})
public class PurchaseController extends HttpServlet {

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
            ArrayList<ItemDto> cart = (ArrayList<ItemDto>) request.getSession().getAttribute("cart");
            System.out.println("cart availability : "+cart);
            CustomerService customerService = (CustomerService)ServiceFactory.getServiceFactory().getService(ServiceFactory.DaoEnum.CUSTOMER);
            System.out.println("cart sze ; "+cart.size());
            if (cart.size() == 0 || null == cart) {
                out.print("Your cart is empty");
                return;
            }
            boolean purchaseGoods = customerService.purchaseGoods((List<ItemDto>)(request.getServletContext().getAttribute("itemList")));
            if (purchaseGoods) {
                System.out.println(purchaseGoods);
                out.print("You have Successfully Purchased the Goods<br/>");
                cart.clear();
                request.getSession().setAttribute("cart", cart);
                out.print("<a href='ItemShowRoomController'>Home</a>");
            } else {
                out.print("There was an Error Purchasing the Goods"
                        + "<br/>"
                        + "<a href='ItemShowRoomController'>Home</a>");
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
