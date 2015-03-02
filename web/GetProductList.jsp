<%-- 
    Document   : GetProductList
    Created on : 02 20, 15, 11:48:28 AM
    Author     : Shermaine
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Product</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    
    <body>
        <br> <br> <br>
        <div class="myrawtable" align= "center">
            <h2>Product</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px">
                <tr>
                    <th class = "edits">Production Number</th>
                    <th class = "edits">Sex</th>
                    <th class = "edits">Item Description</th>
                    <th class = "edits">Age Group</th>
                    <th class = "edits">Color</th>
                    <th class = "edits">Size</th>
                    <th class = "edits">Unit Price</th>
                </tr>
                <%   
                    ArrayList<Product> Product = (ArrayList<Product>) session.getAttribute("productList");
                    for (int i = 0; i < Product.size(); i++) {
                      
                %> 
                <tr>
                    <td><%=Product.get(i).getProductionNumber()%></td>
                    <td><%= Product.get(i).getSex()%></td>
                    <td><%= Product.get(i).getItemDescription()%></td>
                    <td><%= Product.get(i).getAgeGroup()%></td>
                    <td><%= Product.get(i).getColor()%></td>
                    <td><%= Product.get(i).getSize()%></td>
                    <td><%= Product.get(i).getUnitPrice()%></td>
                </tr>
                <%

                    }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/OK</button></a>
            <a href="EncodeProduct.jsp"><button type="button" class="btn btn-danger">Add Product</button></a>
        </div>
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
