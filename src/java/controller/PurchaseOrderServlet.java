/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.PurchaseOrderDAO;
import Model.PurchaseOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
public class PurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            PurchaseOrder po = new PurchaseOrder();
            
            po.setPoNumber(Integer.parseInt(request.getParameter("poNumber")));
            po.setItemDescription(request.getParameter("itemDescription"));
            po.setQty(Integer.parseInt(request.getParameter("qty")));
            po.setUnitMeasurement(request.getParameter("unitMeasurement"));
            po.setUnitprice(Double.parseDouble(request.getParameter("UnitPrice")));
            po.setVat(Double.parseDouble(request.getParameter("vat")));
        try {
            po.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(PurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            po.setPreparedBy(Integer.parseInt(request.getParameter("preparedBy")));
            po.setApprovedBy(Integer.parseInt(request.getParameter("preparedBy")));
            
            PurchaseOrderDAO poDAO = new PurchaseOrderDAO();
            
            if (poDAO.EncodePurchaseOrder(po)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/GetPurchaseOrder.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("po", po);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodePurchaseOrder.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
