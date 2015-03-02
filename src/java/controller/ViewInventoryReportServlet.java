/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.InventoryReportDAO;
import Model.InventoryReport;
import java.io.IOException;
import java.util.ArrayList;
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
public class ViewInventoryReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            InventoryReportDAO IRDAO = new InventoryReportDAO();
            ArrayList<InventoryReport> irList = IRDAO.GetAllInventoryReport();
            
            ServletContext context = getServletContext();
            HttpSession session = request.getSession();
            RequestDispatcher rd = context.getRequestDispatcher("/GetInventoryReport.jsp");
            session.setAttribute("irList", irList);
            rd.forward(request, response);         
          
    }
}
