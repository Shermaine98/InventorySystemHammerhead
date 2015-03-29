<%-- 
    Document   : MonitorDeliveryOrders
    Created on : 02 20, 15, 12:13:28 PM
    Author     : Shermaine
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.DeliveryOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Delivery Order</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    
    <body>
         <br> <br> <br>
         <div class="myrawtable" align= "center">
        <h2>View Delivery Order</h2>
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
        
        <br> 
        <div class="myrawtable" align= "center">
            <h1>Delivery Order</h1>
            <table id="dataTable" class="table table-hover" style= "width:800px">
               
                  <%
                    ArrayList<DeliveryOrder> DeliveryOrder = (ArrayList<DeliveryOrder>) session.getAttribute("doList");
                    for (int i = 0; i < DeliveryOrder.size(); i++) {
                %>
                <tr>
                    <th class = "edits">Delivery Order Number </th> 
                    <td><%= DeliveryOrder.get(i).getPromo()%></td>
                    <th class = "edits">Promo</th>
                      <td><%= DeliveryOrder.get(i).getPromo()%></td>
                    <th class = "edits">Date Made</th>
                    <td><%= DeliveryOrder.get(i).getDateMade()%></td>
                    <th class = "edits" > Prepared By</th>
                    <td><%= DeliveryOrder.get(i).getPreparedBy()%></td>
                    <th class = "edits">Approved by</th>
                    <td><%= DeliveryOrder.get(i).getApprovedBy()%></td>
                </tr>
                 <tr>
                    <th class = "edits">Product</th>
                    <th class = "edits">Size</th>
                    <th class = "edits">Quantity</th>
                     <th class = "edits">Approval</th>
                 </tr>   
              
                <tr>
                   <% 
                    
                    for (int y = 0; y < DeliveryOrder.size(); y++) {
                         if(DeliveryOrder.get(y).getPromo()==DeliveryOrder.get(i).getPromo()
                            && DeliveryOrder.get(y).getDateMade()==DeliveryOrder.get(i).getDateMade()){
                    %>
                    <td><%= DeliveryOrder.get(y).getProductID() %></td>
                    <td><%= DeliveryOrder.get(y).getSize()%></td>
                    <td><%= DeliveryOrder.get(y).getDeliveryQty()%></td>
                    <td><%= DeliveryOrder.get(y).isApproved() %></td>     
                </tr>        
                <%
                    }
                    }
                    }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back</button></a>
            <a href="EncodeDeliveryOrder.jsp"><button type="button" class="btn btn-danger">Add Delivery Order</button></a>
        </div>
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
