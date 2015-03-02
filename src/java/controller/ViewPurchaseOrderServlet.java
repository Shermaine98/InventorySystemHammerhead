/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.PurchaseOrderDAO;
import Model.PurchaseOrder;
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
public class ViewPurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PurchaseOrderDAO PODAO = new PurchaseOrderDAO();
            ArrayList<PurchaseOrder> poList = PODAO.GetAllPurchaseOrder();
            
            ServletContext context = getServletContext();
            HttpSession session = request.getSession();
            RequestDispatcher rd = context.getRequestDispatcher("/GetPurchaseOrder.jsp");
            session.setAttribute("poList", poList);
            rd.forward(request, response);         
          
    }
}
