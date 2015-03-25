<%-- 
    Document   : navigationBar
    Created on : 12 10, 14, 9:42:43 PM
     Author     : Atayan, Lapidario, Nunez, Sy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation"
             style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <img src="Images/logo.png" alt="logo"
                     height="50" width="200">
            </div>
            <!-- /.navbar-header -->
            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="dashboard.jsp">Dashboard</a></li>
                    <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">Receiving <span class="caret"></span> </a>
                        <ul class="dropdown-menu" role="menu">
                    <li class="divider"></li>
                            <li><a href="EncodeSupplierPurchaseOrder.jsp">Encode Supplier Purchase Order</a></li>
                            <li><a href="EncodeSupplierDeliveryReceipt.jsp">Encode Supplier Delivery Receipt</a></li>
                    <li class="divider"></li>
                             <li><a href="EncodeSubconPurchaseOrder.jsp">Encode Subcontractor Purchase Order</a></li>
                             <li><a href="EncodeSubconDeliveryReceipt.jsp">Encode Subcontractor Delivery Receipt</a></li> 
                    <li class="divider"></li>
                            <li><a href="/Hammerhead/ViewPurchaseOrderServlet">View Supplier Purchase Order</a></li>  
                            <li><a href="/Hammerhead/ViewSupplierDeliveryReceiptServlet">View Supplier Delivery Receipt</a></li>
                    <li class="divider"></li>
                            <li><a href="">View Subcontractor Purchase Order</a></li>
                            <li><a href="">View Subcontractor Delivery Receipt</a></li>          
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Inventory<span class="caret"></span></a> <ul class="dropdown-menu" role="menu">
                    <li class="divider"></li>
                            <li><a href="/Hammerhead/ViewAccessoriesInventoryServlet">View Accessories Inventory</a></li>
                            <li><a href="MonitorAccessoriesInventory.jsp">Monitor Accessories Inventory</a></li>
                    <li class="divider"></li>
                            <li><a href="/Hammerhead/ViewProductionInventoryServlet">View Production Inventory</a></li>
                            <li><a href="MonitorProductionInventory.jsp">Monitor Production Inventory</a></li>
                    <li class="divider"></li>
                            <li><a href="/Hammerhead/ViewWarehouseInventoryServlet">View Warehouse Inventory</a></li>
                            <li><a href="MonitorWarehouseInventory.jsp">Monitor Warehouse Inventory</a></li>
                        </ul>
                    </li> 
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Delivery <span class="caret"></span></a> <ul class="dropdown-menu" role="menu">
                            <li><a href="EncodeDeliveryOrder.jsp">Encode Delivery Orders</a></li>
                            <li><a href="/Hammerhead/ViewDeliveryOrderServlet">Monitor Delivery Orders</a></li>
                    <li class="divider"></li>
                            <li><a href="EncodeDeliverySchedule.jsp">Encode Delivery Schedule</a></li>
                            <li><a href="/Hammerhead/ViewDeliveryScheduleServlet">Monitor Delivery Schedules</a></li>
                        </ul>
                    </li>

                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Other<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="EncodeInventoryReport.jsp">Encode Inventory Reports</a></li>
                            <li><a href="/Hammerhead/ViewInventoryReportServlet">View Inventory Reports</a></li>
                        <li class="divider"></li>
                            <li><a href="EncodeSupplier.jsp">Encode Supplier</a></li>
                            <li><a href="/Hammerhead/ViewSupplierServlet">View Supplier</a></li>
                        <li class="divider"></li>
                            <li><a href="EncodeSupplier.jsp">Encode Product</a></li>
                            <li><a href="/Hammerhead/ViewSupplierServlet">View Product</a></li>
                        <li class="divider"></li>
                            <li><a href="EncodeCuttingReport.jsp">Encode Cutting Report</a></li>
                            <li><a href="/Hammerhead/ViewCuttingReportServlet">View Cutting Reports</a></li>
   
                        </ul>
                    </li>                 
                    <li>
                </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="https://mail.google.com/"><span class="glyphicon glyphicon-envelope"></span> Mail </a></li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-list-alt"></span> Notification<b class="caret"></b></a>
                            <ul class="dropdown-menu alert-dropdown">
                                <li><a href="#">Alert Name <span class="label label-default">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-success">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-info">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a></li>
                                <li><a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a></li>
                                <li class="divider"></li>
                                <li><a href="#">View All</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Account<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="myaccount.jsp">View Account</a></li>
                                <li><a href="editaccount.jsp">Edit Account</a></li>
                                <li><a href="index.jsp">Log-Out</a></li>
                            </ul>
                        </li>
                    </ul>
            </div>
        </nav>
    </body>
</html>