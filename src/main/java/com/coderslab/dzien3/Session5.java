package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

@WebServlet("/session5")
public class Session5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Random random = new Random();
        int number1 = random.nextInt(100);
        int number2 = random.nextInt(100);
        int sumNumbers = number1 + number2;
        HttpSession session = req.getSession();
        session.setAttribute("sumNumbers", sumNumbers);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append("<html><head><meta charset=\"utf-8\"></head><body>");
        resp.getWriter().append("<form action=\"/session5\" method=\"post\">\n" +
                "  <input type=\"text\" placeholder=\"first name\" name=\"firstName\"/>\n" +
                "  <input type=\"text\" placeholder=\"last name\" name=\"lastName\"/>\n" +
                "  <input type=\"email\" placeholder=\"email\" name=\"email\"/>\n" +
                "  <label>Wpisz poniżej sumę : ");
        resp.getWriter().append(number1 + " + " +number2);
        resp.getWriter().append("<input type=\"number\" name=\"number\">\n" +
                "  </label>\n" +
                "  <input type=\"submit\" value=\"Wyślij\"/>\n" +
                "</form>");
        resp.getWriter().append("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String number = req.getParameter("number");

        if (Objects.nonNull(session.getAttribute("sumNumbers")) && Objects.nonNull(firstName)
                && Objects.nonNull(lastName) && Objects.nonNull(email) && Objects.nonNull(number)) {

            if (Integer.parseInt(number) == (Integer) session.getAttribute("sumNumbers")) {
                resp.getWriter().println("Wynik poprawny");
            } else {
                resp.getWriter().println("Wynik nie poprawny!!!");
            }
        }
    }
}
