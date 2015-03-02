<%-- 
    Document   : GetWarehouseInventory
    Created on : 02 20, 15, 11:49:19 AM
    Author     : Shermaine
--%>

<%@page import="Model.WarehouseInventory"%>
<%@page import="Model.InventoryReport"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>View Warehouse Inventory</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>     
        <br> <br> <br>
        <div class="myrawtable" align= "center">
            <h2>Warehouse Inventory</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px">
                <tr>
                    <th class="edits"></th>
                     <th>Get Updated</th>
                    <th>Production Number</th>
                    <th>Sex</th>     
                    <th>Item Description</th> 
                    <th>Age Group</th> 
                    <th>Color</th> 
                    <th>Size</th> 
                    <th>Quantity</th> 
                </tr>
                <%
                    ArrayList<WarehouseInventory> WarehouseInventory = (ArrayList<WarehouseInventory>) session.getAttribute("wiList");
                    for (int i = 0; i < WarehouseInventory.size(); i++) {
                %>
                <tr>
                    <td><input type="checkbox" name="chk"/></td> 
 
                    <td><%= WarehouseInventory.get(i).getDateUpdated()%></td>
                    <td><%= WarehouseInventory.get(i).getProductionNumber()%></td>
                    <td><%= WarehouseInventory.get(i).getSex()%></td>
                    <td><%= WarehouseInventory.get(i).getItemDescription()%></td>
                    <td><%= WarehouseInventory.get(i).getAgeGroup()%></td>
                    <td><%= WarehouseInventory.get(i).getColor()%></td>
                    <td><%= WarehouseInventory.get(i).getSize()%></td>
                    <td><%= WarehouseInventory.get(i).getQty()%></td>
              
                </tr>        
                <%
                    }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/Ok</button></a>
            <a href="MonitorWarehouseInventory.jsp"><button type="button" class="btn btn-danger">Add Inventory to Warehouse</button></a>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>