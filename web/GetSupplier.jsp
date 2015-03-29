<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

<%@page import="java.lang.Integer"%>
<%@page import="Model.RefSupplier"%>
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
        <h2>View Supplier</h2>
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

                <tr>
                   
                    <th>Supplier ID</th>
                    <th>Company Name</th>
                    <th>Company Address</th>
                    <th>Contact Person</th>
                    <th>Contact Number</th>
                </tr>

                <%                   
                    ArrayList<RefSupplier> RefSupplier = (ArrayList<RefSupplier>) session.getAttribute("SList");
                    ArrayList<Integer> refSupplierID = new ArrayList<Integer>();
                    for (int i = 0; i < RefSupplier.size(); i++) {
                        if(!(refSupplierID.contains(RefSupplier.get(i).getSupplierID())))
                            refSupplierID.add(RefSupplier.get(i).getSupplierID());
                    }
                    for(int i=0; i<refSupplierID.size(); i++){
                %>
                <tr>
                    <td><%= RefSupplier.get(i).getSupplierID()%></td>
                    <td><%= RefSupplier.get(i).getCompanyName()%></td>
                      <td><%= RefSupplier.get(i).getCompanyAddress()%></td>
                    <td><%= RefSupplier.get(i).getContactPerson()%></td>
                    <td><%= RefSupplier.get(i).getContactNumber()%></td> 
                </tr>   
                <tr>
                    <th>Item Description</th>
                </tr>
                    <% 
                    
                    for (int y = 0; y < RefSupplier.size(); y++) {
                         if(RefSupplier.get(y).getSupplierID()==RefSupplier.get(i).getSupplierID())
                    %>
                <tr>
                    <td><%= RefSupplier.get(y).getItemDescription()%></td>
                </tr>
                    <%
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
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
