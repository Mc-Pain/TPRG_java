<%-- 
    Document   : index
    Created on : 06.12.2016, 22:13:53
    Author     : McPain
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="vending.*" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <title>Торговый автомат</title>
    </head>
    <body>
        <% if ((String) request.getSession().getAttribute("init") != "true") { %>
        <form action="vendingServlet" method="post">
            <input type="hidden" name="choice" value="init">
            <input id="init" type="submit" value="Включить машину">
        </form>
        <% } else {%>
        <table id = "items">
            <tr>
                <%=(String) request.getSession().getAttribute("output_prod")%>
            </tr>
        </table>
        <table id="info">
            <tr>
                <td>
                    <%=(String) request.getSession().getAttribute("output_money")%>
                </td>
                <td>
                    <%=(String) request.getSession().getAttribute("msg")%>
                </td>
                <td>
                    <%=(String) request.getSession().getAttribute("output_key")%>
                </td>
            </tr>
            <tr>
                <%=(String) request.getSession().getAttribute("output_del")%>
            </tr>
        </table>

        <% }%>
    </body>
</html>
