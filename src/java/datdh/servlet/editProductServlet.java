/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package datdh.servlet;

import datdh.dao.CategoriesDaO;
import datdh.dao.ProductDaO;
import datdh.dto.Product;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ADMIN
 */
public class editProductServlet extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException, ClassNotFoundException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String pId = request.getParameter("pId");
            String action = request.getParameter("action");
            Product product = ProductDaO.getProductById(pId);
            if (action == null) {
                request.setAttribute("product", product);
                request.setAttribute("pId", pId);
                request.getRequestDispatcher("editProduct.jsp").forward(request, response);
            }

            else if (action != null && action.equals("saveC")) {
                String pName = "";
                String pCate = "";
                String pDes = "";
                String pPrice = "";
                String imgPath = "";
                System.out.println(product.toString());
                System.out.println("productId: "+pId);
                // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();

                // Configure a repository (to ensure a secure temp location is used)
                ServletContext servletContext = this.getServletConfig().getServletContext();
                File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                factory.setRepository(repository);

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);

                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
                // Process the uploaded items
                Iterator<FileItem> iter = items.iterator();
                HashMap<String, String> fields = new HashMap<>();
                String fileName = "";
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (item.isFormField()) {
                        fields.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        String value = item.getString();
                        System.out.println("name: " + name);
                        System.out.println("value: " + value);
                        switch (name) {
                            case "product_name":
                                pName = item.getString();
                                break;
                            case "product_categorie":
                                pCate = item.getString();
                                if(pCate==null||pCate.equals("") ){
                                    pCate= Integer.toString(product.getCateId());
                                }
                                else if ((pCate!=null&&!pCate.equals(""))&&CategoriesDaO.isExist(pCate) == false) {
                                    CategoriesDaO.newCategories(pCate);
                                    pCate = CategoriesDaO.getId(pCate);
                                }
                                break;
                            case "product_description":
                                pDes = item.getString();
                            case "price":
                                pPrice = item.getString();
                                break;
                        }
                    } else {
                        fileName = item.getName();
                        System.out.println("file name: " + fileName);
                        if (fileName==null||fileName.equals("")) {
                            ProductDaO.updateProduct(pId, pName, pPrice, product.getProductImg(), pDes, "1", pCate);
                        } else {
                            Path path = Paths.get(fileName);
                            String storePath = servletContext.getRealPath("/Img");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            if (uploadFile.exists()) {
                                imgPath = "Img" + "/" + path.getFileName();
                                ProductDaO.updateProduct(pId,pName, pPrice, imgPath, pDes, "1", pCate);
                            } else {
                                item.write(uploadFile);
                                imgPath = "Img" + "/" + path.getFileName();
                                ProductDaO.updateProduct(pId,pName, pPrice, imgPath, pDes, "1", pCate);

                            }
                        }
                    }
                }
                response.sendRedirect("Home");
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
            Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(editProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
