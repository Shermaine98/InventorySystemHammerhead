<%-- 
    Document   : MonitorDeliveryOrders
    Created on : 02 20, 15, 12:13:28 PM
    Author     : Shermaine
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.DeliveryOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Monitor Delivery Order</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    
    <body>
        <br> <br> <br>
        <div class="myrawtable" align= "center">
            <h2>Delivery Order</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px">
                <tr>
                    <th class="edits"></th>
                    <th class = "edits">Delivery Order Number</th>
                    <th class = "edits">Promo</th>
                    <th class = "edits">Outlet</th>
                    <th class = "edits">Production Number</th>
                    <th class = "edits">Sex</th>
                    <th class = "edits">Item Description</th>
                    <th class = "edits">Age Group</th>
                    <th class = "edits">Color</th>
                    <th class = "edits">Size</th>
                    <th class = "edits">Quantity</th>
                    <th class = "edits">Received</th>
                    <th class = "edits">Prepared By</th>
                </tr>
                <%
                    ArrayList<DeliveryOrder> DeliveryOrder = (ArrayList<DeliveryOrder>) session.getAttribute("doList");
                    for (int i = 0; i < DeliveryOrder.size(); i++) {
                %>
                <tr>
                    <td><input type="checkbox" name="chk"/></td>
                    <td><%= DeliveryOrder.get(i).getDeliveryOrderNumber()%></td>
                    <td><%= DeliveryOrder.get(i).getPromo()%></td>
                    <td><%= DeliveryOrder.get(i).getOutlet()%></td>
                    <td><%= DeliveryOrder.get(i).getProductionNumber()%></td>
                    <td><%= DeliveryOrder.get(i).getSex()%></td>
                    <td><%= DeliveryOrder.get(i).getItemDescription()%></td>
                    <td><%= DeliveryOrder.get(i).getAgeGroup()%></td>
                    <td><%= DeliveryOrder.get(i).getColor()%></td>
                    <td><%= DeliveryOrder.get(i).getSize()%></td>
                    <td><%= DeliveryOrder.get(i).getQty()%></td>
                    <td><%= DeliveryOrder.get(i).getReceive()%></td>
                    <td><%= DeliveryOrder.get(i).getPreparedBy()%></td>       
                </tr>        
                <%
                    }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back</button></a>
            <a href="EncodeDeliveryOrder.jsp"><button type="button" class="btn btn-danger">Add Delivery Order</button></a>
        </div>
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
