<%
    String login = (String) session.getAttribute("login");
    if (login == null || !login.equals("success")){
        response.sendRedirect("index.jsp");
        return;
    }
%>
