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
import java.sql.SQLException;
import java.util.ArrayList;
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
public class userServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            String fullName = request.getParameter("fullName");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Account sessionAccount = (Account) session.getAttribute("account");
            Account account = AccountDaO.getAccountById(Integer.toString(sessionAccount.getAccountID()));
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<OrderInfor> orderIdList = orderDaO.getOrderInfor(Integer.toString(sessionAccount.getAccountID()));

            if (action!=null&&action.equals("saveChange")) {
                if (!email.equals(account.getEmail()) && AccountDaO.checkAccount(email)) {
                    session.setAttribute("alter", "This email already used.");
                    response.sendRedirect("editUserProfile.jsp");
                } else {
                    AccountDaO.changeAccount(Integer.toString(account.getAccountID()), fullName, phone, email);
                    session.setAttribute("account", AccountDaO.getAccountById(Integer.toString(sessionAccount.getAccountID())));
                    request.getRequestDispatcher("userProfile.jsp").forward(request, response);
                }
            } else {
                if (!orderIdList.isEmpty()) {
                    for (OrderInfor x : orderIdList) {
                        ArrayList<orderDetail> orderDetailsList = orderDaO.getOrderDetails(Integer.toString(x.getOrderId()));
                        for (orderDetail oD : orderDetailsList) {
                            Product product = ProductDaO.getProductById(Integer.toString(oD.getProductId()));
                            product.setQuantity(oD.getQuantity());
                            product.setOrderDate(x.getOrderDate());
                            product.setOrderId(x.getOrderId());
                            product.setOrderStatus(x.getOrderStatus());
                            products.add(product);
                        }
                    }
                }
                session.setAttribute("items", products.size());
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
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
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
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
