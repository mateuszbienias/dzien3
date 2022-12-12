package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        if (Objects.nonNull(cookies)) {
            for (Cookie cookie: cookies) {
                String key = cookie.getName();
                String value = cookie.getValue();

                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().append(key).append(" : ").append(value).append("<a href=\"http://localhost:8080/removeCookie?key=").append(key).append("\">").append(key).append("</a>").append("</br>");

            }
        } else {
            resp.getWriter().append("Brak ciasteczek");
        }

    }
}