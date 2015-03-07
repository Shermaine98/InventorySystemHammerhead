<%-- 
    Document   : GetAccessoriesInventory
    Created on : 02 20, 15, 11:49:50 AM
    Author     : Shermaine
--%>


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
                   <th>Accessory Description</th>            
                   <th>Delivery Receipt Number</th>
                   <th>Date Updated</th>
                   <th>Quantity</th>
                   <th>Unit Measurement</th> 
                   <th>Approval</th>
                   <th>Note</th>
                    
                </tr>
                <%
                    ArrayList<AccessoriesInventory> AccessoriesInventory = (ArrayList<AccessoriesInventory>) session.getAttribute("aiList");
                    for (int i = 0; i < AccessoriesInventory.size(); i++) {
                %>
                <tr>
                    <td><input type="checkbox" name="chk"/></td> 
                    <td><%= AccessoriesInventory.get(i).getCategory()%></td>
                    <td><%= AccessoriesInventory.get(i).getAccessoryDescription()%></td>
                    <td><%= AccessoriesInventory.get(i).getDeliveryReceiptNumber()%></td>
                    <td><td><%= AccessoriesInventory.get(i).getDateUpdated()%></td>
                    <td><%= AccessoriesInventory.get(i).getQty()%></td>
                    <td><%= AccessoriesInventory.get(i).getUnitMeasurement()%></td>
                    <td><%= AccessoriesInventory.get(i).isApproval()%></td>
                    <td><%= AccessoriesInventory.get(i).getNote()%></td>
                 
                    
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