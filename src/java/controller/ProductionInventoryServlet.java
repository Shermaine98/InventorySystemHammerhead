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
public class ProductionInventoryServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            ProductionInventory productionInventory = new ProductionInventory();
            ProductionInventoryDAO PIDAO = new ProductionInventoryDAO();
            ArrayList <ProductionInventory> pi = new ArrayList <ProductionInventory>();
            boolean x = false;
            
            String[] poNum = request.getParameterValues("productionNumber");
            String[] DrNum = request.getParameterValues("deliveryReceiptNumber");
            String[] category = request.getParameterValues("category");
            String[] qty = request.getParameterValues("qty");
// TODO: THIS NOT SURE
            String[] unitM = request.getParameterValues("unitMeasurement");
            String[] Approval = request.getParameterValues("approval");
// END
            String[] note = request.getParameterValues("note");
      
       for(int i=0; i< category.length;i++){     
       try {
            productionInventory.setDateUpdated();
        } catch (ParseException ex) {
            Logger.getLogger(ProductionInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            productionInventory.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
            productionInventory.setDrNumber(Integer.parseInt(request.getParameter("deliveryReceiptNumber")));
            productionInventory.setCategory(category[i]);
            productionInventory.setQty(Integer.parseInt(qty[i]));
            productionInventory.setUnitMeasurement(unitM[i]);
            productionInventory.setApproval(Boolean.parseBoolean(Approval[i]));
            productionInventory.setNote(note[i]);
            
              if (PIDAO.EncodeProductionInventory(productionInventory)) {
                    x = true;
                    pi.add(productionInventory);
                } else {
                    x = false;
                }
           
       }
           
            
            if (x==true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
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
