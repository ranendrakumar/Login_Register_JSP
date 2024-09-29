/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.rk;

import com.rk.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ranen
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        DAO objLoginDao;
        try {
            String struname = request.getParameter("uname");
            String strpass = request.getParameter("pass");
            objLoginDao = new DAO();
            if (objLoginDao.checkUser(struname, strpass)) {
                HttpSession session = request.getSession();
                session.setAttribute("uname", struname);
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("login_register.jsp");
            }
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            objLoginDao = null;
        }
    }

}
