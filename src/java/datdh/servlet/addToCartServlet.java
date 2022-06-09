/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.ProductDaO;
import datdh.dto.Account;
import datdh.dto.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class addToCartServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            int quantity = 1;
            int total = 0;
            String pId = request.getParameter("pId");
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            HashMap<String, Integer> amount = new HashMap<String, Integer>();
            HashMap<String, Integer> sessionAmount = (HashMap<String, Integer>) session.getAttribute("amount");
            ArrayList<Product> list = new ArrayList<Product>();
            ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("tmpCart");
            HashMap<String, Product> product = new HashMap<>();
            HashMap<String, Product> sessionProduct = (HashMap<String, Product>) session.getAttribute("order");
            Product id = ProductDaO.getProductById(pId);
            
            if (id == null) {
                response.sendRedirect("errosPage.jsp");
            } else {
                ArrayList<Product> top3Products = ProductDaO.suggestionProducts(pId);
                session.setAttribute("suggestion", top3Products);
                if (cart == null) {
                    id.setQuantity(quantity);
                    list.add(id);
                    product.put(pId, id);
                    amount.put(pId, quantity);
                    total = total(list);
                    session.setAttribute("tmpCart", list);
                    session.setAttribute("order", product);
                    session.setAttribute("amount", amount);
                    request.setAttribute("amount", quantity);
                } else {
                    if (action.equals("plush")) {
                        quantity = sessionAmount.get(pId) + 1;
                        id.setQuantity(quantity);
                        sessionProduct.put(pId, id);
                        for (Product x : sessionProduct.values()) {
                            list.add(x);
                        }
                        total = total(list);
                        sessionAmount.put(pId, quantity);
                        session.setAttribute("tmpCart", list);
                        session.setAttribute("amount1", quantity);
                        session.setAttribute("amount", sessionAmount);
                    } else if (action.equals("subtract")) {
                        quantity = sessionAmount.get(pId) - 1;
                        if (quantity <= 1) {
                            quantity = 1;
                        }
                        id.setQuantity(quantity);
                        sessionProduct.put(pId, id);
                        for (Product x : sessionProduct.values()) {
                            list.add(x);
                        }
                        total = total(list);
                        sessionAmount.put(pId, quantity);
                        session.setAttribute("tmpCart", list);
                        session.setAttribute("amount1", quantity);
                        session.setAttribute("amount", sessionAmount);
                    } else if (action.equals("cancel")) {
                        sessionProduct.remove(pId);
                        session.removeAttribute("suggestion");
                        for (Product x : sessionProduct.values()) {
                            list.add(x);
                        }
                        total = total(list);
                        session.setAttribute("order", sessionProduct);
                        session.setAttribute("tmpCart", list);
                    } else {
                        if (sessionProduct.containsKey(pId)) {
                            quantity = sessionAmount.get(pId) + 1;
                            id.setQuantity(quantity);
                            sessionProduct.put(pId, id);
                            for (Product x : sessionProduct.values()) {
                                list.add(x);
                            }
                            total = total(list);
                            session.setAttribute("tmpCart", list);
                            sessionAmount.put(pId, quantity);
                            session.setAttribute("amount1", quantity);
                            session.setAttribute("amount", sessionAmount);
                        } else if (!sessionProduct.containsKey(pId)) {
                            cart.add(id);
                            id.setQuantity(quantity);
                            sessionProduct.put(pId, id);
                            sessionAmount.put(pId, quantity);
                            total = total(cart);
                            session.setAttribute("tmpCart", cart);
                            session.setAttribute("order", sessionProduct);
                            session.setAttribute("amount1", quantity);
                            session.setAttribute("amount", sessionAmount);
                        }
                    }

                }
                    session.setAttribute("total1", total);
                    response.sendRedirect("addToCart.jsp");
                
            }
        }
    }

    private int total(ArrayList<Product> list) {
        int sum = 0;
        for (Product x : list) {
            sum += x.getProductPrice() * x.getQuantity();
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
