<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

<%@page import="Model.SubconDeliveryReceipt"%>
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
        <title>View Subcontractor Delivery Receipt</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>  
        <br/><br/><br/>
        <div class="myrawtable" align= "center">
        <h2>View Subcontractor Delivery Receipt</h2>
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
        <div align="center">
            <table id="dataTable" class="table table-hover" style= "width:800px">


                <%                   
               ArrayList<SubconDeliveryReceipt> SubconDeliveryReceipt = (ArrayList<SubconDeliveryReceipt>) session.getAttribute("subconDeliveryReceipt");
                    for (int i = 0; i < SubconDeliveryReceipt.size(); i++) {
                %>
                <tr>
                    <th>Delivery Receipt Number</th>
                    <td><%= SubconDeliveryReceipt.get(i).getDrNumber()%></td>
                    <th>Production Number</th>
                     <td><%= SubconDeliveryReceipt.get(i).getProductionNumber()%></td>
                     <th>Purchase Order Number</th>
                     <td><%= SubconDeliveryReceipt.get(i).getPoNumber()%></td>
                     <th>Date Received</th>
                     <td><%= SubconDeliveryReceipt.get(i).getDateRecieved()%></td>
                </tr>
                <tr>
                    <th>Checked By</th>
                    <td><%= SubconDeliveryReceipt.get(i).getCheckedBy()%></td>
                    <th>Received By</th>
                     <td><%= SubconDeliveryReceipt.get(i).getReceivedBy()%></td>
                </tr>
                <tr> 
                    <th>Product ID</th>
                    <th>Size</th>
                    <th>Color</th>
                    <th>Status</th>
                    <th>Quantity</th>
                    <th>Comment</th>
                </tr>
                <%for (int y = 0; y < SubconDeliveryReceipt.size(); y++) {
                   if (SubconDeliveryReceipt.get(y).getDrNumber()== SubconDeliveryReceipt.get(i).getPoNumber()
                        && SubconDeliveryReceipt.get(y).getPoNumber() == SubconDeliveryReceipt.get(i).getPoNumber()){
                %>
                <tr>
                   
                    <td><%= SubconDeliveryReceipt.get(i).getProductID()%></td>
                    <td><%= SubconDeliveryReceipt.get(i).getSize()%></td>
                    <td><%= SubconDeliveryReceipt.get(i).getColor()%></td>
                    <td><%= SubconDeliveryReceipt.get(i).getStatus()%></td>
                    <td><%= SubconDeliveryReceipt.get(i).getQty()%></td>
                    <td><%= SubconDeliveryReceipt.get(i).getComment()%></td>
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
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
