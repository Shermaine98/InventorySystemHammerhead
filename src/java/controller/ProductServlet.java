/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.ProductDAO;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ProductServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            Product product = new Product();
            product.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
            product.setSex(request.getParameter("sex"));
            product.setItemDescription(request.getParameter("itemDescription"));
            product.setAgeGroup(request.getParameter("ageGroup"));
            product.setColor(request.getParameter("color"));
            product.setSize(request.getParameter("size"));
            product.setUnitPrice(Double.parseDouble(request.getParameter("unitPrice")));
            
            ProductDAO productDAO = new ProductDAO();
            
            if (productDAO.EncodeProduct(product)) {
                out.print("Valid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/GetProductList.jsp");
                HttpSession session = request.getSession();
                session.setAttribute("product", product);
                rd.forward(request, response);
            } else {
                out.print("Invalid");
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/EncodeProduct.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}