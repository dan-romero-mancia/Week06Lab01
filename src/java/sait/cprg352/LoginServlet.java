/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sait.business.User;

/**
 *
 * @author 752039
 */
public class LoginServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
       String username = (String)request.getParameter("username");
       String password = (String)request.getParameter("password");
       
       if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
           request.setAttribute("errorMessage", "Invalid Login");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           return;
       }
       
       UserService service = new UserService();
       User user = service.login(username, password);
       
       if (user == null) {
           request.setAttribute("errorMessage", "Invalid Login");
       }
       
       request.setAttribute("username", user.getUsername());
       getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    } 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
