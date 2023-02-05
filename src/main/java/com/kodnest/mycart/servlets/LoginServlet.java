/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kodnest.mycart.servlets;

import com.kodnest.mycart.dao.UserDao;
import com.kodnest.mycart.entities.User;
import com.kodnest.mycart.factoryprovider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vrushabh
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            //coding area
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            //validation
            //authentication
            UserDao userdao = new UserDao(factoryprovider.getfaFactory());
            User user = userdao.getUserByEmailAndPassword(email, password);

//            System.out.println(user);
            HttpSession httpSession = request.getSession();
            if (user == null) {
//                out.println("<h1>Invalid details</h1>");
                httpSession.setAttribute("message", "Invalid Details !! Try with another one");
                response.sendRedirect("login.jsp");
                return;
            } else {
//                   out.println("<h1>Welcome "+user.getUserName()+" </h1>");
          
//                httpSession.setAttribute("message", "Login Successfull!! Welcome "+user.getUserName()+"");
//                response.sendRedirect("login.jsp");
//                return;



              //login
              httpSession.setAttribute("current-user", user);
              
              if(user.getUserType().equals("admin"))
              {
                  //admin:-admin.jsp
                  response.sendRedirect("Admin.jsp");
              }
              else if(user.getUserType().equals("normal"))
              {
                  response.sendRedirect("Normal.jsp");
              
              }
              else{
                  out.println("we have not identified your user type");
              }

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
