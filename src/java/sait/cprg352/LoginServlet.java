/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            request.getSession().removeAttribute("user");
            request.setAttribute("logout", "You have successfully logged out.");
        }
        
        Cookie userCookie = getCookie(request.getCookies());
        
        if (userCookie != null && !userCookie.getValue().equals("")) {
            request.setAttribute("username", userCookie.getValue());
            request.setAttribute("remember", "checked");
        }
        
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
       String[] rememberCheck = request.getParameterValues("remember");
       
       if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
           request.setAttribute("errorMessage", "Invalid Login");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           return;
       }
       
       UserService service = new UserService();
       User user = service.login(username, password);
       
       if (user == null) {
           request.setAttribute("username", username);
           request.setAttribute("errorMessage", "Invalid Login");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       }
       
       if (rememberCheck != null) {
           response.addCookie(new Cookie("user", username));
       }
       
       else {
           Cookie cookie = getCookie(request.getCookies());
           if (cookie != null) {
                cookie.setMaxAge(-1);
                cookie.setValue(null);
                response.addCookie(cookie);
           }
       }
       
       HttpSession session = request.getSession();
       session.setAttribute("user", user);
       response.sendRedirect("home");
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
    
    private Cookie getCookie(Cookie[] cookies) {
        Cookie userCookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("user")) {
                userCookie = c;
            }
        }
        return userCookie;
    }

}
