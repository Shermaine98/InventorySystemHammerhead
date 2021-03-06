<%-- 
    Document   : AccessoriesInventory
    Created on : 02 20, 15, 11:46:23 AM
    Author     : Shermaine
--%>

<%@page import="Model.SubconDeliveryReceipt"%>
<%@page import="Model.SubconPurchaseOrder"%>
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
    <center><h1>Reconciling Warehouse Inventory</h1></center>

    <%
      ArrayList<SubconDeliveryReceipt> SubconDeliveryReceipt = (ArrayList<SubconDeliveryReceipt>) session.getAttribute("subconDeliveryReceipt");
    %>

    <div align="center">
        <h3>Delivery Receipt Number</h3>
        <select name="SupplierDeliveryReceipt" style="width:90px">
            <%
                ArrayList<Integer> SDeliveryN = new ArrayList<Integer>();
                 for (int z = 0; z < SubconDeliveryReceipt.size(); z++) {
                if (!(SDeliveryN.contains(SubconDeliveryReceipt.get(z).getDrNumber()))) {
                    SDeliveryN.add(SubconDeliveryReceipt.get(z).getDrNumber());
              }
             }
              
                for (int i = 0; i < SDeliveryN.size(); i++) {
            %>

            <option value="<%=SDeliveryN.get(i)%>"> <%=SDeliveryN.get(i)%></option>
            <%

                }

            %>
        </select>
    </div>
    <form method="POST" action="WarehouseInventoryServlet">
        <div align="center">
            <table class="tableContainer" width="80%">
                <thead class="fixedHeader"><tr>   
                        <th>Subcontractor Delivery Receipt Number</th> 
                        <td><p><input  name="deliveryReceiptNumber" size="18" value="<%= SubconDeliveryReceipt.get(0).getDrNumber()%>"/></td>
                         <th>Production Number</th> 
                         <td><input type="text" name="deliveryReceiptNumber" size="18" value="<%= SubconDeliveryReceipt.get(0).getProductionNumber() %>"/></td>
                    </tr></thead>
                <tbody id="dataTable" class="scrollContent"><tr>
                       
                    <tr>  
                        <th>Product ID</th>
                        <th>Size</th>
                        <th>Color</th>
                        <th>Quantity</th>
                        <th>Approval</th>
                        <th>Note</th>
                    </tr>
                    <%
                        for (int y = 0; y < SubconDeliveryReceipt.size(); y++) {
                       //  if (SupplierDeliveryReceipt.get(y).getStatus().equalsIgnoreCase("complete")) {
                    %>

                    <tr>
                        <td><input name="accessoryDescription" value="<%= SubconDeliveryReceipt.get(y).getProductID()%>"/></td>
                        <td><input name="qty" value="<%= SubconDeliveryReceipt.get(y).getSize()%>"/></td>
                        <td><input name="accessoryDescription" value="<%= SubconDeliveryReceipt.get(y).getColor()%>"/></td>
                        <td><input name="qty" value="<%= SubconDeliveryReceipt.get(y).getQty()%>"/></td>
                        <td><input type="checkbox" name="approval" onClick="document.getElementById('createNoteName(<%=1%>)').disabled = this.checked;" checked/></td>
                        <td><input type="text" name="note" id="createNoteName(<%=1%>)" size="5" disabled/></td>
                       
                            <%
                                }
                            %>
                    </tr></tbody>
            </table>
            <br/><br/>
            <input type="submit" class="btn btn-danger" value="OK"/> 
            <a href="updateAccessoriesInventory.jsp"><button type="button" class="btn btn-danger">Update Accessories Inventory</button></a>
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
