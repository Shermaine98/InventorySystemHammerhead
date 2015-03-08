<%-- 
    Document   : AccessoriesInventory
    Created on : 02 20, 15, 11:46:23 AM
    Author     : Shermaine
--%>

<%@page import="Model.SupplierDeliveryReceipt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.SupplierDeliveryReceiptDAO"%>
<%@page import="Dao.ConsumptionReportDAO"%>
<%@page import="Dao.PromoDAO"%>
<%@page import="Model.Promo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Monitor Production Inventory</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/TABLE.css" rel="stylesheet">
        <style>
        </style>
        <script>
        </script>
    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Updating Accessories Inventory</h2></center>

    <%
        ArrayList<SupplierDeliveryReceipt> SupplierDeliveryReceipt = (ArrayList<SupplierDeliveryReceipt>) session.getAttribute("SdrList");
    %>

    <div align="center">
        <h1>Delivery Receipt Number</h1>

        <select name="SupplierDeliveryReceipt" style="width:90px">
            <%-- for (int i=0;i>SupplierDeliveryReceipt.size();i++){ --%>
            <option value="Accessories">ll</option>
            <%-- 
               }  
            --%>
        </select>

    </div>
    <form method="POST" action="ProductionInventoryServlet">
        <div align="center">
            <table class="tableContainer" width="80%">
                <thead class="fixedHeader"><tr>  
                        <th>Production Number</th>
                         <th>drNumber</th> 
                        <th>Category</th> 
                        <th>Quantity</th>
                        <th>Unit Measurement</th>

                        <!-- Temporary -->
                        <th>Approval</th> 
                        <th>Note</th> 

                        <!-- Temporary -->
                    </tr></thead>
                <tbody id="dataTable" class="scrollContent"><tr>
                        <td><input type="checkbox" name="chk"/></td>
                    <td><input type="text" name="productionNumber" size="18"/></td>
                    <td><input type="text" name="deliveryReceiptNumber" size="18"/></td>
                        <td><select name="category">  
                                <option value="Tshirt">T-shirt</option>
                                <option value="Pants">Pants</option>
                            </select>
                        </td>

                 
                        
                            <%-- 
                                    for( int i=0; i<DeliveryReceiptNumber.size();i++){
                                        may if statements pa
                        }
                            --%>
                        <td><input type="text" name="qty" size="4"/></td>

                        <td> <select name ="unitMeasurement">
                                <option value="kg">Kilogram</option>
                                <option value="meter">meter</option>
                            </select></td>

                        <td><input type="text" name="approval" size="4"/></td>
                         <td><input type="text" name="note" size="4"/></td>
                    </tr></tbody>
            </table>

            <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
            <br/><br/>
            <input type="submit" class="btn btn-danger" value="OK"/> 
            <a href="updateAccessoriesInventory.jsp"><button type="button" class="btn btn-danger">Update Accessories Inventory</button></a>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
