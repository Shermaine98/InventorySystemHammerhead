<%-- 
    Document   : EncodeCRTAI
    Created on : 02 20, 15, 12:16:15 PM
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
        <title>Encode CR to AI</title>
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

        </script>
    </head>
    <body>  
    <br/><br/><br/>
    <center><h2>Encode CR to AI</h2></center>
        <form method="POST" action="ConsumptionReportToAccessoryInventory">
            <div align="center">
                <table class="tableContainer" style="width:500px">
                    <thead class="fixedHeader">
                        <tr>
                        <th>Production Number</th>
                        <th>Category</th>
                        <th>Accessory Description</th>
                        <th>Consumption</th>
                        <th>Unit</th>
                        </tr>
                    </thead>
                    <tbody id="dataTable" class="scrollContent">
                        <tr>
                            <td><input type="text" name="productionNumber" size="10"/></td>
                            <td><input type="text" name="category" size="16"/></td>                    
                            <td><input type="text" name="accessoryDescription" size="16"/></td>                   
                            <td><input type="text" name="consumption" size="16"/></td>                   
                            <td><input type="text" name="unit" size="16"/></td>
                        </tr>
                    </tbody>
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
