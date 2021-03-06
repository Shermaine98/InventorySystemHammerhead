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
public class AccessoriesInventoryServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            AccessoriesInventory accessoriesInventory = new AccessoriesInventory();
            AccessoriesInventoryDAO AIDAO = new AccessoriesInventoryDAO();
           ArrayList<AccessoriesInventory> AccessoriesInventory = new ArrayList<AccessoriesInventory>();
            boolean x= false;
            
            String[] category = request.getParameterValues("category");
            String[] accessoryDes = request.getParameterValues("accessoryDescription");
            String[] qty = request.getParameterValues("qty");
            String[] unitMeasurment = request.getParameterValues("unitMeasurement");
            String[] approval = request.getParameterValues("approval");
            String[] note = request.getParameterValues("note");
            
             for (int i = 0; i < accessoryDes.length; i++) {
            accessoriesInventory.setCategory(category[i]);
            accessoriesInventory.setAccessoryDescription(accessoryDes[i]);
        try {
            accessoriesInventory.setDateUpdated();
        } catch (ParseException ex) {
            Logger.getLogger(AccessoriesInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            accessoriesInventory.setDeliveryReceiptNumber(Integer.parseInt(request.getParameter("deliveryReceiptNumber")));
            accessoriesInventory.setQty(Integer.parseInt(qty[i]));
            accessoriesInventory.setUnitMeasurement(unitMeasurment[i]);
            accessoriesInventory.setApproval(Boolean.parseBoolean(approval[i]));
              accessoriesInventory.setNote(note[i]);
            
           
              if (AIDAO.EncodeAccessoriesInventory(accessoriesInventory)) {
                    x = true;
                    AccessoriesInventory.add(accessoriesInventory);
                } else {
                    x = false;
                }
            
             }
            
            if (x==true) {
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
