<%-- 
    Document   : formularioCelador
    Created on : 21/09/2023, 11:05:35 a. m.
    Author     : CGAO
--%>

<%taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Celador</title>
    </head>
    <jsp:useBean id="unaCelador" class="modelo.Celador" scope="request" />
    <body>
        <jsp:include page="jspf/menu.jspf"></jsp:include>
        <h1>Formulario Pelicula</h1>
        <<table border="1">
            <tr>
                <th>Nombre</th>
                <th>Identificacion</th>
            </tr>
    <c:forEach items="${unaCelador.listar(0)}" var="laCelador">
            <tr>
            <form action="ControladorCelador" method="post">
                <td><input type="hidden" name="fIdCelador" value="${laCelador.idCelador}">
                <input type="text" name="fNombre" value="${laCelador.nombre}"></td> 
                <td><input type="text" name="fIdent" value="${laPelicula.ident}"></td>
                <td><button type="submit" name="fAccion" value="Modificar">Modificar</button>>
                    <button type="submit" name="fAccion" value="Eliminar">Eliminar</button>></td>
            </form>
            </tr>
    </c:forEach>
            <tr>
            <form action="ControladorCelador" method="post">
                <td><input type="number" name="fIdCelador" value="0">
                    <input type="text" name="fNombre"></td>
                <td><input type="text" name="fIdent"></td>
                <td><button type="submit" name="fAccion" value="Insertar">Insertar</button>>
                    <button type="reset" name="fAccion" value="Limpiar">Limpiar</button>></td>
            </form>
            </tr>    
        </table>               
                <c:forEach begin="1" end="5" var="i">
                    <c:out value="${i}"/>
                </c:forEach>
    </body>
</html>
