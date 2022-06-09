/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.AccountDaO;
import datdh.dto.Account;
import jakarta.websocket.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String saveAcc = request.getParameter("saveAcc");
            HttpSession session = request.getSession();
            String from = (String)session.getAttribute("from");
            if (email != null) {
                int role = Integer.parseInt(request.getParameter("role"));
                Account account = AccountDaO.getAccount(email, password, role);
                if (account == null) {
                    System.out.println("go in login fail");
                    request.setAttribute("mess", "Wrong password or username");
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("loginPage.jsp").forward(request, response);
                }
                else if (account!=null&&account.getStatus() == 1) {
                    session.setAttribute("account", account);
                    if(from!=null&&from.equals("addToCart")&& saveAcc!=null){
                        System.out.println("from add to cart");
                        AccountDaO.setTokenAccount(Integer.toString(account.getAccountID()), Integer.toString(account.getAccountID()));
                        Cookie token = new Cookie("token", Integer.toString(account.getAccountID()));
                        response.addCookie(token);
                        session.removeAttribute("from");
                        request.getRequestDispatcher("orderServlet").forward(request, response);
                        
                    }
                    else if(from!=null&&from.equals("addToCart")&& saveAcc==null){
                       System.out.println("from add to cart");
                        session.removeAttribute("from");
                        request.getRequestDispatcher("orderServlet").forward(request, response);
                        
                    }
                    else if(from!=null&&from.equals("adminPage")&& saveAcc==null){
                        System.out.println("from admin page");
                        if(account.getRole()!=0)
                            request.getRequestDispatcher("HomeServlet").forward(request, response);
                        else
                            request.getRequestDispatcher("AdminServlet").forward(request, response);
                        
                    }
                    else if (saveAcc != null) {
                        AccountDaO.setTokenAccount(Integer.toString(account.getAccountID()), Integer.toString(account.getAccountID()));
                        Cookie token = new Cookie("token", Integer.toString(account.getAccountID()));
                        response.addCookie(token);
                        request.getRequestDispatcher("HomeServlet").forward(request, response);
                    }
                    else if(saveAcc==null||saveAcc.equals("")){
                        request.getRequestDispatcher("HomeServlet").forward(request, response);
                    }
                    
                    else {
                        response.sendRedirect("errosPage.jsp");
                    }
                } else if (account.getStatus() == 0) {
                    request.setAttribute("mess", "Your account had been block by admin.");
                    request.getRequestDispatcher("loginPage.jsp").forward(request, response);

                }
            } else {
                System.out.println("email null");
                Cookie cookie[] = request.getCookies();
                for (Cookie o : cookie) {
                    if (o.getName().equals("token")) {
                        Account acc = AccountDaO.getAccountByToken(o.getValue());
                        request.setAttribute("email", acc.getEmail());
                        request.setAttribute("pass", acc.getPassword());
                        request.setAttribute("role", acc.getRole());
                    }
                }
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
