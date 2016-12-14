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
    
    public vending_machine machine;
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
        httpSession = request.getSession();
        
        String vending = request.getParameter("choice");
        try {
            if (vending.equals("init")) {
                machine = new vending_machine();
                machine.PStorage.addproduct("Шоколадный батончик &quot;нену&quot;", 50, 6);
                machine.PStorage.addproduct("Отрава для крыс &quot;ВАААААГХ&quot;", 150, 4);
                machine.PStorage.addproduct("Порошок &quot;Кокаинум&quot;", 300, 5);
                machine.PStorage.addproduct("Чипсы &quot;Эти самые&quot;", 30, 4);
                machine.PStorage.addproduct("Печенье &quot;ПЫЩЬ!&quot;", 45, 4);
                
                httpSession.setAttribute("init", "true");

                httpSession.setAttribute("msg", "");

                product_reload(request);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //забираем продукт
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("trayfull" + item)) {
                    httpSession.setAttribute("msg", String.format("Взят товар под номером %1$d", item));
                    httpSession.setAttribute("tray" + item, null);
                    product_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try { //покупаем продукт
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("item" + item)) {
                    httpSession.setAttribute("tray" + item, "1");
                    machine.buyProduct(item);
                    httpSession.setAttribute("msg", String.format("Куплен товар под номером %1$d<br/>Осталось %2$s шт.", item, machine.PStorage.products.elementAt(item).getLeft()));
                    product_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }
        
        try { //смотрим информацию о продукте
            for (int item = 0; item < machine.PStorage.products.capacity(); item++) {
                if (vending.equals("info" + item)) {
                    httpSession.setAttribute("msg", machine.getProductInfo(item));
                    product_reload(request);
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }
    }
    
    public void product_reload(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        
        //перерисовка страницы
        int i = 0;
        String output = "";
        for (product Product : machine.PStorage.products) {
            output+="<td><table><tr><td>";
            output+="<form action=\"vendingServlet\" method=\"post\">";
            output+=String.format("<input type=\"hidden\" name=\"choice\" value=\"info%1$d\">", i);
            output+=String.format("<input id=\"info%1$d\" type=\"submit\" value=\"", i);
            output+=Product.getName();
            output+="\"></form></td></tr><tr><td>";
            output+="</td></tr><tr><td>";
            String tray = (String) request.getSession().getAttribute("tray" + i);
            output+="<form action=\"vendingServlet\" method=\"post\">";
            output+=String.format("<input type=\"hidden\" name=\"choice\" value=\"item%1$d\">", i);
            output+=String.format("<input id=\"item%1$d\" type=\"submit\" value=\"Купить\"", i);
            if (tray != null || machine.PStorage.products.elementAt(i).getLeft().compareTo("0") == 0)
                output += "disabled";
            output+="></form></td></tr><tr><td>";
            if (tray == null) {
                output+=String.format("<img id=\"tray%1$d\" src=\"img/empty_output.png\" width=\"50\">", i);
            } else {
                output+="<form action=\"vendingServlet\" method=\"post\">";
                output+=String.format("<input type=\"hidden\" name=\"choice\" value=\"trayfull%1$d\">", i);
                output+=String.format("<input type=\"image\" src=\"img/filled_output.png\" width=\"50\" border=\"0\" alt=\"trayfull%1$d\"></form>", i);
            }
            output+="</td></tr></table></td>";
            i++;
        }
        httpSession.setAttribute("output", output);
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
