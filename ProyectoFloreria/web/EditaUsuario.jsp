<%-- 
    Document   : EditaUsuario
    Created on : 19-10-2017, 21:42:46
    Author     : pbustosj
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("usuarioConectado") != null) {

%>
<html>
    <head>
        <jsp:include page="header.jsp" flush="true"></jsp:include>
            <title>Edita Usuario</title>
        </head>
    <jsp:useBean id="listadoPerfil" class="duoc.cl.dej4501.entidades.Perfil" scope="page"></jsp:useBean>
    <jsp:useBean id="userToEdit" class="duoc.cl.dej4501.entidades.Usuario" scope="session"></jsp:useBean>
    <jsp:include page="menu.jsp" flush="true"></jsp:include>

        <body>

            <div class="container">
                <h1>Edición Usuario: <c:out value="${userToEdit.login_usuario}"></c:out></h1>
            <h4>Id: <c:out value="${userToEdit.id_usuario}"></c:out></h4>
                <form class="col s12" method="POST" action="./editUser">
                    <div class="modal-content">
                        <h4>Agregar Usuario</h4>
                        <p>Ingrese todos los campos</p>
                        <div class="row">

                            <div class="row">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="loginUser"  value="<c:out value="${userToEdit.login_usuario}"></c:out>" name="loginUser" type="text" class="validate" required>

                                </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">phone</i>
                                    <input id="passUser" value="<c:out value="${userToEdit.pass_usuario}"></c:out>" name="passUser" type="text" class="validate" required>

                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <select name="perfilUser" id="perfilUser">
                                    <c:forEach items="${listaPerfil}" var="listadoPerfil">    
                                        <c:choose>
                                            <c:when test="${listadoPerfil.id_perfil==userToEdit.id_perfil}">
                                                <option selected value="${listadoPerfil.id_perfil}">${listadoPerfil.tipo_perfil}</option>
                                            </c:when>    
                                           <c:when test="${listadoPerfil.id_perfil!=userToEdit.id_perfil}">
                                               <option value="${listadoPerfil.id_perfil}">${listadoPerfil.tipo_perfil}</option>
                                            </c:when>
                                        </c:choose>
                                        
                                    </c:forEach>


                                </select>
                                <label>Perfil</label>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="modal-footer row">




                    <a  class="modal-action modal-close waves-effect waves-green btn-flat red" href="MantenedorUsuario.jsp">Cancelar</a>
                    <input type="submit" class="modal-action waves-effect waves-green btn-flat green" value="Agregar">

                </div>
            </form>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.tooltipped').tooltip({delay: 50});
                $('.modal').modal();
                $('select').material_select();
            });
        </script>

    </body>

</html>
<%} else {
        response.sendRedirect("index.jsp");
    }
%>