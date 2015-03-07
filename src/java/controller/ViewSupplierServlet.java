/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.RefSupplierDAO;
import Dao.SupplierDeliveryReceiptDAO;
import Model.RefSupplier;
import Model.SupplierDeliveryReceipt;
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
public class ViewSupplierServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RefSupplierDAO RefSupplierDAO = new RefSupplierDAO();
            ArrayList<RefSupplier> RefSupplier = RefSupplierDAO.MonitorRefSupplier();
            
            ServletContext context = getServletContext();
            HttpSession session = request.getSession();
            RequestDispatcher rd = context.getRequestDispatcher("/GetSupplier.jsp");
            session.setAttribute("SList", RefSupplier);
            rd.forward(request, response);         
          
    }
}
