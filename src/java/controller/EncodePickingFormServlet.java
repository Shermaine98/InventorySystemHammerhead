/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.PickingFormDAO;
import Model.PickingForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gcla109
 */
public class EncodePickingFormServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        
        try {
            
            PickingForm pf = new PickingForm();
            
            pf.setColor(request.getParameter("color"));
            try {
                pf.setDateMade();
            } catch (ParseException ex) {
                Logger.getLogger(EncodePickingFormServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            pf.setMadeBy(Integer.parseInt(request.getParameter("madeBy")));
            pf.setProductID(Integer.parseInt(request.getParameter("productID")));
            pf.setPromo(Integer.parseInt(request.getParameter("promo")));
            pf.setRequestedQty(Integer.parseInt(request.getParameter("requestedBy")));
            pf.setSize(request.getParameter("size"));
            
            PickingFormDAO pfDAO = new PickingFormDAO();
            
            if (pfDAO.EncodepickingForm(pf)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/GetPickingForm.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("pf", pf);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodePickingForm.jsp");
                rd.forward(request, response);
                
            }
        } finally {
            out.close();
        }
    }
}
