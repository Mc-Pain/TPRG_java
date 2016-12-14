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
        <%=(String) request.getSession().getAttribute("msg")%>
        <table id = "items">
            <tr>
                <% int i = 0;
                    for (product Product : machine.PStorage.products) {%>
                <td><table><tr><td>
                                <%=Product.genInfo()%>
                            </td></tr><tr><td>
                                <form action="vendingServlet" method="post">
                                    <input type="hidden" name="choice" value="<%="item" + i%>">
                                    <input id="<%="item" + i%>" type="submit" value="Купить">
                                </form>
                            </td></tr><tr><td>
                            <% String tray = (String) request.getSession().getAttribute("tray" + i); %>
                            <% if (tray == "0" || tray == null) {%>
                                <img id="<%="tray" + i%>" src="img/empty_output.png" width="50">
                                <% } else {%>
                                <form action="vendingServlet" method="post">
                                    <input type="hidden" name="choice" value="<%="trayfull" + i%>">
                                    <input type="image" src="img/filled_output.png" width="50" border="0" alt="<%="tray_full" + i%>">
                                </form>
                                <% } %>
                            </td></tr></table></td>
                            <% i++; %>
                            <% } %>
            </tr>
        </table>
        <table id="info">
            <tr>
                <td>
                    Купюроприемник
                </td>
                <td>
                    Дисплей
                </td>
                <td>
                    Ключ управления
                </td>
            </tr>
            <tr>
                <td>
                    Кнопка "Сдача"
                </td>
                <td>
                    Щель для сдачи
                </td>
            </tr>
        </table>

        <% }%>
    </body>
</html>
