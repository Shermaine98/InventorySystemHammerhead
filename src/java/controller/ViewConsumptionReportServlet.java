/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ConsumptionReportDAO;
import Dao.ConsumptionReportToAccessoryInventoryDAO;
import Model.ConsumptionReport;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author gcla109
 */
public class ViewConsumptionReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ConsumptionReportDAO CRTOAIDAO = new ConsumptionReportDAO();
            ArrayList<ConsumptionReport> crtoaiList = CRTOAIDAO.GetConsumptionReportList();
            
            ServletContext context = getServletContext();
            HttpSession session = request.getSession();
            RequestDispatcher rd = context.getRequestDispatcher("/ViewConsumptionReports.jsp");
            session.setAttribute("crlist", crtoaiList);
            rd.forward(request, response);         
          
    }
}
