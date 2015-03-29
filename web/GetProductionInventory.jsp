<%-- 
    Document   : GetProductionInventory
    Created on : 02 20, 15, 11:49:30 AM
    Author     : Shermaine
--%>

<%@page import="Model.ProductionInventory"%>
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
        
        <title>View Production Inventory</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
   </head>
    <body>     
         <br> <br> <br>
        <div class="myrawtable" align= "center">
        <h2>Monitor Production Inventory</h2>
        </div>
        
        <div class="container">
            <div class="row">
                <div id="custom-search-input">
                    <div class="input-group col-md-12">
                        <input type="text" class="  search-query form-control" placeholder="Search" />
                        <span class="input-group-btn">
                            <button class="btn btn-danger" type="button">
                                <span class=" glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <br> <br> <br>
         <div class="myrawtable" align= "center">
           
            <table id="dataTable" class="table table-hover" style= "width:800px ">
                <tr>
                    <th>Production Number</th>
                    <th>Category</th>
                    <th>Delivery Receipt Number</th>
                    <th>Date Updated</th> 
                    <th>Quantity</th> 
                    <th>Unit Measurement</th> 
                    <th>Approval</th> 
                    <th>Note</th> 
                </tr>
                <%
                    ArrayList<ProductionInventory> ProductionInventory = (ArrayList<ProductionInventory>) session.getAttribute("piList");
                    for (int i = 0; i < ProductionInventory.size(); i++) {
                %>
                <tr>
                    
                    <td><%= ProductionInventory.get(i).getProductionNumber()%></td>
                    <td><%= ProductionInventory.get(i).getCategory()%></td>
                    <td><%= ProductionInventory.get(i).getDrNumber()%></td>
                    <td><%= ProductionInventory.get(i).getDateUpdated() %></td>
                    <td><%= ProductionInventory.get(i).getQty() %></td>
                    <td><%= ProductionInventory.get(i).getUnitMeasurement() %></td>
                    <td><%= ProductionInventory.get(i).isApproval()%></td>
                    <td><%= ProductionInventory.get(i).getNote()%></td>
                                       
                </tr>        
                <%
                                                              }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/Ok</button></a>
            <a href="MonitorProductionInventory.jsp"><button type="button" class="btn btn-danger">Add Inventory to Production</button></a>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>