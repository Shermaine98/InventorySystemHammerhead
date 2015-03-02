/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.WarehouseInventoryDAO;
import Model.WarehouseInventory;
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
public class WarehouseInventoryServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            WarehouseInventory warehouseInventory = new WarehouseInventory();
            warehouseInventory.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
            warehouseInventory.setSex(request.getParameter("sex"));
            warehouseInventory.setItemDescription(request.getParameter("itemDescription"));
            warehouseInventory.setAgeGroup(request.getParameter("ageGroup"));
            warehouseInventory.setColor(request.getParameter("color"));
            warehouseInventory.setSize(request.getParameter("size"));
        try {
            warehouseInventory.setDateUpdated();
        } catch (ParseException ex) {
            Logger.getLogger(WarehouseInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            warehouseInventory.setQty(Integer.parseInt(request.getParameter("Quantity")));
            
            WarehouseInventoryDAO WIDAO = new WarehouseInventoryDAO();
            
            if (WIDAO.EncodeWarehouseInventory(warehouseInventory)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/GetWarehouseInventory.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("warehouseInventory", warehouseInventory);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/MonitorWarehouseInventory.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
