/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ConsumptionReportDAO;
import Model.ConsumptionReport;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
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
 * @author Jed
 */
public class ConsumptionReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            ConsumptionReport consumptionReport = new ConsumptionReport();
            consumptionReport.setProductID(Integer.parseInt(request.getParameter("productID")));
            consumptionReport.setSize(request.getParameter("size"));
            consumptionReport.setColor(request.getParameter("color"));
            consumptionReport.setProdQty(Integer.parseInt(request.getParameter("productionQty")));
            consumptionReport.setPreparedBy(Integer.parseInt(request.getParameter("preparedBy")));
            consumptionReport.setApprovedBy(Integer.parseInt(request.getParameter("approvedBy")));
            try {
                consumptionReport.setDateMade();
            } catch (ParseException ex) {
                Logger.getLogger(ConsumptionReportServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            ConsumptionReportDAO consumptionReportDAO = new ConsumptionReportDAO();
            if (consumptionReportDAO.EncodeConsumptionReport(consumptionReport)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("consumptionReport", consumptionReport);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeConsumptionReport.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }

    }
}
