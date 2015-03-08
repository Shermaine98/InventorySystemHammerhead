/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.AccessoriesInventoryDAO;
import Model.AccessoriesInventory;
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
public class AccessoriesInventoryServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            AccessoriesInventory accessoriesInventory = new AccessoriesInventory();
            accessoriesInventory.setCategory(request.getParameter("category"));
            accessoriesInventory.setAccessoryDescription(request.getParameter("accessoryDescription"));
        try {
            accessoriesInventory.setDateUpdated();
        } catch (ParseException ex) {
            Logger.getLogger(AccessoriesInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            accessoriesInventory.setDeliveryReceiptNumber(Integer.parseInt(request.getParameter("deliveryReceiptNumber")));
            accessoriesInventory.setQty(Integer.parseInt(request.getParameter("qty")));
            accessoriesInventory.setUnitMeasurement(request.getParameter("unitMeasurement"));
            accessoriesInventory.setApproval(Boolean.parseBoolean(request.getParameter("approval")));
            
            AccessoriesInventoryDAO AIDAO = new AccessoriesInventoryDAO();
            
            if (AIDAO.EncodeAccessoriesInventory(accessoriesInventory)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("accessoriesInventory", accessoriesInventory);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/MonitorAccessoriesInventory.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
