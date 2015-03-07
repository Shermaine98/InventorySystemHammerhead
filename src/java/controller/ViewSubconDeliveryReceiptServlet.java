/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.SubconDeliveryReceiptDAO;
import Model.SubconDeliveryReceipt;
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
public class ViewSubconDeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubconDeliveryReceiptDAO sdrDAO = new SubconDeliveryReceiptDAO();
        ArrayList<SubconDeliveryReceipt> subconDeliveryReceipt = new ArrayList<SubconDeliveryReceipt>();
        
        try {
            subconDeliveryReceipt = sdrDAO.MonitorDeliveryReceipt();
        } catch (ParseException ex) {
            Logger.getLogger(ViewSubconPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        RequestDispatcher rd = context.getRequestDispatcher("/ViewSubconDeliveryReceipt.jsp");
        session.setAttribute("subconDeliveryReceipt", subconDeliveryReceipt);
        rd.forward(request, response);

    }
}
