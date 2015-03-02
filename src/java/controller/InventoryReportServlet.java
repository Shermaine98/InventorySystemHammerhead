/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.InventoryReportDAO;
import Model.InventoryReport;
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
public class InventoryReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            InventoryReport inventoryReport = new InventoryReport();
            inventoryReport.setPromo(Integer.parseInt(request.getParameter("promo")));
            inventoryReport.setOutlet(request.getParameter("outlet"));
        try {
            inventoryReport.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(InventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            inventoryReport.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
            inventoryReport.setSex(request.getParameter("sex"));
            inventoryReport.setItemDescription(request.getParameter("itemDescription"));
            inventoryReport.setAgeGroup(request.getParameter("ageGroup"));
            inventoryReport.setColor(request.getParameter("color"));
            inventoryReport.setSize(request.getParameter("size"));
            inventoryReport.setRemainingQuantity(Integer.parseInt(request.getParameter("remainingQty")));
            inventoryReport.setSoldQty(Integer.parseInt(request.getParameter("soldQty")));
            inventoryReport.setPulledOutQty(Integer.parseInt(request.getParameter("pulledOutQty")));
            
            InventoryReportDAO IRDAO = new InventoryReportDAO();
            
            if (IRDAO.EncodeInventoryReport(inventoryReport)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/GetInventoryReport.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("inventoryReport", inventoryReport);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeInventoryReport.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
