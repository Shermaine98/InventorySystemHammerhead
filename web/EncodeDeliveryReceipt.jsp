<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

<%@page import="Model.PurchaseOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<%@include file="security.jsp" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Encode Delivery Order</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <style>

        </style>

        <script>
            $(document).ready(function () {
                $("selected").on("click", function () {

                    $("center").load("center.html");
                });
            });
        </script>
    </head>
    <body>  
        <br/><br/><br/>

        <div id="refresh" align="center">
            <%                ArrayList<PurchaseOrder> PurchaseOrder = (ArrayList<PurchaseOrder>) session.getAttribute("poList");
            %>

            <select name="selected" > 
                <option>choose</option>
                <%
                    for (int i = 0; i < PurchaseOrder.size(); i++) {
                %>
                <option value="<%=PurchaseOrder.get(i).getPoNumber()%>"> <%=PurchaseOrder.get(i).getPoNumber()%></option>
                <%
                    }
                %> 
            </select>

        </div>

    <center><h2>Encode Delivery Receipt</h2></center>
    <div id= "center" align="center">
        <form method="POST" action="ConsumptionReportServlet">

            <%
                int y = 0;
            %>

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
                <tr>
                    <td><%=PurchaseOrder.get(y).getPoNumber()%></td>
                    <td><%= PurchaseOrder.get(y).getItemDescription()%></td>
                    <td><%= PurchaseOrder.get(y).getQty()%></td>
                    <td><%= PurchaseOrder.get(y).getUnitMeasurement()%></td>
                    <td><%= PurchaseOrder.get(y).getUnitprice()%></td>
                    <td><%= PurchaseOrder.get(y).getVat()%></td>
                    <td><%= PurchaseOrder.get(y).getDateMade()%></td>
                    <td><%= PurchaseOrder.get(y).getPreparedBy()%></td>
                </tr>
            </table>

            <table class="tableContainer" width="70%">
                <thead class="fixedHeader">
                    <tr>
                        <th>Delivery Receipt Number</th>
                        <th>Production Number</th>
                        <th>Checked By</th>
                        <th>received By</th> 
                    </tr>
                </thead>
                <tbody id="dataTable" class="scrollContent">
                    <tr>
                        <td><input type="text" name="deliveryReceiptNumber" size="10"/></td>
                        <td><input type="text" name="poNumber" size="16"/></td>                    
                        <td><input type="text" name="checkedBy" size="16"/></td>                   
                        <td><input type="text" name="receivedBy" size="16"/></td>
                    </tr>
                </tbody>
            </table>
            <br/><br/>
            <input type="submit" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>

        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
