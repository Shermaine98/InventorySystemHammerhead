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
public class PurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            PurchaseOrder po = new PurchaseOrder();
            PurchaseOrderDAO poDAO = new PurchaseOrderDAO();
            //po = (PurchaseOrder)request.getAttribute("");
            
            String[] itemDescription = request.getParameterValues("itemDescription");
            String[] supplier = request.getParameterValues("Supplier");
            String[] type = request.getParameterValues("Type");
            String[] unitMeasurement = request.getParameterValues("unitMeasurement");
            String[] qty = request.getParameterValues("qty");
            String[] unitPrice = request.getParameterValues("unitPrice");
            String[] vat = request.getParameterValues("vat");
//            String[] dateMade = request.getParameterValues("dateMade");
            String[] preparedBy = request.getParameterValues("preparedBy");
            String[] approvedBy = request.getParameterValues("approvedBy");
            String[] deliverySchedule = request.getParameterValues("DeliverySchedule");
            
            ArrayList<PurchaseOrder> newPOList = new ArrayList<PurchaseOrder>();
            boolean x = false;
            
            for(int i = 0; i < itemDescription.length; i++) {
                po.setItemDescription(itemDescription[i]);
                po.setSupplier(supplier[i]);
                po.setType(type[i]);
                po.setQty(Integer.parseInt(qty[i]));
                po.setUnitMeasurement(unitMeasurement[i]);
                po.setUnitprice(Double.parseDouble(unitPrice[i]));
                po.setVat(Double.parseDouble(vat[i]));
                try {
                    po.setDateMade();
                } catch (ParseException ex) {
                    Logger.getLogger(PurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                po.setPreparedBy(Integer.parseInt(preparedBy[i]));
                po.setApprovedBy(Integer.parseInt(approvedBy[i]));
                try {
                    po.setDeliverySchedule(deliverySchedule[i]);
                } catch (ParseException ex) {
                    Logger.getLogger(PurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(poDAO.EncodePurchaseOrder(po)){
                    x = true;
                    newPOList.add(po);
                }
                else
                    x = false;
                
            }
           
            
            if (x==true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("po", po);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeSupplierPurchaseOrder.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
