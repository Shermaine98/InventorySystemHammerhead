<%-- 
    Document   : GetProductionInventory
    Created on : 02 20, 15, 11:49:30 AM
    Author     : Shermaine
--%>


<%@page import="Model.ConsumptionReport"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>View Consumption Report </title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
   </head>
    <body>     
        <br> <br> <br>
         <div class="myrawtable" align= "center">
            <h2>Consumption Report</h2>
            <table id="dataTable" class="table table-hover" style= "width:800px ">
                <tr>
                    <th class="edits"></th>
     
                    <th>Production Number</th>
                    <th>Product ID</th>
                    <th>Size</th>
                    <th>Color</th>
                    <th>Quantity</th>
                     <th>Prepared By </th>
                    <th>Approved By</th>
                    <th>Date Made</th>  
                </tr>
                <%
                    ArrayList<ConsumptionReport> ConsumptionReport = (ArrayList<ConsumptionReport>) session.getAttribute("crlist");
                    for (int i = 0; i < ConsumptionReport.size(); i++) {
                %>
                <tr>
                    <td><input type="checkbox" name="chk"/></td> 
                    <td><%= ConsumptionReport.get(i).getProductionNumber() %></td>
                    <td><%=ConsumptionReport.get(i).getProductID()%></td>
                    <td><%=ConsumptionReport.get(i).getSize()%></td>
                    <td><%=ConsumptionReport.get(i).getColor()%></td>
                    <td><%= ConsumptionReport.get(i).getProdQty()%></td>
                    <td><%= ConsumptionReport.get(i).getPreparedBy()%></td>
                    <td><%= ConsumptionReport.get(i).getApprovedBy()%></td>
                    <td><%= ConsumptionReport.get(i).getdateMade()%></td>  
                </tr>        
                <%
                   
                    }
                %>
            </table>
            <br/><br/>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Back/Ok</button></a>
            
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <
    </body>
</html>