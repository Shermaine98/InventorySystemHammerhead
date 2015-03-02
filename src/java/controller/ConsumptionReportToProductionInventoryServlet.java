/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ConsumptionReportToProductionInventoryDAO;
import Model.ConsumptionReportToProductionInventory;
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
 * @author Jed
 */
public class ConsumptionReportToProductionInventoryServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            ConsumptionReportToProductionInventory CRtoPI = new ConsumptionReportToProductionInventory();
            ArrayList<ConsumptionReportToProductionInventory> arrCRtoPI = new ArrayList<ConsumptionReportToProductionInventory>();
            ConsumptionReportToProductionInventoryDAO CRtoPIDAO = new ConsumptionReportToProductionInventoryDAO();

            String[] productionNumber = request.getParameterValues("productionNumber");
            String[] stockNumber = request.getParameterValues("stockNumber");
            String[] category = request.getParameterValues("category");
            String[] consumption = request.getParameterValues("consumption");
            String[] unit = request.getParameterValues("unit");

            boolean x = false;

            for (int i = 0; i < productionNumber.length; i++) {
                CRtoPI.setProductionNumber(Integer.parseInt(productionNumber[i]));
                CRtoPI.setStockNumber(Integer.parseInt(stockNumber[i]));
                CRtoPI.setCategory(category[i]);
                CRtoPI.setConsumption(Integer.parseInt(consumption[i]));
                CRtoPI.setUnitMeasurement(unit[i]);

                if (CRtoPIDAO.EncodeCRTAI(CRtoPI)) {
                    x = true;
                    arrCRtoPI.add(CRtoPI);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("");
                HttpSession session = request.getSession();
                session.setAttribute("arrCRtoPI", arrCRtoPI);
                rd.forward(request, response);

            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }

    }

}
