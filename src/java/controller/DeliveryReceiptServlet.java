/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.DeliveryReceiptDAO;
import Model.DeliveryReceipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jed
 */
public class DeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
            ArrayList<DeliveryReceipt> arrDeliveryReceipt = new ArrayList<DeliveryReceipt>();
            DeliveryReceiptDAO deliveryReceiptDAO = new DeliveryReceiptDAO();

            String[] deliveryReceiptNumber = request.getParameterValues("deliveryReceiptNumber");
            String[] poNumber = request.getParameterValues("poNumber");
            String[] dateReceived = request.getParameterValues("dateReceived");
            String[] checkedBy = request.getParameterValues("checkedBy");
            String[] receivedBy = request.getParameterValues("receivedBy");

            boolean x = false;

            for (int i = 0; i < deliveryReceiptNumber.length; i++) {
                deliveryReceipt.setDeliveryReceiptNumber(Integer.parseInt(deliveryReceiptNumber[i]));
                deliveryReceipt.setPoNumber(Integer.parseInt(poNumber[i]));
                deliveryReceipt.setReceivedDate(Date.valueOf(dateReceived[i]));
                deliveryReceipt.setCheckedBy(Integer.parseInt(checkedBy[i]));
                deliveryReceipt.setApprovedBy(Integer.parseInt(receivedBy[i]));

                if (deliveryReceiptDAO.EncodeDeliveryReceipt(deliveryReceipt)) {
                    x = true;
                    arrDeliveryReceipt.add(deliveryReceipt);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/");
                HttpSession session = request.getSession();
                session.setAttribute("arrDeliveryReceipt", arrDeliveryReceipt);
                rd.forward(request, response);

            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }

    }

}
