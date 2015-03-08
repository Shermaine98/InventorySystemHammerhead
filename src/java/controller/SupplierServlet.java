/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.PromoDAO;
import Dao.RefSupplierDAO;
import Model.Promo;
import Model.RefSupplier;
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
public class SupplierServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            RefSupplier RefSupplier = new RefSupplier();
            RefSupplier.setCompanyAddress(request.getParameter("CompanyAddress"));
            RefSupplier.setCompanyName(request.getParameter("CompanyName"));
            RefSupplier.setContactPerson(request.getParameter("ContactPerson"));
            RefSupplier.setContactNumber(Integer.parseInt(request.getParameter("ContanctNumber")));
            RefSupplier.setItemDescription(request.getParameter("ItemDescription"));
                      
            RefSupplierDAO RefSupplierDAO = new RefSupplierDAO();
            
            if (RefSupplierDAO.EncodeRefSupplier(RefSupplier)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("SList", RefSupplier);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeSupplier.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
        
    }

    
}
