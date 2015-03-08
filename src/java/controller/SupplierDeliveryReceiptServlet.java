/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.PromoDAO;
import Dao.SupplierDeliveryReceiptDAO;
import Model.Promo;
import Model.SupplierDeliveryReceipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            SupplierDeliveryReceipt SupplierDeliveryReceipt = new SupplierDeliveryReceipt();
            SupplierDeliveryReceipt.setPoNumber(Integer.parseInt(request.getParameter("poNumber")));
            SupplierDeliveryReceipt.setItemDescription(request.getParameter("itemDescription"));
        try {
            SupplierDeliveryReceipt.setReceivedDate();
        } catch (ParseException ex) {
            Logger.getLogger(SupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        SupplierDeliveryReceipt.setreceivedBy(Integer.parseInt(request.getParameter("receivedBy")));
        SupplierDeliveryReceipt.setCheckedBy(Integer.parseInt(request.getParameter("checkedBy")));
        SupplierDeliveryReceipt.setStatus(request.getParameter("status"));
            
            SupplierDeliveryReceiptDAO SupplierDeliveryReceiptDAO = new SupplierDeliveryReceiptDAO();
            
            if (SupplierDeliveryReceiptDAO.EncodeDeliveryReceipt(SupplierDeliveryReceipt)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("SDRreceipt", SupplierDeliveryReceipt);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeSupplierDeliveryReceipt.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
        
    }

    
}
