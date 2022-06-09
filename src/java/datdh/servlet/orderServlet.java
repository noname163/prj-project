/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.orderDaO;
import datdh.dto.Account;
import datdh.dto.OrderInfor;
import datdh.dto.Product;
import datdh.dto.orderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class orderServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("tmpCart");
            Account account = (Account) session.getAttribute("account");
            if (account == null) {
                request.setAttribute("mess", "Login to continue shopping.");
                session.setAttribute("from", "addToCart");
                request.getRequestDispatcher("LoginServlet").forward(request, response);
            } else {
                orderDaO.insertOrder(Integer.toString(account.getAccountID()));
                ArrayList<OrderInfor> order = orderDaO.getOrderInfor(Integer.toString(account.getAccountID()));
                for (int i = 0; i < order.size(); i++) {
                    orderDetail detail = orderDaO.getOrderDetail(Integer.toString(order.get(i).getOrderId()));
                    if (detail == null) {
                        for (Product x : list) {
                            orderDaO.insertOrderDetail(Integer.toString(order.get(i).getOrderId()),
                                    Integer.toString(x.getProductId()),
                                    Integer.toString(x.getQuantity()));
                        }
                    }
                }
                session.removeAttribute("tmpCart");
                session.removeAttribute("order");
                session.removeAttribute("amount");
                session.removeAttribute("total");
                response.sendRedirect("loadOrder");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
