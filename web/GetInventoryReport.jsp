<%-- 
    Document   : GetInventoryReport
    Created on : 02 20, 15, 3:43:44 PM
    Author     : Shermaine
--%>


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
        
        <title>View Inventory Report</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
   </head>
    <body>     
        <br> <br> <br>
         <div class="myrawtable" align= "center">
            <h2>Inventory Report</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px">
                <tr>
                    <th class="edits"></th>
            
                         <th>Promo</th>
                        <th>Outlet</th>
                        <th>Production Number</th>
                        <th>Sex</th> 
                        <th>Item Description</th> 
                        <th>Age Group</th> 
                        <th>Color</th> 
                        <th>Size</th> 
                        <th>Remaining Quantity</th> 
                        <th>Sold Quantity</th> 
                        <th>Pulled Out Quantity</th>
                </tr>
                <%
                    ArrayList<InventoryReport> InventoryReport = (ArrayList<InventoryReport>) session.getAttribute("irList");
                    for (int i = 0; i < InventoryReport.size(); i++) {
                %>
                <tr>
                    <td><input type="checkbox" name="chk"/></td> 
                    
                    <td><%= InventoryReport.get(i).getPromo()%></td>
                    <td><%= InventoryReport.get(i).getOutlet()%></td>
                    <td><%= InventoryReport.get(i).getProductionNumber()%></td>
                    <td><%= InventoryReport.get(i).getSex()%></td>
                    <td><%= InventoryReport.get(i).getItemDescription()%></td>
                    <td><%= InventoryReport.get(i).getAgeGroup()%></td>
                    <td><%= InventoryReport.get(i).getColor()%></td>
                    <td><%= InventoryReport.get(i).getSize()%></td>
                    <td><%= InventoryReport.get(i).getRemainingQuantity()%></td>
                    <td><%= InventoryReport.get(i).getSoldQty()%></td>
                    <td><%= InventoryReport.get(i).getPulledOutQty()%></td>
                </tr>        
                <%
                                                              }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/Ok</button></a>
            <a href="EncodeInventoryReport.jsp"><button type="button" class="btn btn-danger">Add Inventory Report</button></a>
        </div>
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>