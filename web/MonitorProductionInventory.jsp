<%-- 
    Document   : AccessoriesInventory
    Created on : 02 20, 15, 11:46:23 AM
    Author     : Shermaine
--%>

<%@page import="Model.CuttingReport"%>
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
    <center><h1>Reconciling Production Inventory</h1></center>

    <%
        ArrayList<SupplierDeliveryReceipt> SupplierDeliveryReceipt = (ArrayList<SupplierDeliveryReceipt>) session.getAttribute("SdrList");
        ArrayList<PurchaseOrder> PurchaseOrder = (ArrayList<PurchaseOrder>) session.getAttribute("poList");
        ArrayList<CuttingReport> CReport = (ArrayList<CuttingReport>) session.getAttribute("cutrList");
     %>

    <div align="center">
        <h2>Delivery Receipt Number</h2>
        <select name="SupplierDeliveryReceipt" style="width:90px">
            <%
                 ArrayList<Integer> DeliveryN = new ArrayList<Integer>();
                 for (int z = 0; z < CReport.size(); z++) {
                if (!(DeliveryN.contains(CReport.get(z).getDrNumber()))) {
                      DeliveryN.add(CReport.get(z).getDrNumber());
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
    <form method="POST" action="ProductionInventoryServlet">
        <div align="center">
            <table class="tableContainer" width="80%">
                <thead class="fixedHeader">
                    <tr>   
                        <th>Production Number</th> 
                        <th>Delivery Receipt Number</th> 
                    </tr>
                </thead>
               
                <tbody id="dataTable" class="scrollContent"><tr>
                    <td><input type="text" name="productionNumber" size="18" value="<%= CReport.get(0).getProductionNumber()%>"/></td>
                    <td><input type="text" name="deliveryReceiptNumber" size="18" value="<%= CReport.get(0).getDrNumber()%>"/></td>

                    <tr>        
                       <th>Category</th>
                       <th>Quantity</th>
                       <th>Unit Measurement</th>
                       <th>Approval</th>
                       <th>Note</th>
                    </tr>
                    <%
                        for (int y = 0; y < CReport.size(); y++) {
                               
                    %>
                    <tr>
                    <td><input type="text" name="category" size="18" value="<%= CReport.get(y).getCategory()%>"/></td>
                    <td><input name="qty" value="<%= CReport.get(y).getActualQty()%>"/></td>
                        <%
                           
                        %> 
                        <td><input name="unitMeasurement" value="WAHHHH"/></td>
                          <td><input type="checkbox" value="1" name="chk" onClick="document.getElementById('createNoteName(<%=y%>)').disabled = this.checked;" checked/></td>
                        <td><input type="text" name="note" id="createNoteName(<%=y%>)" size="5" disabled/></td>
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
