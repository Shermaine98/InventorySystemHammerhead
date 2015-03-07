/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.DeliveryOrderDAO;
import Model.DeliveryOrder;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ViewDeliveryOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DeliveryOrderDAO DODAO = new DeliveryOrderDAO();
            ArrayList<DeliveryOrder> doList = DODAO.GetDeliveryOrderList();
            
            ServletContext context = getServletContext();
            HttpSession session = request.getSession();
            RequestDispatcher rd = context.getRequestDispatcher("/MonitorDeliveryOrder.jsp");
            session.setAttribute("doList", doList);
            rd.forward(request, response);         
        } catch (ParseException ex) {
            Logger.getLogger(ViewDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
}
