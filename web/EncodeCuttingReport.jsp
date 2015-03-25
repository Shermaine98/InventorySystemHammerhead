<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

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
             function createActualQuantity(i) {
                var qty = "quantity"+i;
                return qty;
            }
            function createCommentName(i) {
                var qty = "comment"+i;
                return qty;
            }

        </script>
    </head>
    <body>  
    <br/><br/><br/>
    <center><h2>Encode Cutting</h2></center>
        <form method="POST" action="CuttingReportServlet">
            <div align="center">
                <table class="tableContainer" style="width:500px">
                    <thead class="fixedHeader">
                        <tr>
                        <th>Category</th>
                        <th>Delivery Receipt Number</th>
                        <th>Cutting Master</th>
                        <th>Raw Quantity</th>
                        <th>Calculated Quantity</th>
                        <th>Check Box</th>
                        <th>Actual Quantity</th>
                        <th>Comment</th>
                        </tr>
                    </thead>
                    <tbody id="dataTable" class="scrollContent">
                        <tr>
                           <td>
                           <select name="category" style="width:90px">                             
                                <option value="Shirt"> Shirt </option>
                                <option value="Pants"> Pants </option>                     
                           </select> 
                            </td>                    
                            <td><input type="text" name="drNumber" size="16" value="AUTO"/></td>                   
                            <td><input type="text" name="cuttingMaster" size="16"/></td>                    
                            <td><input type="text" name="rawQty" size="16"/></td>                   
                            <td><input type="text" name="CalculatedQty"  value="AUTO" size="16"/></td>
                             <td><input type="checkbox" name="chk" onClick="document.getElementById('createCommentName(<%=1%>)').disabled = this.checked;
                                document.getElementById('createActualQuantity(<%=1%>)').disabled = this.checked;" checked/></td>
                        <td><input type="text" name="actualQty" id="createActualQuantity(<%=1%>)" size="5" disabled/></td>
                        <td><input type="text" name="Comment" id="createCommentName(<%=1%>)" size="5" disabled/></td>
                        </tr>
                    </tbody>
                </table>
                  <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
           
                <br/><br/>
                <input type="submit" class="btn btn-danger" value="Submit">
                <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
            </div>
        </form>
    

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
