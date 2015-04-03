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
import java.util.ArrayList;
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
            WarehouseInventoryDAO WIDAO = new WarehouseInventoryDAO();
            ArrayList <WarehouseInventory> WI = new ArrayList <WarehouseInventory>();
            boolean x= false;
            
            String [] productID = request.getParameterValues("productID");
            String [] size = request.getParameterValues("size");
            String [] color = request.getParameterValues("color");
            String [] qty = request.getParameterValues("qty");
 // TODO: fix
            String [] approval = request.getParameterValues("approval");
            
            for(int i=0; i < productID.length;i++){
            warehouseInventory.setDrNumber(Integer.parseInt("drNumber"));
            warehouseInventory.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
            warehouseInventory.setProductID(Integer.parseInt(productID[i]));
            warehouseInventory.setSize(size[i]);
            warehouseInventory.setColor(color[i]);
            warehouseInventory.setQty(Integer.parseInt(qty[i]));
 // TODO: fix
            warehouseInventory.setApproval(Boolean.parseBoolean(approval[i]));
        
            try {
            warehouseInventory.setDateUpdated();
        } catch (ParseException ex) {
            Logger.getLogger(WarehouseInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
             if (WIDAO.EncodeWarehouseInventory(warehouseInventory)) {
                    x = true;
                    WI.add(warehouseInventory);
                } else {
                    x = false;
                }
            }
            
            if (x==true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
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
