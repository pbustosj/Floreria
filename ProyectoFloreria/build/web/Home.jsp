<%@page import="duoc.cl.dej4501.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("usuarioConectado") != null) {

%>
<html>
    <head>
       <jsp:include page="header.jsp" flush="true"></jsp:include>
        <title>Home - Floreria</title>
    </head>
    <body>

        <jsp:include page="menu.jsp" flush="true"></jsp:include>
        <div id="contenido" class="container white">
            <div class="row">
                <div class="col l12 center-align">
                    <h4>Revisa Nuestro Catálogo de Productos:</h4><hr>


                </div>
            </div>
            

        </div>
          <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>

    </body>
</html>

<style>
    body{
        font-family: 'Baloo Tammudu', cursive;
    }
    h5{
        padding: 10px;

    }
</style>
<%} else {
        response.sendRedirect("index.jsp");
    }
%>

