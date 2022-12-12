package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie51")
public class Cookie51 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("cookie51", "CodersLab");
        cookie.setMaxAge(60*60*24);
        resp.addCookie(cookie);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append("<html><head><meta charset=\"utf-8\"></head><body><p>");
        resp.getWriter().append("<a href=\"http://localhost:8080/cookie52").append("\">").append("cookie52").append("</a>").append("</br>");
        resp.getWriter().append("</p></body></html>");


    }
}
