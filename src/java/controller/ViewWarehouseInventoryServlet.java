/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.WarehouseInventoryDAO;
import Model.WarehouseInventory;
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
public class ViewWarehouseInventoryServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            WarehouseInventoryDAO WIDAO = new WarehouseInventoryDAO();
            ArrayList<WarehouseInventory> wiList = WIDAO.MonitorWarehouseInventory();
            
            ServletContext context = getServletContext();
            HttpSession session = request.getSession();
            RequestDispatcher rd = context.getRequestDispatcher("/GetWarehouseInventory.jsp");
            session.setAttribute("wiList", wiList);
            rd.forward(request, response);         
          
    }
}
