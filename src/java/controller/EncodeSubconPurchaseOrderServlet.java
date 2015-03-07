/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.SubconPurchaseOrderDAO;
import Model.SubconPurchaseOrder;
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
public class EncodeSubconPurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        
        try {
            SubconPurchaseOrder SPO = new SubconPurchaseOrder();
            
            SPO.setApprovedBy(Integer.parseInt(request.getParameter("approvedBy")));
            SPO.setColor(request.getParameter("color"));
//            SPO.setDateMade(null);
//            SPO.setDeliverySchedule(null);
//            ^ Not sure if ieenter or auto na
            SPO.setPoNumber(Integer.parseInt(request.getParameter("poNumber")));
            SPO.setPreparedBy(Integer.parseInt(request.getParameter("preparedBy")));
            SPO.setProductID(Integer.parseInt(request.getParameter("productID")));
            SPO.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
            SPO.setQty(Integer.parseInt(request.getParameter("qty")));
            SPO.setService(request.getParameter("service"));
            SPO.setSize(request.getParameter("size"));
            SPO.setSubcon(Integer.parseInt(request.getParameter("subcon")));
            SPO.setUnitPrice(Double.parseDouble(request.getParameter("unitPrice")));
            SubconPurchaseOrderDAO spoDAO = new SubconPurchaseOrderDAO();
            
            if (spoDAO.EncodeSubconPurchaseOrder(SPO)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ViewSubconPurchaseOrder.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("SPO", SPO);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeSubconPurchaseOrder.jsp");
                rd.forward(request, response);
                
            }
        } finally {
            out.close();
        }
    }
}
