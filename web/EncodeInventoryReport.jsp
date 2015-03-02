<%-- 
    Document   : EncodeInventoryReport
    Created on : 02 20, 15, 11:42:38 AM
    Author     : Shermaine
--%>

<%@page import="Dao.ProductDAO"%>
<%@page import="Dao.ConsumptionReportDAO"%>
<%@page import="Dao.PromoDAO"%>
<%@page import="Model.Promo"%>
<%@include file="security.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Encoding Inventory Report</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/TABLE.css" rel="stylesheet">
        <style>
            td.edits {
                text-align: center;
            }

            th.edits {
                text-align: center;
            }
        </style>

        <script>
            function addRow(tableID) {

                var table = document.getElementById(tableID);

                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);

                var colCount = table.rows[0].cells.length;

                for (var i = 0; i < colCount; i++) {

                    var newcell = row.insertCell(i);

                    newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                    //alert(newcell.childNodes);
                    switch (newcell.childNodes[0].type) {
                        case "text":
                            newcell.childNodes[0].value = "";
                            break;
                        case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                        case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                    }
                }
            }

            function deleteRow(tableID) {
                try {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;

                    for (var i = 0; i < rowCount; i++) {
                        var row = table.rows[i];
                        var chkbox = row.cells[0].childNodes[0];
                        if (null != chkbox && true == chkbox.checked) {
                            if (rowCount <= 1) {
                                alert("Cannot delete all the rows.");
                                break;
                            }
                            table.deleteRow(i);
                            rowCount--;
                            i--;
                        }


                    }
                } catch (e) {
                    alert(e);
                }
            }

        </script>
    </head>
    <body>  
    <br/><br/><br/>
    <center><h2>Encoding Inventory Report</h2></center>
        <form method="POST" action="InventoryReportServlet">
            <div align="center">
                <table class="tableContainer">
                    <thead class="fixedHeader" width="100%"><tr>
                            <th></th>
                        <th>Promo</th>
                        <th>Outlet</th>
                        <th>Production Number</th>
                        <th>Sex</th> 
                        <th>Item Description</th> 
                        <th>Age Group</th> 
                        <th>Color</th> 
                        <th>Size</th> 
                        <th>Remaining Quantity</th> 
                        <th>Sold Quantity</th> 
                        <th>Pulled Out Quantity</th> 
                        </tr></thead>
                    <tbody id="dataTable" class="scrollContent"><tr>
                        <td><input type="checkbox" name="chk"/></td>
                        <td><select name="promo" >
                                    <%  PromoDAO PromoDAO = new PromoDAO();
                                        for (int i = 0; i < PromoDAO.GetAllPromo().size(); i++) {
                                    %>
                                    <option value="<%=PromoDAO.GetAllPromo().get(i).getEmployeeNumber() %>">
                                                <%= PromoDAO.GetAllPromo().get(i).getEmployeeNumber()%></option>
                                    <%
                                    }
                                    %>
                            </select>
                        </td>
                         <td><select name="outlet" >
                                    <%   
                                        for (int i = 0; i < PromoDAO.GetAllPromo().size(); i++) {
                                    %>
                                    <option value="<%=PromoDAO.GetAllPromo().get(i).getOutlet() %>">
                                                <%= PromoDAO.GetAllPromo().get(i).getOutlet() %></option>
                                    <%
                                    }
                                    %>
                            </select>
                        </td>
                         <td><select name="productionNumber" >
                                <%  ProductDAO Product = new ProductDAO();
                                    for (int i = 0; i < Product.GetAllProductList().size(); i++) {
                                %>
                                <option value="<%=Product.GetAllProductList().get(i).getProductionNumber()%>">
                                    <%= Product.GetAllProductList().get(i).getProductionNumber()%></option>
                                    <%
                                        }
                                    %>
                            </select>
                        </td>  
                            
                           <td> <select name ="sex">
                                <%
                                    for (int i = 0; i < Product.GetAllProductList().size(); i++) {
                                %>
                                <option value="<%=Product.GetAllProductList().get(i).getSex()%>">
                                    <%= Product.GetAllProductList().get(i).getSex()%></option>
                                    <%
                                        }
                                    %>
                            </select></td>
                        <td> <select name ="itemDescription">
                                <%
                                    for (int i = 0; i < Product.GetAllProductList().size(); i++) {
                                %>
                                <option value="<%=Product.GetAllProductList().get(i).getItemDescription()%>">
                                    <%= Product.GetAllProductList().get(i).getItemDescription()%></option>
                                    <%
                                        }
                                    %>
                            </select></td>
                        <td> <select name ="ageGroup">
                                <%
                                    for (int i = 0; i < Product.GetAllProductList().size(); i++) {
                                %>
                                < <option value="<%=Product.GetAllProductList().get(i).getAgeGroup()%>">
                                    <%= Product.GetAllProductList().get(i).getAgeGroup()%></option>
                                    <%
                                        }
                                    %>
                            </select></td> 
                        <td> <select name ="color">
                                <%
                                    for (int i = 0; i < Product.GetAllProductList().size(); i++) {
                                %>
                                < <option value="<%=Product.GetAllProductList().get(i).getColor()%>">
                                    <%= Product.GetAllProductList().get(i).getColor()%></option>
                                    <%
                                        }
                                    %>
                            </select></td> 
                        <td> <select name ="size">
                                <%
                                    for (int i = 0; i < Product.GetAllProductList().size(); i++) {
                                %>
                                < <option value="<%=Product.GetAllProductList().get(i).getSize()%>">
                                    <%= Product.GetAllProductList().get(i).getSize()%></option>
                                    <%
                                        }
                                    %>
                            </select></td> 
                        <td><input type="text" name="remainingQty" size="10"/></td>
                        <td><input type="text" name="soldQty" size="10"/></td>
                        <td><input type="text" name="pulledOutQty" size="10"/></td>
                        
                        </tr></tbody>
                </table>
                
                <br/><br/>
                <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
                <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
                <br/><br/>
             <input type="submit" class="btn btn-danger" value="OK"/> 
                <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
            </div>
        </form>
       <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
        
    </body>

</html>
