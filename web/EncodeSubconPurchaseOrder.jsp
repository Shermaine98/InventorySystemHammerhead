<%-- 
    Document   : EncodePurchaseOrder
    Created on : 02 20, 15, 11:39:41 AM
    Author     : Shermaine
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.RefSupplier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<%@include file="security.jsp" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Encoding Purchase Order</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/TABLE.css" rel="stylesheet">

        <script>
            function addRow(tableID) {
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);
                var colCount = table.rows[0].cells.length;
                for (var i = 0; i < colCount; i++) {
                    var newcell = row.insertCell(i);
                    newcell.innerHTML = table.rows[0].cells[i].innerHTML;
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
         <center><h1>Encoding Purchase Order</h1></center>
        <%          ArrayList<RefSupplier> RefSupplier = (ArrayList<RefSupplier>) session.getAttribute("SList");
        %>
        <div align="center">
            <h2>Choose Supplier</h2>
            <select name="Supplier" style="width:300px">
                <%
                    ArrayList<Integer> SupplierNumber = new ArrayList<Integer>();
                    ArrayList<String> name = new ArrayList<String>();
                    for (int y = 0; y < RefSupplier.size(); y++) {
                        if (!(SupplierNumber.contains(RefSupplier.get(y).getSupplierID()))) {
                            SupplierNumber.add(RefSupplier.get(y).getSupplierID());
                            name.add(RefSupplier.get(y).getCompanyName());
                        }
                    }
                    for (int i = 0; i < SupplierNumber.size(); i++) {
                %>
                <option value="<%=SupplierNumber.get(i)%>"> <%=SupplierNumber.get(i) + " - " + name.get(i)%></option>
                <%
                    }

                %>
            </select>
        </div>
         <br><br>
    <form method="POST" action="PurchaseOrderServlet">
        <div align="center">
            <table class="tableContainer" width="80%">
                <thead class="fixedHeader"><tr> 
                        <th>Supplier</th>
                        <td><input name="Supplier"  value="<%=RefSupplier.get(1).getSupplierID()%>"/></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <th>Delivery Schedule </th>
                        <td><input type="text" name="DeliverySchedule" size="10"/></td>
                    </tr>
                
                    <tr>

                        <th>Check Box</th>
                        <th>Item Description</th>
                        <th>Type</th>
                        <th>Unit Measurement</th> 
                        <th>Unit Price</th> 
                        <th>Vat</th> 
                         <th>Quantity</th>
                    </tr></thead>
                <tbody id="dataTable" class="scrollContent"><tr>
                        <td><input type="checkbox" name="chk"/></td>
                        <!--if that, selected itemDescription, itemDescription  -- for the next row -->
                        <td>  
                            <select name="itemDescription" style="width:90px">
                                <% for (int i = 0; i < RefSupplier.size(); i++) {
                                        if (RefSupplier.get(i).getSupplierID() == 1)
                                %>
                                <option value="<%=RefSupplier.get(i).getItemDescription()%>"> <%=
                                         RefSupplier.get(i).getItemDescription()%></option>
                                    <%
                                                                         }
                                    %>
                            </select> 
                        </td> 

                        <td>
                            <select name="Type">  
                                <option value="Accessories">Accessories</option>
                                <option value="Fabric">Fabric</option>
                            </select>
                        </td>  

                        
                        <td> <select name ="unitMeasurement">
                                <option value="Kg">Kilogram</option>
                                <option value="Yd">Yard</option>
                                <option value="centimeter">Centimeter</option>
                                <option value="box">box</option>
                                <option value="pcs">Pcs</option>
                            </select></td>
                        <td><input type="text" name="UnitPrice" size="10"/></td>
                        <td><input type="text" name="vat" size="10"/></td> 
                        <td><input type="text" name="qty" size="10"/></td>
                </tbody>
                 <tr>
                        <th>Prepared By</th> 
                        <td><input type="text" name="preparedBy" size="10"/></td>
                        <th>Approved By</th> 
                        <td><input type="text" name="approvedBy" size="10"/></td>
                    </tr>
            </table>
            <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
            <br/><br/>
            <input type="submit" class="btn btn-danger" value="OK"/> 
            <a href="EncodePurchaseOrder.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>      
</body>
</html>