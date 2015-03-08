<%-- 
    Document   : GetAccessoriesInventory
    Created on : 02 20, 15, 11:49:50 AM
    Author     : Shermaine
--%>


<%@page import="Model.ConsumptionReportToProductionInventory"%>
<%@page import="Model.ConsumptionReportToAccessoriesInventory"%>
<%@page import="Model.AccessoriesInventory"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>View Accessory Report</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
   </head>
    <body>     
        <br> <br> <br>
         <div class="myrawtable" align= "center">
            <h2>Accessory Report</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px">
                <tr>
                    <th class="edits"></th>
                   <th>Category</th>          
                   <th>Delivery Receipt Number</th>
                   <th>Production Number</th>
                   <th>Product ID</th>
                   <th>Size</th> 
                   <th>Color</th>
                   <th>Consumption</th>
                   <th>Unit</th>
                   <th>Production Quantity</th>
                </tr>
                <%
                    ArrayList <ConsumptionReportToProductionInventory> ConsumptionReportToProductionInventory = (ArrayList<ConsumptionReportToProductionInventory>) session.getAttribute("crtopiList");
                    for (int i = 0; i < ConsumptionReportToProductionInventory.size(); i++) {
                %>
                <tr>
                    <td><input type="checkbox" name="chk"/></td> 
                    <td><%= ConsumptionReportToProductionInventory.get(i).getCategory()%></td>
                   
                    <td><%= ConsumptionReportToProductionInventory.get(i).getDrNumber()%></td>
                    <td><td><%= ConsumptionReportToProductionInventory.get(i).getProductionNumber()%></td>
                    <td><%= ConsumptionReportToProductionInventory.get(i).getProductID()%></td>
                    <td><%= ConsumptionReportToProductionInventory.get(i).getSize()%></td>
                    <td><%= ConsumptionReportToProductionInventory.get(i).getColor()%></td>
                    <td><%= ConsumptionReportToProductionInventory.get(i).getConsumption()%></td>
                    <td><%= ConsumptionReportToProductionInventory.get(i).getUnit()%></td>
                    <td><%= ConsumptionReportToProductionInventory.get(i).getProductionQty()%></td>
                 
                    
                </tr>        
                <%
                                                              }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/Ok</button></a>
            <a href="MonitorAccessoriesInventory.jsp"><button type="button" class="btn btn-danger">Add Inventory to Accessories</button></a>
        </div>
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>