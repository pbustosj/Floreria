<%@page import="duoc.cl.dej4501.entidades.Usuario"%>
<%@page import="java.util.LinkedList"%>
<%
  
    if (session.getAttribute("usuarioConectado") != null) {
        response.sendRedirect("Home.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>
