<%-- 
    Document   : AccessoriesInventory
    Created on : 02 20, 15, 11:46:23 AM
    Author     : Shermaine
--%>

<%@page import="Model.PurchaseOrder"%>
<%@page import="Model.SupplierDeliveryReceipt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.SupplierDeliveryReceiptDAO"%>
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

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/TABLE.css" rel="stylesheet">
        <style>
        </style>
        <script>
            function createNoteName(i) {
                var qty = "note" + i;
                return qty;
            }
        </script>
    </head>
    <body>  
        <br/><br/><br/>
    <center><h1>Reconciling Accessories Inventory</h1></center>

    <%
        ArrayList<SupplierDeliveryReceipt> SupplierDeliveryReceipt = (ArrayList<SupplierDeliveryReceipt>) session.getAttribute("SdrList");
        ArrayList<PurchaseOrder> PurchaseOrder = (ArrayList<PurchaseOrder>) session.getAttribute("poList");
    %>

    <div align="center">
        <h3>Delivery Receipt Number</h3>
        <select name="SupplierDeliveryReceipt" style="width:90px">
            <%
                ArrayList<Integer> DeliveryN = new ArrayList<Integer>();
                 for (int z = 0; z < SupplierDeliveryReceipt.size(); z++) {
                if (!(DeliveryN.contains(SupplierDeliveryReceipt.get(z).getDeliveryReceiptNumber()))) {
                    DeliveryN.add(SupplierDeliveryReceipt.get(z).getDeliveryReceiptNumber());
              }
             }
              
                for (int i = 0; i < DeliveryN.size(); i++) {
            %>

            <option value="<%=DeliveryN.get(i)%>"> <%=DeliveryN.get(i)%></option>
            <%

                }

            %>
        </select>
    </div>
    <form method="POST" action="AccessoriesInventoryServlet">
        <div align="center">
            <table class="tableContainer" width="80%">
                <thead class="fixedHeader"><tr>   
                        <th>Delivery Receipt Number</th> 
                    </tr></thead>
                <tbody id="dataTable" class="scrollContent"><tr>
                        <td><input type="text" name="deliveryReceiptNumber" size="18" value="<%= SupplierDeliveryReceipt.get(1).getDeliveryReceiptNumber()%>"/></td>
                    <tr>  
                        <th>Category</th>
                        <th>Accessory Description</th>
                        <th>Quantity</th>
                        <th>Unit Measurement</th>
                        <th>Approval</th>
                        <th>Note</th>
                    </tr>
                    <%
                        for (int y = 0; y < SupplierDeliveryReceipt.size(); y++) {
                       //  if (SupplierDeliveryReceipt.get(y).getStatus().equalsIgnoreCase("complete")) {
                    %>

                    <tr>
                       <td><input type="text" name="category" size="18" value="WEIRDDDD...."/></td>
                        <td><input name="accessoryDescription" value="<%= SupplierDeliveryReceipt.get(y).getItemDescription()%>"/></td>
                        <td><input name="qty" value="<%= SupplierDeliveryReceipt.get(y).getQty()%>"/></td>

                        <%
                            for (int i = 0; i < PurchaseOrder.size(); i++) {
                                if ((SupplierDeliveryReceipt.get(y).getPoNumber() == PurchaseOrder.get(i).getPoNumber())
                                        && (SupplierDeliveryReceipt.get(y).getItemDescription().equalsIgnoreCase(PurchaseOrder.get(i).getItemDescription()))) {
                        %> 
                        <td><input name="unitMeasurement" value=" <%= PurchaseOrder.get(i).getUnitMeasurement()%>"/></td>
                        <%

                                }
                            }
                        %>

                        <td><input type="checkbox" value="1" name="approval" onClick="document.getElementById('createNoteName(<%=1%>)').disabled = this.checked;" checked/></td>
                        <td><input type="text" name="note" id="createNoteName(<%=1%>)" size="5" disabled/></td>
                       
                            <%
                                }
                            %>
                    </tr></tbody>
            </table>


            <br/><br/>
            <input type="submit" class="btn btn-danger" value="OK"/> 
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
