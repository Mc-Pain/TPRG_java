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
        PrintWriter out = response.getWriter();

        String vending = request.getParameter("choice");
        try {
            if (vending.equals("init")) {
                httpSession.setAttribute("init", "true");

                httpSession.setAttribute("msg", "");

                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try {
            for (int i = 0; i < 10; i++) {
                if (vending.equals("item" + i)) {
                    httpSession.setAttribute("msg", String.format("Куплен товар под номером %1$d", i));
                    httpSession.setAttribute("tray" + i, "1");
                }
            }

            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            httpSession.setAttribute("error", e.getMessage());
        }

        try {
            for (int i = 0; i < 10; i++) {
                if (vending.equals("tray_full" + i)) {
                    httpSession.setAttribute("msg", String.format("Взят товар под номером %1$d", i));
                    httpSession.setAttribute("tray" + i, null);
                }
            }

            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
