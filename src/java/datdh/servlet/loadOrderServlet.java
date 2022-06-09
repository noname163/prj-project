/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

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
public class loadOrderServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            int total = 0;
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            ArrayList<Product> products = new ArrayList<>();
            ArrayList<OrderInfor> orderIdList = orderDaO.getOrderInfor(Integer.toString(account.getAccountID()));
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
                total = total(products);
                session.setAttribute("total", total);
                session.setAttribute("product", products);
                
                session.setAttribute("orderDate", orderIdList.get(0).getOrderDate());
                response.sendRedirect("packagePage.jsp");
            } else {
                response.sendRedirect("packagePage.jsp");
            }
        }
    }

    private int total(ArrayList<Product> list) {
        int sum = 0;
        for (Product p : list) {
            if(p.getOrderStatus()==1)
                sum += p.getProductPrice() * p.getQuantity();
        }
        return sum;
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
            Logger.getLogger(loadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(loadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
