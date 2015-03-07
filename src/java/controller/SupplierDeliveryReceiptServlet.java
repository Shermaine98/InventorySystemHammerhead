/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.PromoDAO;
import Model.Promo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gcla109
 */
public class SupplierDeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            Promo promo = new Promo();
            promo.setEmployeeNumber(Integer.parseInt(request.getParameter("employeeNumber")));
            promo.setOutlet(request.getParameter("outlet"));
            promo.setAddress(request.getParameter("address"));
          
            
            PromoDAO promoDAO = new PromoDAO();
            
            if (promoDAO.RegisterPromo(promo)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("");
                HttpSession session = request.getSession();
                session.setAttribute("promo", promo);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
        
    }

    
}
