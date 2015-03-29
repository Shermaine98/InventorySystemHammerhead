<%-- 
    Document   : GetPurchaseOrder
    Created on : 02 20, 15, 11:48:50 AM
    Author     : Shermaine
--%>

<%@page import="Model.SubconPurchaseOrder"%>
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
        <title>View Subcontractor Purchase Order</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <br> <br> <br>
        <div class="myrawtable" align= "center">
        <h2>View Subcontractor Purchase Order</h2>
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
                    ArrayList<SubconPurchaseOrder> SubconPurchaseOrder = (ArrayList<SubconPurchaseOrder>) session.getAttribute("subconPurchaseOrder");
                    for (int i = 0; i < SubconPurchaseOrder.size(); i++) {

                %> 
                <tr>
                    <th class = "edits">Purchase Order</th>
                    <td><%=SubconPurchaseOrder.get(i).getPoNumber()%></td>
                    <th class = "edits">Production Number</th>
                    <td><%= SubconPurchaseOrder.get(i).getProductionNumber()%></td>
                    <th class = "edits">Subcontractor ID</th>
                    <td><%= SubconPurchaseOrder.get(i).getSubcon()%></td>
                    <th class = "edits">Service ID</th>
                    <td><%= SubconPurchaseOrder.get(i).getService()%></td>
                </tr>
                <tr>
                    <th class = "edits">Prepared By</th>
                    <td><%= SubconPurchaseOrder.get(i).getPreparedBy()%></td>
                    <th class = "edits">Approved By</th>
                    <td><%= SubconPurchaseOrder.get(i).getApprovedBy()%></td>
                </tr>
                <tr>
                    <th class = "edits">Delivery Schedule</th>
                    <td><%= SubconPurchaseOrder.get(i).getDeliverySchedule()%></td>
                    <th class = "edits">Date Made</th>
                    <td><%= SubconPurchaseOrder.get(i).getDateMade()%></td>
                </tr>
                <tr>
                    <th class = "edits">Product ID</th>
                    <th class = "edits">Size</th>
                    <th class = "edits">Color</th>
                    <th class = "edits">Quantity</th>
                    <th class = "edits">Unit Price</th>
                </tr>
                <%
                    for (int y = 0; y < SubconPurchaseOrder.size(); y++) {
                        if (SubconPurchaseOrder.get(y).getPoNumber() == SubconPurchaseOrder.get(i).getPoNumber()) {
                %>

                <tr>
                    <td><%= SubconPurchaseOrder.get(y).getProductID()%></td>
                    <td><%= SubconPurchaseOrder.get(y).getSize()%></td>
                    <td><%= SubconPurchaseOrder.get(y).getColor()%></td>
                    <td><%= SubconPurchaseOrder.get(y).getQty()%></td>
                    <td><%= SubconPurchaseOrder.get(y).getUnitPrice()%></td>
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
            <a href="EncodeSubconPurchaseOrder.jsp"><button type="button" class="btn btn-danger">Encode Purchase Order</button></a>
        </div>


        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
