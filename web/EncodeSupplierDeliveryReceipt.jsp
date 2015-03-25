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
            var v="1";
            
            function onChange(data) {
             document.getElementById("display").value = data.value;
             $("#table tbody tr").remove();
                  v= data.value;
            }
            
            function createQuantityName(i) {
                var qty = "quantity"+i;
                return qty;
            }
            function createCommentName(i) {
                var qty = "comment"+i;
                return qty;
            }
        </script>
    </head>
    <body>  
        <br/><br/><br/>

        <div align="center">
            <select name="selected" onchange="onChange(this)" > 
                <option value="1">choose</option>
                <%  
                    ArrayList<PurchaseOrder> PurchaseOrder = (ArrayList<PurchaseOrder>) session.getAttribute("poList");
                    ArrayList<Integer> PONumber = new ArrayList<Integer>();
                    for (int y = 0; y < PurchaseOrder.size(); y++) {

                        if (!(PONumber.contains(PurchaseOrder.get(y).getPoNumber()))) {
                            PONumber.add(PurchaseOrder.get(y).getPoNumber());
                        }
                    }
                    int i=0;
                    for (i=0; i < PONumber.size(); i++) {
                %>
                <option value="<%=PONumber.get(i)%>"> <%=PONumber.get(i)%></option>
                <%
                    }
                
                %>
            </select>
        </div>

        <input id="display" name="poNumberl" >
    <center><h2>Encode Delivery Receipt</h2></center>
    <div id= "center" align="center">
        <form method="POST" action="SupplierDeliveryReceiptServlet">


            <table class="tableContainer" width="50%" id="table">
                <thead class="fixedHeader">
                    <tr>
                        <th>Purchase Order</th>
                        <td><input name="poNumber" type="text" value="<%=PurchaseOrder.get(i).getPoNumber()%>"/></td>
                        <th>Supplier</th>
                        <td><%= PurchaseOrder.get(i).getSupplier()%></td>
                    </tr>
                    <tr>
                        <th>Prepared By</th>
                        <td><%= PurchaseOrder.get(i).getPreparedBy()%></td>
                        <th>Approved By</th>
                        <td><%= PurchaseOrder.get(i).getApprovedBy()%></td>
                    </tr>
                    <tr>
                        <th>Delivery Schedule</th>
                        <td><%= PurchaseOrder.get(i).getDeliverySchedule()%></td>
                        <th>Date Made</th>
                        <td><%= PurchaseOrder.get(i).getDateMade()%></td>
                    </tr>
                    <tr>
                        <th>Item Description</th>
                        <th>Quantity</th>
                        <th>Unit Measurement</th>
                        <th>Unit Price</th>
                        <th>Vat</th>
                        <th>check box</th>
                        <th>Status</th>
                        <th>Quantity</th>
                        <th>Comment</th>
                    </tr>
                <tbody>
                    
                    <%
                        for (int y = 0; y < PurchaseOrder.size(); y++) {
                            if (PurchaseOrder.get(y).getPoNumber() == PurchaseOrder.get(i).getPoNumber()) {
                    %>

                    <tr>
                        <td><input name="itemDescription" value="<%= PurchaseOrder.get(i).getItemDescription()%>"/></td>
                        <td><input name="quantity" value="<%= PurchaseOrder.get(i).getQty()%>"/></td>
                        <td><%= PurchaseOrder.get(i).getUnitMeasurement()%></td>
                        <td><%= PurchaseOrder.get(i).getUnitprice()%></td>
                        <td><%= PurchaseOrder.get(i).getVat()%></td>
                        <td><input type="checkbox" name="chk" onClick="document.getElementById('createCommentName(<%=y%>)').disabled = this.checked;
                                document.getElementById('createQuantityName(<%=y%>)').disabled = this.checked;" checked/></td>
                        <td> 
                            <select name="status">
                                <option value="complete">Complete</option>
                                <option value="in progress">In Progress</option>
                                <option value="incomplete">Incomplete</option>
                                <option value="rejected">rejected</option>
                            </select></td>

                        <td><input type="text" name="qunatity" id="createQuantityName(<%=y%>)" size="5" disabled/></td>
                        <td><input type="text" name="comment" id="createCommentName(<%=y%>)" size="5" disabled/></td>
                    </tr>
                <tbody>
                    <%
                                 i = y;
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