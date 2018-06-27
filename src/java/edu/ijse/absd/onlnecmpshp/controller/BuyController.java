/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.absd.onlnecmpshp.controller;

import edu.ijse.absd.onlnecmpshp.dto.ItemDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dilin
 */
@WebServlet(name = "BuyController", urlPatterns = {"/BuyController"})
public class BuyController extends HttpServlet {

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
            String code = request.getParameter("code");
            int qty = Integer.parseInt(request.getParameter("qty"));
            System.out.println(code + qty);
            ServletContext servletContext = request.getServletContext();
            List<ItemDto> items = (List<ItemDto>) servletContext.getAttribute("itemList");

            ItemDto item = null;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItemCode().equals(code)) {
                    items.get(i).setQtyOnHand(items.get(i).getQtyOnHand() - qty);
                    item = new ItemDto(code, items.get(i).getDesc(), qty, items.get(i).getUnitPrice());
                    break;
                }
            }
            servletContext.setAttribute(code, items);

            HttpSession session = request.getSession();
            ArrayList<ItemDto> cart = (ArrayList<ItemDto>) session.getAttribute("cart");
            if (null == cart) {
                cart = new ArrayList<>();
                System.out.println("item not there and added to cart");
                cart.add(item);
            } else {
                boolean added = false;
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i).getItemCode().equals(code)) {
                        added = true;
                        System.out.println("item already there");
                        cart.get(i).setQtyOnHand(cart.get(i).getQtyOnHand() + qty);
                        System.out.println("set new qty");
                        break;
                    }
                }
                if (!added) {
                    System.out.println("item not there and added to cart");
                    cart.add(item);
                }
            }
            session.setAttribute("cart", cart);
            double total = 0;

            out.print("<center>"
                    + "<h1>My Cart</h1>"
                    + "Number of item types in cart : " + cart.size()
                    + "<table border=1>"
                    + " <tr>"
                    + "     <th>Item Code</th>"
                    + "     <th>Description</th>"
                    + "     <th>Qty</th>"
                    + "     <th>Unit Price (Rs.)</th>"
                    + "     <th>Amount (Rs.)</th>"
                    + "     <th>Remove 1 item</th>"
                    + " </tr>");
            for (ItemDto showItem : cart) {

                double amount = showItem.getQtyOnHand() * showItem.getUnitPrice();
                total += amount;

                out.print("<tr>"
                        + "     <td>" + showItem.getItemCode() + "</td>"
                        + "     <td>" + showItem.getDesc() + "</td>"
                        + "     <td>" + showItem.getQtyOnHand() + "</td>"
                        + "     <td>" + showItem.getUnitPrice() + "</td>"
                        + "     <td>" + amount + "</td>"
                        + "     <td><a href='RemoveController?code='" + showItem.getItemCode() + "'>Remove</a></td>"
                        + "</tr>");
            }
            out.print("</table>"
                    + "<br/>"
                    + "Total Price = Rs." + total
                    + "<br/>"
                    + "<a href='ItemShowRoomController'>Continue Shopping</a>"
                    + "<br/>"
                    + "<a href='PurchaseController'>Purchase these Goods</a>"
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
