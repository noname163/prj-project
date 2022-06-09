/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class mainController extends HttpServlet {
    private String url="";
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
            String action = request.getParameter("action");
            String pId = request.getParameter("pId");
            String mess = request.getParameter("mess");
            String from = request.getParameter("from");
            switch(action){
                
                case"SignUp":
                    url = "registerPage.jsp";
                    break;
                case"Sign Up":
                    url = "Register";
                    break;
                case"Submit":
                    url = "otpServlet";
                    break;
                case"categories":
                    url="Product";
                    break;
                case"Home":
                    url="Product";
                    break;
                case"home":
                    url="Home.jsp";
                    break;
                case"Shopping":
                    url="loadOrderServlet";
                    break;
                case"detail":
                    url="detailServlet";
                    break;
                case"search":
                    url="searchServlet?action="+action;
                    break;
                case"searchPage":
                    url="searchPage.jsp";
                    break;
                case"filter":
                    url="filterServlet?action=filter";
                    break;
                case"filterCart":
                    url="filterServlet?action=filter&from=cart";
                    break;
                case"viewPackage":
                    url="packagePage.jsp";
                    break;
                case"addToCart":
                    url="addToCartServlet";
                    break;
                case"cancelAddToCart":
                    url="addToCartServlet?action=cancel";
                    break;
                case"add":
                    url="addToCart.jsp";
                    break;
                case"plush":
                    url="addToCartServlet?action=plush&pId="+pId;
                    break;
                case"subtract":
                    url="addToCartServlet?action=subtract&pId="+pId;
                    break;
                case"cancel":
                    url="cancelOrder?action=cancel&pId="+pId;
                    break;
                case"re-order":
                    url="cancelOrder?action=re-order&pId="+pId;
                    break;
                case"confirm":
                    url="orderServlet";
                    break;
                case"loadProducts":
                    url="loadOrderServlet";
                    break;
                case"packagePage":
                    url="packagePage.jsp";
                    break;
                case"editProfile":
                    url="editUserProfile.jsp";
                    break;
                case"saveEdit":
                    url="userServlet?action=saveChange";
                    break;
                case"profile":
                    url="userServlet";
                    break;
                case"viewProfile":
                    url="userProfile.jsp";
                    break;
                case"adminPage":
                    url="AdminServlet";
                    break;
                case"userList":
                    url="manageUserServlet";
                    break;
                case"manageUser":
                    url="adminUsPage.jsp";
                    break;
                case"adminDisplay":
                    url="adminPage.jsp";
                    break;
                case"createdNewP":
                    url="upNewProduct.jsp";
                    break;
                case"viewProduct":
                    url="productManageServlet";
                    break;
                case"editCate":
                    url="editCateServlet";
                    break;
                case"pageIndex":
                    url="pagingServlet";
                    break;
                case"valid":
                    url="sendMailSevlet";
                    break;
                case"block":
                    url="sendMailSevlet";
                    break;
                case"unblock":
                    url="sendMailSevlet";
                    break;
                case"promote":
                    url="sendMailSevlet";
                    break;
                default:
                    url = "errosPage.jsp";
                
            }
            request.getRequestDispatcher(url).forward(request, response);
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
