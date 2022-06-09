/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.AccountDaO;
import datdh.dao.ProductDaO;
import datdh.dao.orderDaO;
import datdh.dto.Account;
import datdh.dto.OrderInfor;
import datdh.dto.Product;
import datdh.dto.orderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class AdminServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            ArrayList<OrderInfor> all = orderDaO.getAllOrders();
            ArrayList<Product> products = new ArrayList<>();
            Account acc = (Account) session.getAttribute("account");
            if (acc == null || acc != null && acc.getRole() != 0) {
                request.setAttribute("mess", "Login to continue.");
                request.getRequestDispatcher("LoginServlet?from=adminPage").forward(request, response);
            } else {
                if (!all.isEmpty()) {
                    for (OrderInfor x : all) {
                        ArrayList<orderDetail> orderDetailsList = orderDaO.getOrderDetails(Integer.toString(x.getOrderId()));
                        for (orderDetail oD : orderDetailsList) {
                            Product product = ProductDaO.getProductById(Integer.toString(oD.getProductId()));
                            product.setQuantity(oD.getQuantity());
                            product.setOrderDate(x.getOrderDate());
                            product.setOrderId(x.getOrderId());
                            product.setOrderStatus(x.getOrderStatus());
                            product.setAccId(x.getAccId());
                            products.add(product);
                        }
                    }
                    session.setAttribute("product", products);
                } else {
                    session.setAttribute("product", all);
                }

                response.sendRedirect("adminPage.jsp");
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
