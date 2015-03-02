<%-- 
    Document   : dashboard
    Created on : Dec 4, 2014, 7:36:40 PM
    Author     : Atayan, Lapidario, Sy
--%>

<%@page import="Dao.AccessoriesInventoryDAO"%>
<%@page import="Dao.InventoryReportDAO"%>
<%@page import="Dao.ProductionInventoryDAO"%>
<%@page import="Model.ProductionInventory"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Monitor Warehouse Inventory</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">


        <!--Load the AJAX API-->
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">

            google.load('visualization', '1.0', {'packages': ['corechart']});
            google.setOnLoadCallback(drawChart);
            <%
                InventoryReportDAO InventoryReportDAO = new InventoryReportDAO();
                AccessoriesInventoryDAO AccessoriesInventoryDAO = new AccessoriesInventoryDAO();
            %>
            function drawChart() {

                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Outlets');
                data.addColumn('number', 'Quantity');

                data.addRows([
            <%
                for (int i = 0; i < InventoryReportDAO.GetAllInventoryReport().size(); i++) {
            %>
                    [ '<%= InventoryReportDAO.GetAllInventoryReport().get(i).getOutlet()%>',<%= InventoryReportDAO.GetAllInventoryReport().get(i).getRemainingQuantity()%> ],
            <%
                }
            %>
                ]);


                var AccessoryChart = new google.visualization.DataTable();
                AccessoryChart.addColumn('string', 'Outlets');
                AccessoryChart.addColumn('number', 'Quantity');

                AccessoryChart.addRows([
            <%
                for (int i = 0; i < AccessoriesInventoryDAO.MonitorAccessoriesInventory().size(); i++) {
            %>
                    [ '<%= AccessoriesInventoryDAO.MonitorAccessoriesInventory().get(i).getAccessoryDescription()%>',<%= AccessoriesInventoryDAO.MonitorAccessoriesInventory().get(i).getQty()%> ],
            <%
                }
            %>
                ]);
                google.visualization.events.addListener(data, 'ready', function () {
                    ready.data = true;
                    if (ready.data) {
                        PieMain.getChart().setAction({
                            id: 'sample',
                            text: 'Quantity of Items Per Item',
                            action: function () {
                                button.onclick = function () {
                                    current = 0;
                                    drawChart();
                                }
                                selection = data.getChart().getSelection();
                                switch (selection[0].row) {
                                    case 0:
                                        data2.draw();
                                }
                            }
                        });
                    }
                });
                var options = {'title': 'Stocks Available Per Outlets',
                    'width': 400,
                    'height': 300};
                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
                chart.draw(data, options);

                var chart = new google.visualization.ColumnChart(document.getElementById('chart_2'));
                chart.draw(AccessoryChart, options);
            }
        </script>
    </head>

    <body>
    <center>
        <br>
        <br>
        <br>
        <br>
        <h2 align="center">

            <font face="Helvetica">Dashboard</font>
        </h2>
        <table border="10" cellpadding=" 10">
            <br>
            <tr>
                <td colspan="3" align="center">
                    <div id="stackedBarChart"></div>
                </td>
                <td colspan="3" align="center">
                    <div id="chart_div" style="width:400; height:300"></div>

                <td colspan="3" align="center">
                    <div id="chart_2" style="width:400; height:300"></div></td>
            </tr>
         
        </table>
    </center>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
