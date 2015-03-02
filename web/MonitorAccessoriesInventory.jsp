<%-- 
    Document   : AccessoriesInventory
    Created on : 02 20, 15, 11:46:23 AM
    Author     : Shermaine
--%>

<%@page import="Dao.DeliveryReceiptDAO"%>
<%@page import="Dao.ConsumptionReportDAO"%>
<%@page import="Dao.PromoDAO"%>
<%@page import="Model.Promo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Monitor Warehouse Inventory</title>
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
    <center><h2>Warehouse Inventory</h2></center>
        <form method="POST" action="AccessoriesInventoryServlet">
            <div align="center">
                <table class="tableContainer" width="80%">
                    <thead class="fixedHeader"><tr>
                        <th></th>
                        <th>Category</th> 
                        <th>Accessory Description</th>            
                        <th>Delivery Receipt Number</th>
                        <th>Quantity</th>
                        <th>Unit Measurement</th> 

                        </tr></thead>
                    <tbody id="dataTable" class="scrollContent"><tr>
                        <td><input type="checkbox" name="chk"/></td>
                        <td><input type="text" name="category" size="10"/></td>
                        <td><input type="text" name="accessoryDescription" size="18"/></td>
                        
                        <td><select name="deliveryReceiptNumber" style="width:90px">
                                <%  DeliveryReceiptDAO DeliveryReceiptDAO = new DeliveryReceiptDAO();
                                    for (int i = 0; i < DeliveryReceiptDAO.GetDeliveryReceiptList().size(); i++) {
                                %>
                                <option value="<%=DeliveryReceiptDAO.GetDeliveryReceiptList().get(i).getDeliveryReceiptNumber()%>">
                                    <%= DeliveryReceiptDAO.GetDeliveryReceiptList().get(i).getDeliveryReceiptNumber()%></option>
                                    <%
                                        }
                                    %>
                            </select>
                        </td> 
                        <td><input type="text" name="qty" size="4"/></td>
                        <td> <select name ="unitMeasurement">
                                    <option value="kg">Kilogram</option>
                                    <option value="meter">meter</option>
                             </select></td>
                        </tr></tbody>
                </table>
                
                <br/><br/>
                <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
                <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
                <br/><br/>
             <input type="submit" class="btn btn-danger" value="OK"/> 
             <a href="updateAccessoriesInventory.jsp"><button type="button" class="btn btn-danger">Update Accessories Inventory</button></a>
                <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
            </div>
        </form>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>

</html>
