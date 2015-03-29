<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

<%@page import="Model.CuttingReport"%>
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
     <br> <br> <br>
        <div class="myrawtable" align= "center">
        <h2>View Cutting Inventory</h2>
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
            <table id="dataTable" class="table table-hover" style= "width:800px ">
                <tr>
                    <th>Production Number</th>
                    <th>Category</th>
                    <th>Delivery Receipt Number</th>
                    <th>Cutting Master</th>
                    <th>Raw Quantity</th>
                    <th>Calculated Quantity</th>
                    <th>Actual Quantity</th>
                    <th>Comment</th>
                </tr>
                <%                    ArrayList<CuttingReport> CuttingReport = (ArrayList<CuttingReport>) session.getAttribute("cutrList");
                    for (int i = 0; i < CuttingReport.size(); i++) {
                %>
                <tr>
                    <td><%= CuttingReport.get(i).getProductionNumber()%></td>
                    <td><%= CuttingReport.get(i).getCategory()%></td>
                    <td><%= CuttingReport.get(i).getDrNumber()%></td>
                    <td><%= CuttingReport.get(i).getCuttingMaster()%></td>
                    <td><%= CuttingReport.get(i).getRawQty()%></td>
                    <td><%= CuttingReport.get(i).getCalculatedQty()%></td>
                    <td><%= CuttingReport.get(i).getActualQty()%></td>
                    <td><%= CuttingReport.get(i).getComment()%></td>

                </tr>        
                <%
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
