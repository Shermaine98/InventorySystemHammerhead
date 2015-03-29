<%-- 
    Document   : GetInventoryReport
    Created on : 02 20, 15, 3:43:44 PM
    Author     : Shermaine
--%>


<%@page import="Model.PickingForm"%>
<%@page import="Model.InventoryReport"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>View Inventory Report</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
   </head>
    <body>     
        <br> <br> <br>
         <div class="myrawtable" align= "center">
            <h2>Inventory Report</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px">
                <tr>
                    <th class="edits"></th>
            
                        <th>Promotizer</th>
                        <th>Date Made</th>
                        <th>Product ID</th> 
                        <th>Color</th> 
                        <th>Size</th> 
                        <th>Made by</th> 
                        <th>Requested By</th>
                </tr>
                <%
                    ArrayList<PickingForm> PickingForm = (ArrayList<PickingForm>) session.getAttribute("pickingForm");
                    for (int i = 0; i < PickingForm.size(); i++) {
                %>
                <tr>
                    <td><%= PickingForm.get(i).getPromo()%></td>
                    <td><%= PickingForm.get(i).getDateMade()%></td>
                    <td><%= PickingForm.get(i).getColor()%></td>
                    <td><%= PickingForm.get(i).getSize()%></td>
                    <td><%= PickingForm.get(i).getMadeBy() %></td>
                    <td><%= PickingForm.get(i).getRequestedQty() %></td>
                </tr>        
                <%
                                                              }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/Ok</button></a>
            <a href="EncodeInventoryReport.jsp"><button type="button" class="btn btn-danger">Add Inventory Report</button></a>
        </div>
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>