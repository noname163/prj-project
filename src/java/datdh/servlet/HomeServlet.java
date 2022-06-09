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
public class HomeServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException,NullPointerException {
        response.setContentType("text/html;charset=UTF-8");
        
        Object categories = request.getParameter("CValue");
        HttpSession session = request.getSession();
        ArrayList<Product> list = ProductDaO.pagingProducts("1");
        ArrayList<Product> topProducts = ProductDaO.getTopProducts();
        ArrayList<Categories> listC =  CategoriesDaO.pagingCate("1");
        ArrayList<Categories> allC =  CategoriesDaO.getCategorieses();
        int totalCate = CategoriesDaO.getToalCate();
        int totalProduct = ProductDaO.totalProducts();
        request.setAttribute("tag", categories);
        request.setAttribute("listC", listC);
        session.setAttribute("cList", listC);
        session.setAttribute("allC", allC);
        session.setAttribute("topProduct", topProducts);
        session.setAttribute("cateIndex", 1);
        session.setAttribute("page", 1);
        if(totalProduct%6!=0){
            session.setAttribute("pagination", (totalProduct/6)+1);
        }
        if(totalProduct%6==0)
            session.setAttribute("pagination", totalProduct/6);
        if(totalCate%4==0)
            session.setAttribute("totalCate", totalCate/4);
        if(totalCate%4!=0){
            if(totalCate/4>2)
               session.setAttribute("totalCate", (totalCate/4)+1); 
            session.setAttribute("totalCate", (totalCate/4)+1); 
        }
        if(categories==null){
            session.setAttribute("ListP", list);
        }else if(categories!=null){
            ArrayList<Product> product = ProductDaO.getProduct(categories.toString());
            request.setAttribute("ListP", product);
        }
        session.removeAttribute("searchValue");
        request.getRequestDispatcher("Home.jsp").forward(request, response);
        

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
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
