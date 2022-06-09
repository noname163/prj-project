/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.CategoriesDaO;
import datdh.dao.ProductDaO;
import datdh.dto.Categories;
import datdh.dto.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class detailServlet extends HttpServlet {

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
            Object status = request.getAttribute("status");
            Object logined = request.getAttribute("logout");
            Object categories = request.getParameter("CValue");
            ArrayList<Product> list = ProductDaO.getProducts();
            ArrayList<Categories> listC = new CategoriesDaO().getCategorieses();
            Product newProduct = ProductDaO.getNewProduct();
            request.setAttribute("tag", categories);
            request.setAttribute("listC", listC);
            request.setAttribute("newP", newProduct);
            request.setAttribute("ListP", list);

            if (status == null) {
                request.setAttribute("status", "Login");
                request.setAttribute("signin", "SignUp");
            } else {
                request.setAttribute("status", "Logout");
                request.setAttribute("signin", "Shopping");
                status = null;

            }
            String nameP = request.getParameter("Dvalue");
            Product product = ProductDaO.getProductByName(nameP);
            request.setAttribute("PDetail", product);
            request.getRequestDispatcher("Detail.jsp").forward(request, response);
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
