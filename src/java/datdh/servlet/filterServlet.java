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
public class filterServlet extends HttpServlet {

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
            ArrayList<OrderInfor> orders = new ArrayList<>();
            String cus = request.getParameter("cus");
            String orderStatus = request.getParameter("status");
            String productStatus = request.getParameter("status");
            String startDate = request.getParameter("start-date");
            String endDate = request.getParameter("end-date");
            String select = request.getParameter("select");
            String from = request.getParameter("from");
            String cate = request.getParameter("cate");
            HttpSession session = request.getSession();
            Account acc = (Account)session.getAttribute("account");
            ArrayList<Product> products = new ArrayList<>();
            request.setAttribute("sDate", startDate);
            request.setAttribute("eDate", endDate);
            request.setAttribute("cus", cus);
            if (from != null && from.equals("cart")) {
                if (select.equals("all")) {
                    ArrayList<OrderInfor> all = orderDaO.getAllOrder(Integer.toString(acc.getAccountID()));
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
                    }
                    session.setAttribute("product", products);
                } else if (!startDate.equals("") && !endDate.equals("")) {
                    System.out.println("AccId: "+ acc.getAccountID());
                    System.out.println("start date:" + startDate);
                    System.out.println("end date:" + endDate);
                    orders = orderDaO.getOrderByDate(startDate, endDate, Integer.toString(acc.getAccountID()));
                    if (!orders.isEmpty()) {
                        for (OrderInfor x : orders) {
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
                    }
                    session.setAttribute("product", products);
                }
                else if (orderStatus!=null) {
                    orders = orderDaO.getOrderByStatus(Integer.toString(acc.getAccountID()), orderStatus);
                    if (!orders.isEmpty()) {
                        for (OrderInfor x : orders) {
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
                    }
                    if(orders.isEmpty()){
                        out.print("Empty");
                    }
                    else{
                        session.setAttribute("product", products);
                    request.setAttribute("accId", acc.getAccountID());
                    request.setAttribute("status", orderStatus);
                    }
                }
                response.sendRedirect("packagePage.jsp");
            }else if(from != null && from.equals("productM")) {
                if (select.equals("all")) {
                    ArrayList<Product> products1 = ProductDaO.getAllProducts() ;
                    session.setAttribute("p", products1);
                
                } else if (cate!=null&&!cate.equals("")) {
                    ArrayList<Product> products1 = ProductDaO.getProduct(cate) ;
                    session.setAttribute("p", products1);
                }
                 else if (productStatus!=null&&!productStatus.equals("")) {
                    ArrayList<Product> products1 = ProductDaO.getProductByStatus(productStatus) ;
                    System.out.println("productStatus: " + productStatus);
                    session.setAttribute("p", products1);
                }
                response.sendRedirect("productManage.jsp");
            }
            else {
                if (select.equals("all")) {
                    ArrayList<OrderInfor> all = orderDaO.getAllOrders();
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
                    }
                    session.setAttribute("product", products);
                } else if (startDate!=null&&endDate!=null&&!startDate.equals("") && !endDate.equals("")) {
                    System.out.println("AccId: "+ acc.getAccountID());
                    System.out.println("start date:" + startDate);
                    System.out.println("end date:" + endDate);
                    orders = orderDaO.getOrdersByDate(startDate, endDate);
                    if (!orders.isEmpty()) {
                        for (OrderInfor x : orders) {
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
                    }
                    session.setAttribute("product", products);
                } else if (cus!=null&&!cus.equals("")) {
                    orders = orderDaO.getOrderById(cus);
                    if (!orders.isEmpty()) {
                        for (OrderInfor x : orders) {
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
                    }
                    session.setAttribute("product", products);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(filterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(filterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(filterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(filterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
