/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.DeliveryOrderDAO;
import Model.DeliveryOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class DeliveryOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            DeliveryOrder deliveryOrder = new DeliveryOrder();
            ArrayList<DeliveryOrder> arrDeliveryOrder = new ArrayList<DeliveryOrder>();
            DeliveryOrderDAO deliveryOrderDAO = new DeliveryOrderDAO();

            String[] deliveryOrderNumber = request.getParameterValues("deliveryOrderNumber");
            String[] promo = request.getParameterValues("promo");
            String[] ProductID = request.getParameterValues("ProductID");
            String[] size = request.getParameterValues("size");
            String[] color = request.getParameterValues("color");
            String[] deliveryQty = request.getParameterValues("deliveryQty");
            String[] approved = request.getParameterValues("approved");
            String[] approvedBy = request.getParameterValues("approvedBy");
            String[] preparedBy = request.getParameterValues("preparedBy");

            boolean x = false;

            for (int i = 0; i < deliveryOrderNumber.length; i++) {
              
                deliveryOrder.setPromo(Integer.parseInt(promo[i]));
                deliveryOrder.setProductID(Integer.parseInt(ProductID[i]));
                deliveryOrder.setSize(size[i]);
                deliveryOrder.setColor(color[i]);
                deliveryOrder.setDeliveryQty(Integer.parseInt(deliveryQty[i]));
                deliveryOrder.setApproved(Boolean.parseBoolean(approved[i]));
                deliveryOrder.setApprovedBy(Integer.parseInt(approvedBy[i]));
                deliveryOrder.setPreparedBy(Integer.parseInt(preparedBy[i]));

                if (deliveryOrderDAO.EncodeDeliveryOrder(deliveryOrder)) {
                    x = true;
                    arrDeliveryOrder.add(deliveryOrder);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/MonitorDeliveryOrder.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("arrDeliveryOrder", arrDeliveryOrder);
                rd.forward(request, response);

            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeDeliveryOrder.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }

    }

}
