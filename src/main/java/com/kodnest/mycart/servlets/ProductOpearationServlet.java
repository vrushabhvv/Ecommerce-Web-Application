/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kodnest.mycart.servlets;

import com.kodnest.mycart.dao.CategoryDao;
import com.kodnest.mycart.dao.ProductDao;
import com.kodnest.mycart.entities.Category;
import com.kodnest.mycart.entities.Product;
import com.kodnest.mycart.factoryprovider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Vrushabh
 */
@MultipartConfig
@WebServlet(name = "ProductOpearationServlet", urlPatterns = {"/ProductOpearationServlet"})
public class ProductOpearationServlet extends HttpServlet {

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
           
//            this servlet handling addcart and addproduct functionalities
          


             String op=request.getParameter("operation");
             if(op.trim().equals("addcategory")){
                 //add category code 
                 
                String title= request.getParameter("cattitle");
                String description= request.getParameter("catDescription");
                
                
                Category category=new Category();
                category.setCategory_Title(title);
                category.setCategory_Description(description);
                
//                category save to db
                  //we can use hibernate directly but prefer to work with help of Dao layer that is Dao class
                  
                 CategoryDao categorydao=new CategoryDao(factoryprovider.getfaFactory());
                 int catId =categorydao.saveCategory(category);
                 
//                 out.println("category added");
                 HttpSession httpsession = request.getSession();
                 httpsession.setAttribute("message"," category added successfully");
                 response.sendRedirect("Admin.jsp");
                 return;
                
             }
             else if(op.trim().equals("addproduct")){
                 //add product
                                

                 String pName=  request.getParameter("pname");
                 
                 String pDesc=  request.getParameter("proddescription");
                 
                 int pPrice=    Integer.parseInt(request.getParameter("pprice"));
                 
                 int pDiscount= Integer.parseInt(request.getParameter("pdiscount"));
               
                 int pQuantity= Integer.parseInt(request.getParameter("pquantity"));
                   
                 int catid=     Integer.parseInt(request.getParameter("catId"));
                  out.println("product added");
                  
                  
                 
                 Part part=request.getPart("fileupload");
                
                 
                 
                  
                 
                 
                 
                 Product p=new Product();
                 p.setPName(pName);
                 p.setpDesc(pDesc);
                 p.setpPrice(pPrice);
                 p.setpDiscount(pDiscount);
                 p.setpQuantity(pQuantity);
                 p.setpPhoto(part.getSubmittedFileName());
                  
                 
                 
                 //get category by id
                 
                 CategoryDao cdao=new CategoryDao(factoryprovider.getfaFactory());
                 Category category=cdao.getCategoryById(catid);
                 
                 p.setCategory(category);//we dont have category directly but we have catid from that we have found category and set up
                 
                 //product save
                 
                 ProductDao pdao=new ProductDao(factoryprovider.getfaFactory());
                 pdao.saveProduct(p);
                 
                 //pic upload
                 
                 //1.create product folder inside image folder
                 //find out the path to upload photo that is find product path in imgage folder
                 String path=request.getRealPath("image")+File.separator+"products"+File.separator+part.getSubmittedFileName();
                 //to test print the path on console
//                 System.out.println(path);


                 //uploading code...
                 try{
                 FileOutputStream fos=new FileOutputStream(path);
                 InputStream is=part.getInputStream();
                 
//                 reading data

                 byte []data=new byte[is.available()];
                 is.read(data);
                 
                 //writing the data
                 
                 fos.write(data);
                 
                 fos.close();
                 }
                 catch(Exception e){
                     e.printStackTrace();
             }
             
                 
                 
            
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
//                 out.println("product added");
                 
                 
                 
                 
                 HttpSession httpsession = request.getSession();
                 httpsession.setAttribute("message"," product is added successfully");
                 response.sendRedirect("Admin.jsp");
                 return;
                
                 
                 
                 
                 
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
