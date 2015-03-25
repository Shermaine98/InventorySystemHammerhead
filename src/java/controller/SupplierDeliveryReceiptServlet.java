/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.PromoDAO;
import Dao.PurchaseOrderDAO;
import Dao.SupplierDeliveryReceiptDAO;
import Model.Promo;
import Model.PurchaseOrder;
import Model.SupplierDeliveryReceipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
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
public class SupplierDeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            SupplierDeliveryReceipt SDR = new SupplierDeliveryReceipt();
            SupplierDeliveryReceiptDAO sdrDAO = new SupplierDeliveryReceiptDAO();
            
           
            String[] itemDescription = request.getParameterValues("itemDescription");
            String[] quantity = request.getParameterValues("quantity");
            String[] status = request.getParameterValues("status");
            String[] comment = request.getParameterValues("comment");
            
            ArrayList<SupplierDeliveryReceipt> newPOList = new ArrayList<SupplierDeliveryReceipt>();
            boolean x = false;
                       
            int lastObj = sdrDAO.GetDeliveryReceiptList().size()-1;
            int lastDR = sdrDAO.GetDeliveryReceiptList().get(lastObj).getDeliveryReceiptNumber();

            for(int i = 0; i < itemDescription.length; i++) {
                SDR.setDeliveryReceiptNumber(lastDR+1);
                SDR.setPoNumber(Integer.parseInt(request.getParameter("poNumber")));
                SDR.setItemDescription(itemDescription[i]);
                SDR.setQty(Integer.parseInt(quantity[i]));
                SDR.setStatus(status[i]);
            //    if(comment[i] != null){
              //       SDR.setComment(comment[i]);
                //wahhh}
                SDR.setreceivedBy(Integer.parseInt(request.getParameter("receivedBy")));
                SDR.setCheckedBy(Integer.parseInt(request.getParameter("checkedBy")));
                try {
                    SDR.setReceivedDate();
                } catch (ParseException ex) {
                    Logger.getLogger(SupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
                }     
                if(sdrDAO.EncodeDeliveryReceipt(SDR)){
                    x = true;
                    newPOList.add(SDR);
                }
                else
                    x = false;             
            }
            if (x==true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("SDRreceipt", SDR);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeSupplierDeliveryReceipt.jsp");
                rd.forward(request, response);
            }
        } finally {
            out.close();
        }
        
    }

    
}
