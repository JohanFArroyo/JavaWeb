<%-- 
    Document   : formularioCelador
    Created on : 21/09/2023, 11:05:35 a. m.
    Author     : CGAO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Celador</title>
        <link href="publico1/bootstrap-5.3.2-dist/css/bootstrap.css" rel="stylesheet">
    </head>
    <jsp:useBean id="unaCelador" class="modelo.Celador" scope="request" />
    <body>
        <div class="container mt-4" style="font-size: 100px">
        <ul class="list-group">
            <li class="list-group-item d-flex align-items-center">
                <img src="publico1/sena logo.png" alt="Imagen" width="250" height="250">
                <span class="ml-2"  style="color: green">Ingreso Celador</span>
            </li>
        </ul>
        </div>
    <center><h1 class="display-4 text-success">Formulario Celador</h1></center>
        <table border="1" class="table table-bordered table-striped table-success table">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Identificacion</th>
            </tr>
    <c:forEach items="${unaCelador.listar(0)}" var="laCelador">
            <tr class="table-success">
            <form action="ControladorCelador" method="post">
                <td><input type="text" name="fIdCelador" value="${laCelador.idCelador}"></td>
                <td><input type="text" name="fNombre" value="${laCelador.nombre}"></td> 
                <td><input type="text" name="fIdent" value="${laCelador.ident}"></td>
                <td><button type="submit" name="fAccion" value="Modificar">Modificar</button>
                    <button type="submit" name="fAccion" value="Eliminar">Eliminar</button></td>
            </form>
            </tr>
    </c:forEach>
            <tr class="table-info">
            <form action="ControladorCelador" method="post">
                <td><input type="number" name="fIdCelador" value="0"></td>
                <td><input type="text" name="fNombre"></td>
                <td><input type="text" name="fIdent"></td>
                <td><button type="submit" name="fAccion" value="Insertar">Insertar</button>
                    <button type="reset" name="fAccion" value="Limpiar">Limpiar</button></td>
            </form>
            </tr>    
        </table>
    <jsp:include page="jspf1/menu.jspf"/>
    </body>
</html>
