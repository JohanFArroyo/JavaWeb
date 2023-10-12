<%-- 
    Document   : formularioEntrada
    Created on : 3/10/2023, 8:19:33 a. m.
    Author     : CGAO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Entrada</title>
        <link href="publico1/bootstrap-5.3.2-dist/css/bootstrap.css" rel="stylesheet">
    </head>
<jsp:useBean id="unaEntrada" class="modelo.Entrada" scope="request" />
    <body>
        <div class="container mt-4" style="font-size: 80px">
        <ul class="list-group">
            <li class="list-group-item d-flex align-items-center">
                <img src="publico1/sena logo.png" alt="Imagen" width="200" height="200">
                <span class="ml-2"  style="color: green">Ingreso SENA</span>
            </li>
        </ul>
        </div>
    <center><h1 class="display-4 text-success">Formulario Entrada</h1></center>
        <table border="1"  class="table table-bordered table-striped table-success table">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Celador</th>
                <th scope="col">Aprendiz</th>
                <th scope="col">Portatil</th>
                <th scope="col">fechaE</th>
                <th scope="col">fechaS</th>
            </tr>
        <c:forEach items="${unaEntrada.listar(0)}" var="laEntrada">
            <tr class="table-success">
            <form action="ControladorEntrada" method="post">
                <td><input type="text" name="fIdEntrada" value="${laEntrada.idEntrada}"></td>
                <td><input type="text" name="fIdCelador" value="${laEntrada.idCelador}"></td> 
                <td><input type="text" name="fIdAprendiz" value="${laEntrada.idAprendiz}"></td> 
                <td><input type="text" name="fIdPortatil" value="${laEntrada.idPortatil}"></td> 
                <td><input type="text" name="fFechaE" value="${laEntrada.fechaE}"></td>
                <td><input type="text" name="fFechaS" value="${laEntrada.fechaS}"></td>
                <td><button type="submit" name="fAccion" value="Modificar">Modificar</button>
                    <button type="submit" name="fAccion" value="Eliminar">Eliminar</button>
                    <button type="submit" name="fAccion" value="Salida">Salida</button>
                </td>
            </form>
            </tr>
        </c:forEach>
            <tr class="table-info">
            <form action="ControladorEntrada" method="post">
                <td><input type="number" name="fIdEntrada" value="0"></td>
                <td><input type="text" name="fIdCelador"></td>
                <td><input type="text" name="fIdAprendiz"></td>
                <td><input type="text" name="fIdPortatil"></td>
                <td><input readonly type="text" name="fFechaE"></td>
                <td><input readonly type="text" name="fFechaS"></td>
                <td><button type="submit" name="fAccion" value="Insertar">Insertar</button>
                    <button type="reset" name="fAccion" value="Limpiar">Limpiar</button></td>
            </form>
            </tr>    
        </table>
        <jsp:include page="jspf1/menu.jspf"/>
    </body>
</html>
