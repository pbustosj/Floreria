<%-- 
    Document   : MantenedorUsuarios
    Created on : 13-10-2017, 21:09:00
    Author     : pbustosj
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("usuarioConectado") != null) {

%>

<html>
    <head>

        <!-- Compiled and minified JavaScript -->
        <jsp:include page="header.jsp" flush="true"></jsp:include>

            <title>Mantenedor Usuarios</title>

        </head>
        <body>




        <jsp:useBean id="listadoPerfil" class="duoc.cl.dej4501.entidades.Perfil" scope="page"></jsp:useBean>
        <jsp:include page="menu.jsp" flush="true"></jsp:include>
        <jsp:include page="./listadoPerfil" flush="true"></jsp:include>
            <div class="container">
                <h3>Mantenedor Usuarios</h3>
                <h4>Listado de Usuarios</h4>
                <a class="btn btn-large green btn-floating right waves-effect waves-light  modal-trigger"  href="#modal1" ><i class="material-icons">add</i></a>
            <jsp:include page="./getallUsuario" flush="true"/>
            <jsp:useBean id="usuario" class="duoc.cl.dej4501.dto.UsuarioPerfilDTO" scope="page"></jsp:useBean>
                <table class="bordered striped highlight centered responsive-table myTable">
                    <thead class="">
                        <tr>
                            <th>Id</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Perfil</th>
                            <th>Editar</th>
                            <th>Eliminar</th>


                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.listadoUsuario}" var="usuario">
                        <tr>
                            <td><c:out value="${usuario.id_usuario}"></c:out></td>
                            <td><c:out value="${usuario.login_usuario}"></c:out></td>
                            <td><c:out value="${usuario.pass_usuario}"></c:out></td>
                            <td><c:out value="${usuario.tipo_perfil}"></c:out></td>

                                <td><a href="./datosUsuario?id=${usuario.id_usuario}" class="waves-effect waves-light  modal-trigger"><i class="material-icons orange-text">edit</i></a></td>
                            <td><a href="./eliminaUsuario?id=${usuario.id_usuario}" class="waves-effect waves-light"><i class="material-icons red-text">delete</i></a></td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${msg!=null}">
                <script>
                    $(document).ready(function () {
                        Materialize.toast('<c:out value="${msg}"></c:out>', 3000, 'red rounded')
                    });
                    </script>

                <c:remove scope="session" var="msg"></c:remove>
            </c:if>


        </div>

        <div id="modal1" class="modal modal-fixed-footer">
            <form class="col s12" method="POST" action="./addUser">
                <div class="modal-content">
                    <h4>Agregar Usuario</h4>
                    <p>Ingrese todos los campos</p>
                    <div class="row">

                        <div class="row">
                            <div class="input-field col s6">
                                <i class="material-icons prefix">account_circle</i>
                                <input id="loginUser" name="loginUser" type="text" class="validate" required>
                                <label for="loginUser">Nombre de Usuario</label>
                            </div>
                            <div class="input-field col s6">
                                <i class="material-icons prefix">phone</i>
                                <input id="passUser" name="passUser" type="password" class="validate" required>
                                <label for="passUser">Contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <select name="perfilUser" id="perfilUser">
                                    <c:forEach items="${listaPerfil}" var="listadoPerfil">                    
                                        <option value="${listadoPerfil.id_perfil}">${listadoPerfil.tipo_perfil}</option>
                                    </c:forEach>


                                </select>
                                <label>Perfil</label>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="modal-footer row">




                    <a  class="modal-action modal-close waves-effect waves-green btn-flat red">Cancelar</a>
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
                        $('.myTable').DataTable();
                    });
        </script>

    </body>
</html>

<%} else {
        response.sendRedirect("index.jsp");
    }
%>
