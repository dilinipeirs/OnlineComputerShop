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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dilin
 */
@WebServlet(name = "ViewStockController", urlPatterns = {"/ViewStockController"})
public class ViewStockController extends HttpServlet {

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
            List<ItemDto> showItems = adminService.showItems();
            out.print("<center>"
                    + "<h1>Stock</h1>"
                    + "<table border=1>"
                    + " <tr>"
                    + "     <th>Item Code</th>"
                    + "     <th>Description</th>"
                    + "     <th>Qty on Hand</th>"
                    + "     <th>Unit Price (Rs.)</th>"
                    + " </tr>");
            
            
            int size = showItems.size();
            if (size != 0) {
                System.out.print("list size " + size);
                int pgs = size / 10;
                if (size % 10 != 0) {
                    pgs++;
                }
                System.out.println("final page count : " + pgs);
                String numString = (String) request.getParameter("pageNum");
                System.out.print(numString);
                if (numString == null) {
                    for (int i = 0; i < 10; i++) {
                        if (i > size - 1) {
                            break;
                        }
                       out.print("<tr>"
                        + "     <td>" + showItems.get(i).getItemCode()+ "</td>"
                        + "     <td>" + showItems.get(i).getDesc()+ "</td>"
                        + "     <td>" + showItems.get(i).getQtyOnHand()+ "</td>"
                        + "     <td>" + showItems.get(i).getUnitPrice()+ "</td>"
                        + "</tr>");
                    }
                } else {
                    Integer num = Integer.parseInt(numString);
                    for (int i = (num - 1) * 10; i < 10 * num; i++) {
                        if (i > size - 1) {
                            break;
                        }
                        out.print("<tr>"
                        + "     <td>" + showItems.get(i).getItemCode()+ "</td>"
                        + "     <td>" + showItems.get(i).getDesc()+ "</td>"
                        + "     <td>" + showItems.get(i).getQtyOnHand()+ "</td>"
                        + "     <td>" + showItems.get(i).getUnitPrice()+ "</td>"
                        + "</tr>");
                    }
                }
                out.print("</table>");
                   

                for (int i = 0; i < pgs; i++) {
                    out.print(" <a href='ViewStockController?pageNum=" + (i + 1) + "'>" + (i + 1) + "</a> ");

                }
                out.print("<a href='AdminDashboardJsp.jsp'>Home</a>");
                out.print("</center>");
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
