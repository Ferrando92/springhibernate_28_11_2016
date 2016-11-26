<%-- 
    Document   : todobien
    Created on : 17-jul-2012, 18:26:54
    Author     : Chema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta veh&iacute;culo</title>
    </head>
    <body>
        <h2>Datos del nuevo vehículo</h2>
        <ul>
            <li>
                Id: ${vehiculo.id}
            </li>            
            <li>
                Marca: ${vehiculo.marca}
            </li>
            <li>
                Modelo: ${vehiculo.modelo}
            </li>
            <li>
                Matr&iacute;cul: ${vehiculo.matricula}
            </li>
            <li>
                Precio: ${vehiculo.precio}
            </li>
            <li>
                Estado: ${vehiculo.estado}
            </li>
        </ul>
        <h2>Veh&iacute;culos existentes en el concesionario: ${cantidad}</h2>
        <h1><a href="<c:url value="/"/>">Volver al principio</a></h1>
    </body>
</html>
