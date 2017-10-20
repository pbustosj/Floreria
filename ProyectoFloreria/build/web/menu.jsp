<%@page import="duoc.cl.dej4501.entidades.Usuario"%>
<%@page import="duoc.cl.dej4501.entidades.Menu"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="usuarioConectado" class="duoc.cl.dej4501.entidades.Usuario" scope="session"/>
<jsp:useBean id="objMenuPadre" class="duoc.cl.dej4501.entidades.Menu" scope="page"></jsp:useBean>
<jsp:useBean id="objMenuHijo" class="duoc.cl.dej4501.entidades.Menu" scope="page"></jsp:useBean> 


<jsp:include page="./cargaMenuServlet" flush="true"></jsp:include>
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Baloo+Tammudu" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->


        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">
  
   
</head>
    <!--<ul id="subPel" class="dropdown-content">
       <li><a href="#!">Ingresar</a></li>
       <li><a href="#!">Modificar</a></li>
       <li><a href="#!">Eliminar</a></li>
       <li><a href="#!">Mostrar</a></li>
   </ul>
   <ul id="subUsu" class="dropdown-content">
       <li><a href="Usuario/ingresarUsuario.jsp">Ingresar</a></li>
       <li><a href="#!">Modificar</a></li>
       <li><a href="#!">Eliminar</a></li>
       <li><a href="Usuario/mostrarUsuario.jsp">Mostrar</a></li>
   </ul>
   <nav class="navbar-fixed green" style="min-height: 50px;">
       <div class="nav-wrapper">
           <a href="#!" class="brand-logo center"><img src="https://www.milrosasbilbao.com/sites/all/themes/dmart/images/icons/EnvioIcon.png" height="50px;"></a>
           <ul class="left hide-on-med-and-down">
               <li>  <h5 class="black-text">Bienvenido Sr(a). 
                   </h5></li>
               <li><a href="home.jsp" style=""><i class="material-icons left">home</i>Home</a></li>
               <li><a style="" class="dropdown-button" href="#!" data-activates="subPel" href="badges.html"><i class="material-icons left">movie</i>Concierto</a></li>
   
   
           </ul>
           <ul class="right hide-on-med-and-down">
               <li><a class="dropdown-button" href="#!" data-activates="subUsu" href="badges.html"><i class="material-icons left">account_circle</i>Usuario</a></li>
               <li><a  class="dropdown-button" href="#!" data-activates="dropdown1" href="badges.html"><i class="material-icons left">search</i>Búsquedas</a></li>
               <li><a style="margin-right: 130px;" class="dropdown-button" id="cerrarSesion" href=""><i class="material-icons left">exit_to_app</i>Salir</a></li>
           </ul>
       </div>
   </nav>-->



    <nav class="navbar-fixed green" style="min-height: 50px;">
        <div class="nav-wrapper">
            <a href="#!" class="brand-logo center"></a>
            <ul class="left hide-on-med-and-down">
                <li> Bienvenido Sr(a).  <c:out value="${usuarioConectado.login_usuario}"/>
            </li>
            <c:forEach items="${listadoMenu}" var="objMenuPadre">                    
                <c:if test="${objMenuPadre.padre_menu==0}">
                    <li>
                        <a class="dropdown-button" href="${objMenuPadre.destino_menu}" data-activates="${objMenuPadre.id_menu}"><c:out value="${objMenuPadre.nombre_menu}"></c:out></a>
                     </li>
                </c:if>
           </c:forEach>
                     <li>
                         <a id="cerrarSesion" >Salir</a>
                     </li>
        </ul>
        <c:forEach items="${listadoMenu}" var="objMenuHijo">    
            <ul class="dropdown-content" id="${objMenuHijo.padre_menu}">
                <c:if test="${objMenuHijo.padre_menu>0}">
                    <c:forEach items="${listadoMenu}" var="objMenuHijo"> 
                        <c:if test="${objMenuHijo.padre_menu>0}">
                            <li>
                                <a class="dropdown-button" href="${objMenuHijo.destino_menu}"><c:out value="${objMenuHijo.nombre_menu}"></c:out></a>
                                </li>
                        </c:if>
                    </c:forEach>
                </c:if>
            </ul>
        </c:forEach>

    </div>
</nav>

 <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->



 <script>
    $(document).ready(function () {

        $('#cerrarSesion').click(function () {
            var postData = {
                'Id': '0'
            };
            var direccion = "./cerrarSesion";
            $.ajax({
                url: direccion,
                type: 'GET',
                data: postData,
                error: function () {
                    console.log("Error de servidor!");
                },
                success: function (data) {
                    location.reload();
                }
            });
        });
    });

</script>