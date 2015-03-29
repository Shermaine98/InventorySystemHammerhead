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
        <div class="myrawtable" align= "center">
        <h2>View Supplier Delivery Receipt</h2>
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
    <form method="POST" action="ConsumptionReportServlet">
        <div align="center">
            <table id="dataTable" class="table table-hover" style= "width:800px">


                <%                   
               ArrayList<SupplierDeliveryReceipt> SDeliveryReceipt = (ArrayList<SupplierDeliveryReceipt>) session.getAttribute("SdrList");
                    for (int i = 0; i < SDeliveryReceipt.size(); i++) {
                %>
                <tr>
                    <th>Delivery Receipt Number</th>
                    <td><%= SDeliveryReceipt.get(i).getDeliveryReceiptNumber()%></td>
                    <th>Production Number</th>
                     <td><%= SDeliveryReceipt.get(i).getPoNumber()%></td>
                </tr>
                <tr> 
                    <th>Item Description</th>
                    <th>Received Date</th>
                    <th>Checked by</th>
                    <th>received By</th>
                    <th>Status</th>
                    <th>Quantity</th>
                    <th>Comment</th>
                </tr>
                <%for (int y = 0; y < SDeliveryReceipt.size(); y++) {
                   if (SDeliveryReceipt.get(y).getDeliveryReceiptNumber() == SDeliveryReceipt.get(i).getPoNumber()
                                && SDeliveryReceipt.get(y).getPoNumber() == SDeliveryReceipt.get(i).getPoNumber()){
                %>
                <tr>
                   
                    <td><%= SDeliveryReceipt.get(i).getItemDescription()%></td>
                    <td><%= SDeliveryReceipt.get(i).getReceivedDate()%></td>
                    <td><%= SDeliveryReceipt.get(i).getCheckedBy()%></td>
                    <td><%= SDeliveryReceipt.get(i).getreceivedBy()%></td> 
                    <td><%= SDeliveryReceipt.get(i).getStatus()%></td>
                    <td><%= SDeliveryReceipt.get(i).getQty()%></td>
                    <td><%= SDeliveryReceipt.get(i).getComment()%></td>
                </tr>        
                <%
                                i = y;
                            }
                        }
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
</body>
</html>
