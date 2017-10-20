<%-- 
    Document   : MantenedorPerfil
    Created on : 21-09-2017, 21:31:12
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenedor Perfiles</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp" flush="true"></jsp:include>
            <div id="contenido">
                <h1>MantenedorPerfiles</h1>
                <h2>Listado perfiles</h2>
            <jsp:include page="./listadoPerfil" flush="true"></jsp:include>
            <jsp:useBean id="perfil" class="duoc.cl.dej4501.entidades.Perfil" scope="page"/>
            <table border="1" >
                <thead>
                    <tr>
                        <th>Perfil</th>
                        <th>modificar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaPerfil}" var="perfil">
                        <tr>
                            <td><c:out value="${perfil.nombre_perfil}"/></td>
                            <c:url var="editPerfil" value="./editPerfil">
                                <c:param name="codigoPerfil" value="${perfil.codigo_perfil}"/>
                            </c:url>                            
                            <td><input type="button" class="accion" value="modificar" onclick="window.location.href = '${editPerfil}'"></td>
                                <c:url var="eliminaPerfil" value="./eliminaPerfil">
                                    <c:param name="codigoPerfil" value="${perfil.codigo_perfil}"/>
                                </c:url>
                            <td><input type="button" class="accion" value="eliminar" onclick="window.location.href = '${eliminaPerfil}'"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </br>
            <c:choose>
                <c:when test="${sessionScope.objModificar==null}">
                    <form name="frmAgregar" method="post" action="./addPerfil">
                        <h2>Agregar Perfil</h2>
                        <fieldset style="width: 50%">
                            <p>ingresar nuevo perfil <input type="text" name="txtPerfilNvo" required>
                                <input type="submit" value="agregar Perfil" style="width: 30%"/></p>
                        </fieldset>
                    </form>
                </c:when>
                <c:otherwise>
                    <form name="frmAgregar" method="post" action="./editPerfil">
                        <h2>Editar Perfil</h2>
                        <fieldset style="width: 50%">
                            <p>ingresar nuevo perfil <input type="text" name="txtPerfilEdit"  value="${objModificar.getNombre_perfil()}" required>
                                <input type="submit" value="Editar Perfil" style="width: 30%"/></p>
                        </fieldset>
                    </form>
                </c:otherwise>
            </c:choose>
            <c:if test="${sessionScope.msg!=null}" >
                <c:out value="${sessionScope.msg}"/>
                <c:remove var="msg"></c:remove>
            </c:if>

        </div>
        <jsp:include page="MenuPie.jsp" flush="true"/>
    </body>
</html>
