<%-- 
    Document   : MonitorProductionInventory
    Created on : 02 20, 15, 11:47:33 AM
    Author     : Shermaine
--%>

<%@page import="Dao.CuttingReportDAO"%>
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
        <title>Monitor Production Inventory</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/TABLE.css" rel="stylesheet">
    </head>
    <body>  
    <br/><br/><br/>
    <center><h2>Production Inventory</h2></center>
        <form method="POST" action="ProductionInventoryServlet">
            <div align="center">
                <table class="tableContainer" width="80%">
                    <thead class="fixedHeader"><tr>
                            <th></th>
                        <th>Quantity</th>
                        <th>Unit Measurement</th>     
                        <th>Delivery Receipt Number</th> 
                        <th>Stock Number</th> 
                        <th>Category</th> 
                        </tr></thead>
                    <tbody id="dataTable" class="scrollContent"><tr>
                        <td><input type="checkbox" name="chk"/></td>
                        
                        <td><input type="text" name="qty" size="10"/></td>
                        <td> <select name ="unitMeasurement">
                                    <option value="kg">Kilogram</option>
                                    <option value="meter">meter</option>
                             </select></td>
                        
                        <td><select name="deliveryReceiptNumber" style="width:90px">
                                <%  DeliveryReceiptDAO DeliveryReceiptDAO = new DeliveryReceiptDAO();
                                    for (int i = 0; i < DeliveryReceiptDAO.GetDeliveryReceiptList().size(); i++) {
                                %>
                                <option value="<%=DeliveryReceiptDAO.GetDeliveryReceiptList().get(i).getDeliveryReceiptNumber()%>">
                                    <%= DeliveryReceiptDAO.GetDeliveryReceiptList().get(i).getDeliveryReceiptNumber()%></option>
                                    <%
                                        }
                                    %>
                            </select>
                        </td> 
                        <td><select name="stockNumber" style="width:90px">
                                <%  CuttingReportDAO CuttingReportDAO = new CuttingReportDAO();
                                    for (int i = 0; i < CuttingReportDAO.GetCuttingReportList().size(); i++) {
                                %>
                                <option value="<%=CuttingReportDAO.GetCuttingReportList().get(i).getStockNumber()%>">
                                    <%= CuttingReportDAO.GetCuttingReportList().get(i).getStockNumber()%></option>
                                    <%
                                        }
                                    %>
                            </select>
                        </td> 
                        <td><select name="category">
                                <%  
                                    for (int i = 0; i < CuttingReportDAO.GetCuttingReportList().size(); i++) {
                                %>
                                <option value="<%=CuttingReportDAO.GetCuttingReportList().get(i).getCategory()%>">
                                    <%= CuttingReportDAO.GetCuttingReportList().get(i).getCategory()%></option>
                                    <%
                                        }
                                    %>
                            </select>
                        </td> 
                        </tr></tbody>
                </table>
                
                <br/><br/>
                <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
                <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
                <br/><br/>
             <input type="submit" class="btn btn-danger" value="OK"/> 
             <a href="updateProductionInventory.jsp"><button type="button" class="btn btn-danger">Update Production Inventory</button></a>
                <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
            </div>
        </form>
          <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
        
    </body>

</html>
