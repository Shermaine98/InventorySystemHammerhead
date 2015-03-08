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
            <%                ArrayList<PurchaseOrder> PurchaseOrder = (ArrayList<PurchaseOrder>) session.getAttribute("poList");
            %>
            var textBlocks = new Array(<%=PurchaseOrder.size()%>);
            var i;
            <% int i = 0;%>;
            for (i = 0; i < 10; i++)
            {
                textBlocks[i] = <%=PurchaseOrder.get(i).getPoNumber()%>;
            <%i++;%>
            }
            function changeText(elemid) {
                var ind = document.getElementById(elemid).selectedIndex;
                document.getElementById("display").innerHTML = textBlocks[ind];
            }
        </script>
    </head>
    <body>  
        <br/><br/><br/>

        <div id="refresh" align="center" >


            <select id="selected" onChange="changeText('selected')" > 
                <option>choose</option>
                <%
                    for (int y = 0; y < PurchaseOrder.size(); y++) {
                %>
                <option value="<%=PurchaseOrder.get(i).getPoNumber()%>"> <%=PurchaseOrder.get(i).getPoNumber()%></option>
                <%
                    }
                %> 
            </select>

        </div>

    <center><h2>Encode Delivery Receipt</h2></center>
    <div id= "center" align="center">
        <form method="POST" action="SupplierDeliveryReceiptServlet">
            <div id="display">Select from the list to change this box</div> 

            <table class="tableContainer" width="50%">
                <thead class="fixedHeader">
                    <tr>
                        <th class = "edits">Purchase Order</th>
                        <td><input name="poNumber" type="text" value="<%=PurchaseOrder.get(1).getPoNumber()%>"/></td>
                        <th class = "edits">Supplier</th>
                        <td><%= PurchaseOrder.get(1).getSupplier()%></td>
                    </tr>
                    <tr>
                        <th class = "edits">Prepared By</th>
                        <td><%= PurchaseOrder.get(1).getPreparedBy()%></td>
                        <th class = "edits">Approved By</th>
                        <td><%= PurchaseOrder.get(1).getApprovedBy()%></td>
                    </tr>
                    <tr>
                        <th class = "edits">Delivery Schedule</th>
                        <td><%= PurchaseOrder.get(1).getDeliverySchedule()%></td>
                        <th class = "edits">Date Made</th>
                        <td><%= PurchaseOrder.get(1).getDateMade()%></td>
                    </tr>
                    <tr>
                        <th class = "edits">Item Description</th>
                        <th class = "edits">Quantity</th>
                        <th class = "edits">Unit Measurement</th>
                        <th class = "edits">Unit Price</th>
                        <th class = "edits">Vat</th>
                        <th>checkbox<th>
                        <th>Status</th>
                    </tr>
                    <%
                        for (int y = 0; y < PurchaseOrder.size(); y++) {
                            if (PurchaseOrder.get(y).getPoNumber() == PurchaseOrder.get(1).getPoNumber()) {
                    %>

                    <tr>
                        <td><input name="itemDescription" value="<%= PurchaseOrder.get(y).getItemDescription()%>"/></td>
                        <td><%= PurchaseOrder.get(y).getQty()%></td>
                        <td><%= PurchaseOrder.get(y).getUnitMeasurement()%></td>
                        <td><%= PurchaseOrder.get(y).getUnitprice()%></td>
                        <td><%= PurchaseOrder.get(y).getVat()%></td>
                        <td><input type="checkbox" name="chk"/></td>
                        <td> 
                        <select name="status">
                                <option value="in progress">In Progress</option>
                                <option value="complete">Complete</option>
                                <option value="incomplete">Incomplete</option>
                                <option value="rejected">rejected</option>
                         </select></td>
                         <th>Quantity</th>
                          <td><input type="text" name="qunatity" size="5" disabled/></td>
                        <th>Comment</th>
                         <td><input type="text" name="comment" size="5" disabled/></td>
                         </tr>
                    <%
                                // i = y;
                            }
                        }
                    %>
                    <tr>
                        <th>received by</th>
                        <td> <input name="receivedBy" size="10" type="text"/><td>
                        <th>Checked by</th>
                        <td> <input name="checkedBy" size="10" type="text"/><td>
                    </tr>


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