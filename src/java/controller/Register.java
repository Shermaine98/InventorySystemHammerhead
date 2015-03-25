/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author gcla109
 */
public class Register extends BaseServlet {

    //@Override
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            User newUser = new User();
//            newUser.setEmployeeNumber(Integer.parseInt(request.getParameter("number")));
            newUser.setFirstName(request.getParameter("reqfirstname"));
            newUser.setLastName(request.getParameter("reqlastname"));
            newUser.setPosition(request.getParameter("reqposition"));
            newUser.setUserName(request.getParameter("requsername"));
            newUser.setPassword(request.getParameter("reqpassword"));
            try {
                newUser.setBirthDate(request.getParameter("Bdate"));
            } catch (ParseException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                newUser.setEntryDate();
            } catch (ParseException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                newUser.setLeftDate("9999-10-10");
            } catch (ParseException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }           
            UserDAO UserDAO = new UserDAO();
              boolean successful = UserDAO.register(newUser);
            if(request.getParameter("reqposition").equalsIgnoreCase("Promo")){
            if (successful) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("register", newUser);
                rd.forward(request, response);
            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/PromoRegister.jsp");
                rd.forward(request, response);
            }
            }else{
            if (successful) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("register", newUser);
                rd.forward(request, response);
            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/Register.jsp");
                rd.forward(request, response);
            }
            }
            out.close();
        }
    }

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
