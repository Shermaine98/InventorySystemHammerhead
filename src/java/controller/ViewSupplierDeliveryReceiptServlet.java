/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.SupplierDeliveryReceiptDAO;
import Model.SupplierDeliveryReceipt;
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
public class ViewSupplierDeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SupplierDeliveryReceiptDAO DRDAO = new SupplierDeliveryReceiptDAO();
        ArrayList<SupplierDeliveryReceipt> SdrList = DRDAO.GetDeliveryReceiptList();
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        RequestDispatcher rd = context.getRequestDispatcher("/GetSupplierDeliveryReceipt.jsp");
        session.setAttribute("SdrList", SdrList);
        rd.forward(request, response); 
    }
}
