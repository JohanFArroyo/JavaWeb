<%-- 
    Document   : formularioPortatil
    Created on : 2/10/2023, 10:59:02 a. m.
    Author     : CGAO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Portatil</title>
    </head>
    <jsp:useBean id="unaPortatil" class="modelo.Portatil" scope="request"/>
    <body>
        <jsp:include page="jspf1/menu.jspf"></jsp:include>
        <h1>Formulario Portatil</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Marca</th>
                <th>Codigo</th>
            </tr>
    <c:forEach items="${unaPortatil.listar(0)}" var="laPortatil">
            <tr>
            <form action="ControladorPortatil" method="post">
                <td><input type="text" name="fIdPortatil" value="${laPortatil.idPortatil}"></td>
                <td><input type="text" name="fMarca" value="${laPortatil.marca}"></td> 
                <td><input type="text" name="fCodigo" value="${laPortatil.codigo}"></td>
                <td><button type="submit" name="fAccion" value="Modificar">Modificar</button>
                    <button type="submit" name="fAccion" value="Eliminar">Eliminar</button></td>
            </form>
            </tr>
    </c:forEach>
            <tr>
            <form action="ControladorPortatil" method="post">
                <td><input type="number" name="fIdPortatil" value="0"></td>
                <td><input type="text" name="fMarca"></td>
                <td><input type="text" name="fCodigo"></td>
                <td><button type="submit" name="fAccion" value="Insertar">Insertar</button>
                    <button type="reset" name="fAccion" value="Limpiar">Limpiar</button></td>
            </form>
            </tr>    
        </table>               
    </body>
</html>
