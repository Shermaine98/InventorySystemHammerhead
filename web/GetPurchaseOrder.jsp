<%-- 
    Document   : GetPurchaseOrder
    Created on : 02 20, 15, 11:48:50 AM
    Author     : Shermaine
--%>

<%@page import="Model.PurchaseOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Purchase Order</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    
    <body>
        <br> <br> <br>
        <div class="myrawtable" align= "center">
            <h2>Purchase Order</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px">
                <tr>
                    <th class = "edits">Purchase Order</th>
                    <th class = "edits">Item Description</th>
                    <th class = "edits">Quantity</th>
                    <th class = "edits">Unit Measurement</th>
                    <th class = "edits">Unit Price</th>
                    <th class = "edits">Vat</th>
                    <th class = "edits">Date Made</th>
                    <th class = "edits">Prepared By</th>
                    <th class = "edits">Approved By</th>
                </tr>
                <%   
                    ArrayList<PurchaseOrder> PurchaseOrder = (ArrayList<PurchaseOrder>) session.getAttribute("poList");
                    for (int i = 0; i < PurchaseOrder.size(); i++) {
                      
                %> 
                <tr>
                    <td><%=PurchaseOrder.get(i).getPoNumber()%></td>
                    <td><%= PurchaseOrder.get(i).getItemDescription()%></td>
                    <td><%= PurchaseOrder.get(i).getQty()%></td>
                    <td><%= PurchaseOrder.get(i).getUnitMeasurement()%></td>
                    <td><%= PurchaseOrder.get(i).getUnitprice()%></td>
                    <td><%= PurchaseOrder.get(i).getVat()%></td>
                    <td><%= PurchaseOrder.get(i).getDateMade()%></td>
                    <td><%= PurchaseOrder.get(i).getPreparedBy()%></td>
                    <td><%= PurchaseOrder.get(i).getApprovedBy() %></td>
                </tr>
                <%

                    }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/OK</button></a>
            <a href="EncodePurchaseOrder.jsp"><button type="button" class="btn btn-danger">Encode Purchase Order</button></a>
        </div>
            
            
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
