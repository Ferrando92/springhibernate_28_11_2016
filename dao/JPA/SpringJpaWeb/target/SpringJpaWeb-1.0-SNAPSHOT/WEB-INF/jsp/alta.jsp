<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P&aacute;gina de altas</title>
    </head>
    <body>
        <h2>Alta de un veh&iacute;culo</h2>
        <form:form modelAttribute="vehiculo">
            <table>
                <tr>
                    <td>Marca:</td>
                    <td>
                        <form:input path="marca"/>
                    </td>
                    <td>
                        <form:errors path="marca"/>
                    </td>
                </tr>
                <tr>
                    <td>Modelo:</td>
                    <td>
                        <form:input path="modelo"/>
                    </td>
                    <td>
                        <form:errors path="modelo"/>
                    </td>
                </tr>
                <tr>
                    <td>Matricula:</td>
                    <td>
                        <form:input path="matricula"/>
                    </td>
                    <td>
                        <form:errors path="matricula"/>
                    </td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td>
                        <form:input path="precio"/>
                    </td>
                    <td>
                        <form:errors path="precio"/>
                    </td>
                </tr>
                <tr>
                    <td>Estado:</td>
                    <td>
                        <form:radiobutton path="estado" value="true"/>Vendido | 
                        <form:radiobutton path="estado" value="false"/>A la venta
                    </td>
                    <td>
                        <form:errors path="estado"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Continuar"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
