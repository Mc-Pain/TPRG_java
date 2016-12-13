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
        <%
            vending_machine machine = new vending_machine();
            machine.PStorage.addproduct("Шоколадный батончик \"нену\"",50,6);
            machine.PStorage.addproduct("Отрава для крыс \"ВАААААГХ\"",150,4);
            machine.PStorage.addproduct("Кораллы \"У Клары\"",300,5);
            machine.PStorage.addproduct("Чипсы \"Эти самые\"",30,4);
            machine.PStorage.addproduct("Печенье \"ПЫЩЬ!\"",45,4);
        %>
        <table id = "items">
            <tr>
                <%
                    for (product Product : machine.PStorage.products){
                        out.print("<td><table><tr><td>");
                        out.print(Product.genInfo());
                        out.print("</td></tr><tr><td>");
                        out.print("Кнопка");
                        out.print("</td></tr><tr><td>");
                        out.print("Лоток");
                        out.print("</td></tr></table></td>");
                    }
                %>
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
    </body>
</html>
