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
        HttpSession httpSession = request.getSession();

        String vending = request.getParameter("choice");
        try {
            if (vending.equals("init")) {
                machine = new vending_machine();
                machine.PStorage.addproduct("Шоколадный батончик \"нену\"", 50, 6);
                machine.PStorage.addproduct("Отрава для крыс \"ВАААААГХ\"", 150, 4);
                machine.PStorage.addproduct("Порошок \"Кокаинум\"", 300, 5);
                machine.PStorage.addproduct("Чипсы \"Эти самые\"", 30, 4);
                machine.PStorage.addproduct("Печенье \"ПЫЩЬ!\"", 45, 4);
                
                
                httpSession.setAttribute("init", "true");

                httpSession.setAttribute("msg", "");

                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try {
            for (int i = 0; i < machine.PStorage.products.capacity(); i++) {
                if (vending.equals("trayfull" + i)) {
                    httpSession.setAttribute("msg", String.format("Взят товар под номером %1$d", i));
                    httpSession.setAttribute("tray" + i, "0");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try {
            for (int i = 0; i < machine.PStorage.products.capacity(); i++) {
                if (vending.equals("item" + i)) {
                    httpSession.setAttribute("msg", String.format("Куплен товар под номером %1$d", i));
                    httpSession.setAttribute("tray" + i, "1");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }
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
