/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.DeliveryScheduleDAO;
import Model.DeliverySchedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class deliveryScheduleServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DeliverySchedule deliverySchedule = new DeliverySchedule();
            deliverySchedule.setDeliveryOrderNumber(Integer.parseInt("deliveryOrderNumber"));
            deliverySchedule.setDate(Date.valueOf("schedule"));
            deliverySchedule.setPreparedBy(Integer.parseInt("preparedBy"));
            deliverySchedule.setDriver(Integer.parseInt("driver"));

            DeliveryScheduleDAO deliveryScheduleDAO = new DeliveryScheduleDAO();
            if (deliveryScheduleDAO.EncodeDeliverySchedule(deliverySchedule)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("");
                HttpSession session = request.getSession();
                session.setAttribute("deliverySchedule", deliverySchedule);
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
