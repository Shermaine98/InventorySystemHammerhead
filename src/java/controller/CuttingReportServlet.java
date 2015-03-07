/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.CuttingReportDAO;
import Model.CuttingReport;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jed
 */
public class CuttingReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            CuttingReport cuttingReport = new CuttingReport();
            
            cuttingReport.setCategory(request.getParameter("category")); 
            cuttingReport.setDrNumber(Integer.parseInt(request.getParameter("drNumber")));
            cuttingReport.setCuttingMaster(Integer.parseInt(request.getParameter("cuttingMaster")));
            cuttingReport.setRawQty(Integer.parseInt(request.getParameter("rawQty")));
            cuttingReport.setCalculatedQty(Integer.parseInt(request.getParameter("calculatedQty")));
            cuttingReport.setActualQty(Integer.parseInt(request.getParameter("actualQty")));
            cuttingReport.setComment(request.getParameter("comment"));
            
            CuttingReportDAO cuttingReportDAO = new CuttingReportDAO();
            if (cuttingReportDAO.EncodeCuttingReport(cuttingReport)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ViewCuttingReport.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("cuttingReport", cuttingReport);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeCuttingReport.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }

    }
}
