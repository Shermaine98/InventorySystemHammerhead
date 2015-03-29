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
        <h2>View Supplier Purchase Order</h2>
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
            <table id="dataTable" class="table table-hover" style= "width:800px">

                <%
                    ArrayList<PurchaseOrder> PurchaseOrder = (ArrayList<PurchaseOrder>) session.getAttribute("poList");
                    for (int i = 0; i < PurchaseOrder.size(); i++) {

                %> 
                <tr>
                    <th class = "edits">Purchase Order</th>
                    <td><%=PurchaseOrder.get(i).getPoNumber()%></td>
                    <th class = "edits">Supplier</th>
                    <td><%= PurchaseOrder.get(i).getSupplier()%></td>
                </tr>
                <tr>
                    <th class = "edits">Prepared By</th>
                    <td><%= PurchaseOrder.get(i).getPreparedBy()%></td>
                    <th class = "edits">Approved By</th>
                    <td><%= PurchaseOrder.get(i).getApprovedBy()%></td>
                </tr>
                <tr>
                    <th class = "edits">Delivery Schedule</th>
                    <td><%= PurchaseOrder.get(i).getDeliverySchedule()%></td>
                    <th class = "edits">Date Made</th>
                    <td><%= PurchaseOrder.get(i).getDateMade()%></td>
                </tr>
                <tr>
                    <th class = "edits">Item Description</th>
                    <th class = "edits">Quantity</th>
                    <th class = "edits">Unit Measurement</th>
                    <th class = "edits">Unit Price</th>
                    <th class = "edits">Vat</th>
                </tr>
                <%
                    for (int y = 0; y < PurchaseOrder.size(); y++) {
                        if (PurchaseOrder.get(y).getPoNumber() == PurchaseOrder.get(i).getPoNumber()) {
                %>

                <tr>
                    <td><%= PurchaseOrder.get(y).getItemDescription()%></td>
                    <td><%= PurchaseOrder.get(y).getQty()%></td>
                    <td><%= PurchaseOrder.get(y).getUnitMeasurement()%></td>
                    <td><%= PurchaseOrder.get(y).getUnitprice()%></td>
                    <td><%= PurchaseOrder.get(y).getVat()%></td>

                </tr>
                <%
                                i = y;
                            }
                        }
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
