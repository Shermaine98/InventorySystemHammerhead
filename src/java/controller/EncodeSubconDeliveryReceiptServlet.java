/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.SubconDeliveryReceiptDAO;
import Model.SubconDeliveryReceipt;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class EncodeSubconDeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        
        try {
            
            SubconDeliveryReceipt SDR = new SubconDeliveryReceipt();
            
            SDR.setCheckedBy(Integer.parseInt(request.getParameter("checkedBy")));
            SDR.setColor(request.getParameter("color"));
            SDR.setComment(request.getParameter("comment"));
            
            try {
                //            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date dateReceived = formatter.parse(df.format(request.getParameter("dateReceived")));
//            java.sql.Date dateReceivedSQL = new java.sql.Date(dateReceived.getTime());
//            SDR.setDateReceived(dateReceivedSQL);
                SDR.setDateRecieved();
            } catch (ParseException ex) {
                Logger.getLogger(EncodeSubconDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            SDR.setDrNumber(Integer.parseInt(request.getParameter("drNumber")));
            SDR.setPoNumber(Integer.parseInt(request.getParameter("PONumber")));
            SDR.setProductID(Integer.parseInt(request.getParameter("productID")));
            SDR.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
            SDR.setQty(Integer.parseInt(request.getParameter("qty")));
            SDR.setReceivedBy(Integer.parseInt(request.getParameter("receivedBy")));
            SDR.setSize(request.getParameter("size"));
            SDR.setStatus(request.getParameter("status"));
            
            SubconDeliveryReceiptDAO sdrDAO = new SubconDeliveryReceiptDAO();
            
            if (sdrDAO.EncodeSubconDeliveryReceipt(SDR)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ViewSubconDeliveryReceipt.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("SDR", SDR);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeSubconDeliveryReceipt.jsp");
                rd.forward(request, response);
                
            }
        } finally {
            out.close();
        }
    }
}
