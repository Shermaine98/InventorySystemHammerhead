<%-- 
    Document   : EncodeDeliveryOrder
    Created on : 02 20, 15, 12:12:37 PM
    Author     : Shermaine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Encode Delivery Order</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="css/plugins/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin-2.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/simple-sidebar.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome-4.1.0/css/font-awesome.min.css"
              rel="stylesheet" type="text/css">

        <style>
            td.edits {
                text-align: center;
            }
            th.edits {
                text-align: center;
            }
            
            tr.spaceUnder > td
            {
                padding-bottom: 1em;
            }
        </style>
        <!-- Bootstrap -->
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
    <form method="POST" action="DeliveryOrderServlet">

        <table class="tableContainer" align="center">
            <tr class="spaceUnder">
                <th>Delivery Order #</th>
                <td><input type="text" name="deliveryOrderNumber" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Promo</th>
                <td><input type="text" name="promo" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Outlet</th>
                <td><input type="text" name="outlet" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Production #</th>
                <td><input type="text" name="productionNumber" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Item Description</th>
                <td><input type="text" name="itemDescription" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Sex</th>
                <td><select name="sex">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                    </select></td>
            </tr>
            <tr class="spaceUnder">
                <th>Age Group</th>
                <td><input type="text" name="ageGroup" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Color</th>
                <td><input type="text" name="color" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Size</th> 
                <td><input type="text" name="size" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Quantity</th>
                <td><input type="text" name="qty" size="16"/></td>
            </tr>
            <tr class="spaceUnder">
                <th>Received?</th>
                <td><input type="checkbox" name="received" value="Y"> </td>
            </tr>
            <tr class="spaceUnder">
                <th>Prepared By</th>
                <td><input type="text" name="preparedBy" size="16"/></td>
            </tr>
        </table>
        
        <br/><br/>
        <center>
        <input type="submit" class="btn btn-danger" value="Submit">
        <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </center>
        <br/><br/>
</form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
