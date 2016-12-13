<%-- 
    Document   : index
    Created on : 06.12.2016, 22:13:53
    Author     : McPain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <title>Торговый автомат</title>
    </head>
        <% 
            vending_machine machine = new vending_machine();
        %>
    <body>
        <table id = "items">
            <tr>
                <td>
                    
                </td>
                <td>
                    Название, цена
                </td>
                <td>
                    Название, цена
                </td>
                <td>
                    Название, цена
                </td>
                <td>
                    Название, цена
                </td>
            </tr>
            
            <tr>
                <td>
                    Кнопка
                </td>
                <td>
                    Кнопка
                </td>
                <td>
                    Кнопка
                </td>
                <td>
                    Кнопка
                </td>
                <td>
                    Кнопка
                </td>
            </tr>
            
            <tr>
                <td>
                    Лоток
                </td>
                <td>
                    Лоток
                </td>
                <td>
                    Лоток
                </td>
                <td>
                    Лоток
                </td>
                <td>
                    Лоток
                </td>
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
