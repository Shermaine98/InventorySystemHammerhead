<%-- 
    Document   : EncodeConsumptionReport
    Created on : 02 20, 15, 12:15:10 PM
    Author     : Shermaine
--%>

<%@page import="Model.DeliveryOrder"%>
<%@page import="Model.PickingForm"%>
<%@page import="Model.PurchaseOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="navigationBar.jsp" />
<%@include file="security.jsp" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Encode Delivery Schedule</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <style>
        </style>

        <script>
            var v="1";
            
            function onChange(data) {
             document.getElementById("display").value = data.value;
             $("#table tbody tr").remove();
                  v= data.value;
            }
            
            function createQuantityName(i) {
                var qty = "quantity"+i;
                return qty;
            }
            function createCommentName(i) {
                var qty = "comment"+i;
                return qty;
            }
            function createStatusName(i) {
                var qty = "Status"+i;
                return qty;
            }
        </script>
    </head>
    <body>  
         <br/><br/><br/>
        <center><h1>Encode Delivery Schedule</h1></center>
   
         <center><h2>Choose Delivery Order</h2></center>
         <br/> 
        <div align="center">
            <select name="selected" onchange="onChange(this)" > 
                <option value="1">choose</option>
                <%  
                     ArrayList<DeliveryOrder> DeliveryOrder = (ArrayList<DeliveryOrder>) session.getAttribute("doList");
                //   ArrayList<User> User = (ArrayList<promo>) session.getAttribute("promo");
                    
                   
                   ArrayList<Integer> dONum = new ArrayList<Integer>();
                  //  ArrayList<String> name = new ArrayList<String>();
                    for (int y = 0; y < DeliveryOrder.size(); y++) {
                        if (!(dONum.contains(DeliveryOrder.get(y).getDoNumber()))) {
                            dONum.add(DeliveryOrder.get(y).getDoNumber());
                          //  name.add(PickingForm.get(y).getCompanyName());
                        }
                    }
                    for (int i=0; i < dONum.size(); i++) {
                %>
               <option value="<%=dONum.get(i)%>"> <%=dONum.get(i)%></option>
                <%
                    }
                
                %>
            </select>
        </div>

     <br/><br/>
    
    <div id= "center" align="center">
        <form method="POST" action="DeliveryOrderServlet">


            <table class="tableContainer" width="50%" id="table">
                <thead class="fixedHeader">
                    <tr>
                        <th>Promo</th>
                        <td><input name="poNumber" type="text" value="<%=DeliveryOrder.get(0).getPromo()%>"/></td>
                    </tr>
                    <tr>
                        <th>Driver</th>
                        <td><input name="driver" type="text" ></td>
                        <td></td>
                        <th>Prepared By</th>
                       <td><input name="poNumber" type="text" /></td>
                    </tr>
                    <tr>
                        <th>Box Quantity</th>
                       <td><input name="poNumber" type="text" /></td>
                    </tr>
  
            </table>

            <br/><br/>
            <input type="submit" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>

        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>