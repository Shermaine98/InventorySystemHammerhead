/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProductionInventoryDAO;
import Model.ProductionInventory;
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
public class ProductionInventoryServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            ProductionInventory productionInventory = new ProductionInventory();
        try {
            productionInventory.setDateUpdated();
        } catch (ParseException ex) {
            Logger.getLogger(ProductionInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            productionInventory.setQty(Integer.parseInt(request.getParameter("qty")));
            productionInventory.setUnitMeasurement(request.getParameter("unitMeasurement"));
            productionInventory.setDeliveryReceiptNumber(Integer.parseInt(request.getParameter("deliveryReceiptNumber")));
            productionInventory.setStockNumber(Integer.parseInt(request.getParameter("stockNumber")));
            productionInventory.setCategory(request.getParameter("category"));
            
            ProductionInventoryDAO PIDAO = new ProductionInventoryDAO();
            
            if (PIDAO.EncodeProductionInventory(productionInventory)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/GetProductionInventory.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("productionInventory", productionInventory);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/MonitorProductionInventory.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
