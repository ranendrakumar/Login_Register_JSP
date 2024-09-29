/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.rk;

import com.rk.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ranen
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        DAO objLoginDao;
        PrintWriter out = null;
        try {
            String strfullname = request.getParameter("fullname");
            String strusername = request.getParameter("username");
            String strpassword = request.getParameter("password");
            out = response.getWriter();
            objLoginDao = new DAO();
            int result = objLoginDao.registerUser(strfullname, strusername, strpassword);
            if (result > 0) {
                out.print("<script>alert('Record Inserted');window.location.href ='login_register.jsp'</script>");
                //response.sendRedirect("login_register.jsp");
            }
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objLoginDao = null;
            out = null;
        }
    }
    
}
