<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

<%@page import="Model.SupplierDeliveryReceipt"%>
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
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Add Item</h2></center>
    <form method="POST" action="ConsumptionReportServlet">
        <div align="center">
            <table id="dataTable" class="table table-hover" style= "width:800px">
            
                     <tr>
                        <th>Delivery Receipt Number</th>
                        <th>Production Number</th>
                        <th>Item Description</th>
                        <th>Received Date</th>
                        <th>Checked by</th>
                        <th>received By</th>
                        <th>Status</th>
                        <th>Quantity</th>
                        <th>Comment</th>
                    </tr>
               
                <%
                    ArrayList<SupplierDeliveryReceipt> SDeliveryReceipt = (ArrayList<SupplierDeliveryReceipt>) session.getAttribute("SdrList");
                    for (int i = 0; i < SDeliveryReceipt.size(); i++) {
                %>
                <tr>
                    <td><input type="checkbox" name="chk"/></td> 
 
                    <td><%= SDeliveryReceipt.get(i).getDeliveryReceiptNumber()%></td>
                    <td><%= SDeliveryReceipt.get(i).getPoNumber()%></td>
                    <td><%= SDeliveryReceipt.get(i).getItemDescription()%></td>
                    <td><%= SDeliveryReceipt.get(i).getReceivedDate()%></td>
                    <td><%= SDeliveryReceipt.get(i).getCheckedBy()%></td>
                    <td><%= SDeliveryReceipt.get(i).getreceivedBy()%></td> 
                    <td><%= SDeliveryReceipt.get(i).getStatus()%></td>
                    <td><%= SDeliveryReceipt.get(i).getQty()%></td>
                    <td><%= SDeliveryReceipt.get(i).getComment()%></td>
                </tr>        
                <%
                    }
                %>
            </table>

            <br/><br/>
            <input type="submit" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
