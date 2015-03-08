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

        </script>
    </head>
    <body>  
    <br/><br/><br/>
    <center><h2>Add Item</h2></center>
        <form method="POST" action="ConsumptionReportServlet">
            <div align="center">
                <table class="tableContainer" width="70%">
                    <thead class="fixedHeader">
                        <tr>
                        <th> Product ID </th>
                        <th>Color </th>
                        <th>Size</th>
                        <th>Production Quantity</th>
                        <th>Prepared By</th>
                        <th>Approved By</th> 
                       
                        </tr>
                    </thead>
                    <tbody id="dataTable" class="scrollContent">
                        <tr>
                            <td><input type="text" name="productID" size="10"/></td>
                            <td><input type="text" name="color" size="10"/></td>
                            <td> <select name ="size">
                                <option value="29">29</option>
                                <option value="30">30</option>
                                <option value="29">31</option>
                                <option value="30">32</option>
                                <option value="29">33</option>
                                <option value="30">34</option>
                                <option value="29">36</option>
                                <option value="30">38</option>
                                <option value="L">L</option>
                                <option value="M">M</option>
                                <option value="S">S</option>
                                <option value="M">XXXL</option>
                                <option value="M">XL</option>
                                <option value="S">XS</option>
                            </select></td>
                           
                            <td><input type="text" name="productionQty" size="16"/></td>                    
                            <td><input type="text" name="preparedBy" size="16"/></td>                   
                            <td><input type="text" name="approvedBy" size="16"/></td>
                          
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
    </body>
</html>
