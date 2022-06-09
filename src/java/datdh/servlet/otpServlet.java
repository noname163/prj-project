/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.AccountDaO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class otpServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            String otpInput = request.getParameter("otp");
            Cookie[] cookies1 = request.getCookies();
            String otpValue = "";
            String fullName = request.getParameter("Username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");
            String phone = request.getParameter("phone");
            for (Cookie c : cookies1) {
                otpValue = c.getValue();
            }
            if (otpInput.equals(otpValue)) {
                request.setAttribute("success", "register success");
                AccountDaO.insertAccounts(email, password, fullName, phone);
                request.setAttribute("email", email);
                session.removeAttribute("name");
                session.removeAttribute("email");
                session.removeAttribute("password");
                session.removeAttribute("phone");
                session.removeAttribute("repass");
                request.getRequestDispatcher("mainController?action=login").forward(request, response);
            } else {
                request.setAttribute("name", fullName);
                request.setAttribute("email", email);
                request.setAttribute("password", password);
                request.setAttribute("phone", phone);
                request.setAttribute("repass", rePassword);
                request.setAttribute("fail", "OTP timeout Re-Submit to Re-Send OTPCode");
                request.getRequestDispatcher("mainController?action=SignUp").forward(request, response);
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
