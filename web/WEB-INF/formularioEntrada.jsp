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
    </head>
<jsp:useBean id="unaEntrada" class="modelo.Entrada" scope="request" />
    <body>
        <jsp:include page="jspf1/menu.jspf"/>
        <h1>Formulario Entrada</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Celador</th>
                <th>Aprendiz</th>
                <th>Portatil</th>
                <th>fechaE</th>
                <th>fechaS</th>
            </tr>
        <c:forEach items="${unaEntrada.listar(0)}" var="laEntrada">
            <tr>
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
            <tr>
            <form action="ControladorEntrada" method="post">
                <td><input type="number" name="fIdEntrada" value="0"></td>
                <td><input type="text" name="fIdCelador"></td>
                <td><input type="text" name="fIdAprendiz"></td>
                <td><input type="text" name="fIdPortatil"></td>
                <td><input type="text" name="fFechaE"></td>
                <td><input type="text" name="fFechaS"></td>
                <td><button type="submit" name="fAccion" value="Insertar">Insertar</button>
                    <button type="reset" name="fAccion" value="Limpiar">Limpiar</button></td>
            </form>
            </tr>    
        </table>               
    </body>
</html>
