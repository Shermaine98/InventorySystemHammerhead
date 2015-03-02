/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ConsumptionReportToAccessoryInventoryDAO;
import Model.ConsumptionReportToAccessoriesInventory;
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
public class ConsumptionReportToAccessoryInventory extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            ConsumptionReportToAccessoriesInventory CRtoAI = new ConsumptionReportToAccessoriesInventory();
            ArrayList<ConsumptionReportToAccessoriesInventory> arrCRtoAI = new ArrayList<ConsumptionReportToAccessoriesInventory>();
            ConsumptionReportToAccessoryInventoryDAO CRtoAIDAO = new ConsumptionReportToAccessoryInventoryDAO();

            String[] productionNumber = request.getParameterValues("productionNumber");
            String[] category = request.getParameterValues("category");
            String[] accessoryDescription = request.getParameterValues("accessoryDescription");
            String[] consumption = request.getParameterValues("consumption");
            String[] unit = request.getParameterValues("unit");

            boolean x = false;

            for (int i = 0; i < productionNumber.length; i++) {
                CRtoAI.setProductionNumber(Integer.parseInt(productionNumber[i]));
                CRtoAI.setCategory(category[i]);
                CRtoAI.setAccessoryDescription(accessoryDescription[i]);
                CRtoAI.setConsumption(Integer.parseInt(consumption[i]));
                CRtoAI.setUnit(unit[i]);

                if (CRtoAIDAO.EncodeCRTAI(CRtoAI)) {
                    x = true;
                    arrCRtoAI.add(CRtoAI);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("");
                HttpSession session = request.getSession();
                session.setAttribute("arrCRtoAI", arrCRtoAI);
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
