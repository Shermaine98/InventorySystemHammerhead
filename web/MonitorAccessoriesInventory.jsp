<%-- 
    Document   : AccessoriesInventory
    Created on : 02 20, 15, 11:46:23 AM
    Author     : Shermaine
--%>

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
    <center><h2>Updating Accessories Inventory</h2></center>

    <%
        ArrayList<SupplierDeliveryReceipt> SupplierDeliveryReceipt = (ArrayList<SupplierDeliveryReceipt>) session.getAttribute("SdrList");
    %>

    <div align="center">
        <h1>Delivery Receipt Number</h1>
        <select name="SupplierDeliveryReceipt" style="width:90px">
            <%
                //ArrayList<Integer> SupplierNumber = new ArrayList<Integer>();
                //ArrayList<String> name = new ArrayList<String>();
                // for (int y = 0; y < SupplierDeliveryReceipt.size(); y++) {
                //if (!(SupplierNumber.contains(RefSupplier.get(y).getSupplierID()))) {
                //         SupplierNumber.add(RefSupplier.get(y).getSupplierID());
                //       name.add(RefSupplier.get(y).getCompanyName());
                // }
                // }
                for (int i = 0; i < SupplierDeliveryReceipt.size(); i++) {

            %>

            <option value="<%=SupplierDeliveryReceipt.get(1)%>"> <%=SupplierDeliveryReceipt.get(1).getDeliveryReceiptNumber()%></option>
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
                        <th>Category</th> 
                        <th>Unit Measurement</th>

                        <!-- Temporary -->

                        <!-- Temporary -->
                    </tr></thead>
                <tbody id="dataTable" class="scrollContent"><tr>


                        <td><input type="text" name="deliveryReceiptNumber" size="18" value="<%= SupplierDeliveryReceipt.get(1).getDeliveryReceiptNumber()%>"/></td>

                        <td><select name="category">  
                                <option value="Tshirt">T-shirt</option>
                                <option value="Pants">Pants</option>
                            </select>
                        </td>

                        <td> <select name ="unitMeasurement">
                                <option value="kg">Kilogram</option>
                                <option value="meter">meter</option>
                            </select></td>
                            
                            <tr>        
                            <th>Accessory Description</th>
                        <th>Quantity</th>
                         <th>Check Box</th>
                        <th>Approval</th>
                        <th>Note</th>
                        </tr>

                        <%
                            for (int y = 0; y < SupplierDeliveryReceipt.size(); y++) {
                                //if (SupplierDeliveryReceipt.get(y).get() == SupplierDeliveryReceipt.get(i).getPoNumber()) {
                        %>

                    <tr>

                        <td><input name="accessoryDescription" value="<%= SupplierDeliveryReceipt.get(1).getItemDescription()%>"/></td>
                        <td><input name="qty" value="<%= SupplierDeliveryReceipt.get(1).getQty()%>"/></td>



                        <td><input type="checkbox" name="chk" onClick="document.getElementById('createNoteName(<%=1%>)').disabled = this.checked;" checked/></td>
                        
                        <td><input type="text" name="note" id="createNoteName(<%=1%>)" size="5" disabled/></td>
                        <td><input type="text" name="approval"  size="5" /></td>
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
