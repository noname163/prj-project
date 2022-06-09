/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.AccountDaO;
import datdh.dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
public class sendMailServlet extends HttpServlet {

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
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            final String addminEmail = "akai792001@gmail.com";
            final String password = "datkaito792001";
            String userEmail = request.getParameter("email");
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.store.protocol", "pop3");
            props.put("mail.transport.protocol", "smtp");
            String action = request.getParameter("action");
            HttpSession sessionHttp = request.getSession();
            String preText = "";
            String text = "";
            String url = "";
            if (action.equals("valid")) {
                String number = randomNumber(100, 999);
                Cookie otp = new Cookie("otp", number);
                otp.setMaxAge(60);
                response.addCookie(otp);
                String code = otp.getValue();
                String name = otp.getName();
                preText = "Your OTP-Code Are: ";
                text = code;
                userEmail = (String)sessionHttp.getAttribute("email");
                url = "validPage.jsp";
            }
            else if(action.equals("block")){
                String accId = (String)sessionHttp.getAttribute("blockAccId");
                Account acc = AccountDaO.getAccountById(accId);
                userEmail = acc.getEmail();
                preText = "Account "+ acc.getFullName()+" was block by admin";
                text = " Contact to akai@gmail.com for more detail.";
                url = "adminUsPage.jsp";
            }
            else if(action.equals("unblock")){
                String accId = (String)sessionHttp.getAttribute("blockAccId");
                Account acc = AccountDaO.getAccountById(accId);
                userEmail = acc.getEmail();
                preText = "Account "+ acc.getFullName()+" was unblock by admin ";
                text = ".Please compliance the rule.";
                url = "adminUsPage.jsp";
            }
            else if(action.equals("promote")){
                String accId = (String)sessionHttp.getAttribute("blockAccId");
                Account acc = AccountDaO.getAccountById(accId);
                userEmail = acc.getEmail();
                preText = "Account "+ acc.getFullName()+" was promoted by admin ";
                text = ".Please compliance the rule.";
                url = "adminUsPage.jsp";
            }
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(addminEmail, password);
                }
            });
            try {
                
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(addminEmail));
                msg.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(userEmail));
                msg.setSubject("DaLat Flower Shop ");
                msg.setText(preText+text);
                Transport.send(msg);
                System.out.println("done");
            } catch (MessagingException mex) {
                System.out.println("send failed, exception: " + mex);
                mex.printStackTrace();
            }
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private String randomNumber(int min, int max) {
        int b = (int) (Math.random() * (max - min + 1) + min);
        String otpCode = Integer.toString(b);
        return otpCode;
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
            Logger.getLogger(sendMailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sendMailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
