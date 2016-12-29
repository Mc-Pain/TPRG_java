/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author McPain
 */
public class vendingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public vendingMachine machine;
    public HttpSession httpSession;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Vending Machine</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Hello!");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); //АнтибНОПНЯ
        httpSession = request.getSession();

        String vending = request.getParameter("choice");
        try { //инициализация машины
            if (vending.equals("init")) {
                machine = new vendingMachine();
                machine.PStorage.addProduct("Шоколадный батончик &quot;нену&quot;", 50, 6);
                machine.PStorage.addProduct("Отрава для крыс &quot;ВАААААГХ&quot;", 150, 4);
                machine.PStorage.addProduct("Порошок &quot;Кокаинум&quot;", 300, 5);
                machine.PStorage.addProduct("Чипсы &quot;Эти самые&quot;", 30, 4);
                machine.PStorage.addProduct("Печенье &quot;ПЫЩЬ!&quot;", 45, 4);

                httpSession.setAttribute("init", "true"); //инициализация машины
                httpSession.setAttribute("msg", ""); //сообщение - пустое
                httpSession.setAttribute("delivery", "empty"); //лоток сдачи пуст
                httpSession.setAttribute("key_pos", "disabled"); //управление отключено

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //покупаем продукт
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("item" + item)) {
                    if (machine.buyProduct(item)) {
                        httpSession.setAttribute("tray" + item, "1");
                    }

                    page_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //забираем продукт
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("trayfull" + item)) {
                    machine.setMessage(String.format("Взят товар под номером %1$d", item));

                    httpSession.setAttribute("tray" + item, null);
                    page_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //смотрим информацию о продукте
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("info" + item)) {
                    machine.getProductInfo(item);

                    page_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //удаляем продукт
            String key_pos = (String) request.getSession().getAttribute("key_pos");
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("delete" + item) && key_pos.equals("enabled")) { //защита
                    machine.deleteProduct(item);

                    page_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //изменяем продукт
            String key_pos = (String) request.getSession().getAttribute("key_pos");
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("change" + item) && key_pos.equals("enabled")) { //защита
                    try {
                        String name = (String) request.getParameter("newname" + item);
                        int cost = Integer.parseInt((String) request.getParameter("newcost" + item));
                        if (!name.equals("") && cost > 0) {
                            machine.changeProduct(item, name, cost);
                        } else {
                            machine.setMessage("Неверные данные");
                        }
                    } catch (NumberFormatException e) {
                        machine.setMessage("Неверная цена");
                    }

                    page_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //добавляем продукт
            String key_pos = (String) request.getSession().getAttribute("key_pos");
            if (vending.equals("addprod") && key_pos.equals("enabled")) { //защита
                try {
                    String name = (String) request.getParameter("addname");
                    int cost = Integer.parseInt((String) request.getParameter("addcost"));
                    if (!name.equals("") && cost > 0) {
                        machine.addProduct(name, cost);
                    } else {
                        machine.setMessage("Неверные данные");
                    }
                } catch (NumberFormatException e) {
                    machine.setMessage("Неверная цена");
                }

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //загружаем продукт
            String key_pos = (String) request.getSession().getAttribute("key_pos");
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("load" + item) && key_pos.equals("enabled")) { //защита
                    try {
                        int amount = Integer.parseInt((String) request.getParameter("load" + item));
                        if (amount > 0) {
                            machine.reloadProduct(item, amount);
                        } else {
                            machine.setMessage("Количество должно быть натуральным числом");
                        }
                    } catch (NumberFormatException e) {
                        machine.setMessage("Неверное количество");
                    }

                    page_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //вносим деньги
            if (vending.equals("money_input")) {
                machine.inputMoney((String) request.getParameter("money_score"));

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //вносим деньги напрямую в хранилище
            String key_pos = (String) request.getSession().getAttribute("key_pos");
            if (vending.equals("storage_input") && key_pos.equals("enabled")) {
                machine.inputStorage((String) request.getParameter("storage_score"));

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //запрашиваем сдачу
            if (vending.equals("delivery")) {
                machine.outputMoney();
                httpSession.setAttribute("delivery", "not_empty");

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //забираем сдачу
            if (vending.equals("get_delivery")) {
                machine.deliveryReset();
                httpSession.setAttribute("delivery", "empty");

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //забираем выручку
            String key_pos = (String) request.getSession().getAttribute("key_pos");
            if (vending.equals("takestorage") && key_pos.equals("enabled")) {
                machine.unloadStorage();

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try {
            if (vending.equals("key_enable")) { //включаем режим управления
                if (machine.getBalance_str().equals("0")) {
                    httpSession.setAttribute("key_pos", "enabled");
                    machine.setMessage("Режим управления включен");
                } else {
                    machine.setMessage("Ошибка! Необходимо забрать деньги");
                }

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try {
            if (vending.equals("key_disable")) { //выключаем режим управления
                httpSession.setAttribute("key_pos", "disabled");
                machine.setMessage("Возврат в штатный режим");

                page_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }
    }

    public void product_reload(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();

        //перерисовка продуктов
        int i = 0;
        String output = "";
        String key_pos = (String) request.getSession().getAttribute("key_pos");
        for (product Product : machine.PStorage.products) {
            output += "<td><table><tr><td>";
            output += "<form action=\"vendingServlet\" method=\"post\">";
            output += String.format("<input type=\"hidden\" name=\"choice\" value=\"info%1$d\">", i);
            output += String.format("<input id=\"info%1$d\" type=\"submit\" value=\"", i);
            output += Product.getName();
            output += "\"></form></td></tr><tr><td>";
            output += "</td></tr><tr><td>";
            String tray = (String) request.getSession().getAttribute("tray" + i);
            output += "<form action=\"vendingServlet\" method=\"post\">";
            output += String.format("<input type=\"hidden\" name=\"choice\" value=\"item%1$d\">", i);
            output += String.format("<input id=\"item%1$d\" type=\"submit\" value=\"Купить\"", i);
            if (tray != null || machine.PStorage.products.elementAt(i).getLeft() == 0) {
                output += " disabled";
            }
            output += "></form></td></tr><tr><td>";
            if (tray == null) {
                output += String.format("<img id=\"tray%1$d\" src=\"img/empty_output.png\" width=\"50\">", i);
            } else {
                output += "<form action=\"vendingServlet\" method=\"post\">";
                output += String.format("<input type=\"hidden\" name=\"choice\" value=\"trayfull%1$d\">", i);
                output += String.format("<input type=\"image\" src=\"img/filled_output.png\" width=\"50\" border=\"0\" alt=\"trayfull%1$d\"></form>", i);
            }

            output += "</td></tr>";
            if (key_pos.equals("enabled")) { //режим управления включен
                output += "<tr><td>"; //форма изменения продукта
                output += "<form action=\"vendingServlet\" method=\"post\">";
                output += String.format("<input type=\"hidden\" name=\"choice\" value=\"change%1$d\">", i);
                output += String.format("<input name=\"newname%1$d\" type=\"text\" placeholder=\"Новое имя\"><br>", i);
                output += String.format("<input name=\"newcost%1$d\" type=\"text\" placeholder=\"Новая цена\"><br>", i);
                output += String.format("<input id=\"change%1$d\" type=\"submit\" value=\"Изменить продукт\">", i);
                output += "</form></td></tr>";

                output += "<tr><td>"; //форма загрузки продукта
                output += "<form action=\"vendingServlet\" method=\"post\">";
                output += String.format("<input type=\"hidden\" name=\"choice\" value=\"load%1$d\">", i);
                output += String.format("<input name=\"load%1$d\" type=\"text\" placeholder=\"Количество\"><br>", i);
                output += String.format("<input id=\"load%1$d\" type=\"submit\" value=\"Загрузить продукт\">", i);
                output += "</form></td></tr>";

                output += "<tr><td>"; //форма удаления продукта
                output += "<form action=\"vendingServlet\" method=\"post\">";
                output += String.format("<input type=\"hidden\" name=\"choice\" value=\"delete%1$d\"><br>", i);
                output += String.format("<input id=\"delete%1$d\" type=\"submit\" value=\"", i);
                output += "Удалить продукт";
                output += "\"></form></td></tr>";
            }

            output += "</table></td>";
            i++;
        }

        if (key_pos.equals("enabled")) { //режим управления включен
            output += "<td><table><tr><td>"; //форма добавления продукта
            output += "<form action=\"vendingServlet\" method=\"post\">";
            output += "<input type=\"hidden\" name=\"choice\" value=\"addprod\">";
            output += "<input name=\"addname\" type=\"text\" placeholder=\"Новое имя\"><br>";
            output += "<input name=\"addcost\" type=\"text\" placeholder=\"Новая цена\"><br>";
            output += "<input id=\"addprod\" type=\"submit\" value=\"";
            output += "Добавить продукт";
            output += "\"></form></td></tr></table></td>";
        }

        httpSession.setAttribute("output_prod", output);
    }

    public void delivery_reload(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String output = "";

        //перерисовка панели сдачи
        String delivery = (String) request.getSession().getAttribute("delivery");
        output += "<td><form action=\"vendingServlet\" method=\"post\">";
        output += "<input type=\"hidden\" name=\"choice\" value=\"delivery\">";
        output += "<input type=\"submit\" value=\"Забрать деньги\"";
        if (!machine.deliveryTest()) {
            output += " disabled"; //недоступность кнопки "Выдать сдачу"
        }
        output += ">";
        if (machine.getStorageAmount() < 1000) {
            output += "Нет сдачи";
        }
        output += "</form></td><td>";
        if (delivery.equals("empty")) {
            output += "<input type=\"image\" src=\"img/empty_output.png\" width=\"50\" border=\"0\" alt=\"get_delivery\">";
        } else {
            output += "<form action=\"vendingServlet\" method=\"post\">";
            output += "<input type=\"hidden\" name=\"choice\" value=\"get_delivery\">";
            output += "<input type=\"image\" src=\"img/filled_output.png\" width=\"50\" border=\"0\" alt=\"get_delivery\">";
            output += "</form>";
        }
        output += "</td>";

        httpSession.setAttribute("output_del", output);
    }

    public void key_reload(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String output = "";

        //перерисовка ключа управления
        String key_pos = (String) request.getSession().getAttribute("key_pos");
        output += "<td><form action=\"vendingServlet\" method=\"post\">";
        if (key_pos.equals("enabled")) { //управление активно
            output += "<input type=\"hidden\" name=\"choice\" value=\"key_disable\">";
            output += "<input type=\"image\" src=\"img/filled_output.png\" width=\"50\" border=\"0\" alt=\"key_enabled\">";
        } else {
            output += "<input type=\"hidden\" name=\"choice\" value=\"key_enable\">";
            output += "<input type=\"image\" src=\"img/empty_output.png\" width=\"50\" border=\"0\" alt=\"key_enabled\">";
        }
        output += "</form>";

        httpSession.setAttribute("output_key", output);
    }

    public void money_reload(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String output = "";

        //перерисовка хранилища денег
        String key_pos = (String) request.getSession().getAttribute("key_pos");

        if (key_pos.equals("disabled")) {
            output += String.format("Баланс: %1$s рублей", machine.getBalance_str());
            output += "<form action=\"vendingServlet\" method=\"post\">";
            output += "<input type=\"hidden\" name=\"choice\" value=\"money_input\">";
            output += "<input name=\"money_score\" type=\"text\">";
            output += "<input type=\"submit\" value=\"Внести деньги\"";

            if (machine.getStorageAmount() < 1000) {
                output += "disabled";
            }

            output += ">";
            output += "</form>";
        }

        if (key_pos.equals("enabled")) {
            output += String.format("В хранилище: %1$s рублей", machine.getStorageAmount());
            output += "<form action=\"vendingServlet\" method=\"post\">";
            output += "<input type=\"hidden\" name=\"choice\" value=\"storage_input\">";
            output += "<input name=\"storage_score\" type=\"text\">";
            output += "<input type=\"submit\" value=\"Загрузить деньги\">";
            output += "</form><br>";
            output += "<form action=\"vendingServlet\" method=\"post\">";
            output += "<input type=\"hidden\" name=\"choice\" value=\"takestorage\">";
            output += "<input type=\"submit\" value=\"Забрать выручку\">";
            output += "</form>";
        }

        httpSession.setAttribute("output_money", output);
    }

    public void page_reload(HttpServletRequest request) {
        httpSession.setAttribute("msg", machine.getMessage());

        product_reload(request);
        key_reload(request);
        money_reload(request);
        delivery_reload(request);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
