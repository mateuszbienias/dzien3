package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebServlet("/deleteCookie")
public class Cookie1Del extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String cookieName = "User";

        boolean isCookieUser = false;
        if (Objects.nonNull(cookies)) {
            for (Cookie c : cookies) {
                if (cookieName.equals(c.getName())) {
                    c.setMaxAge(0);
                    resp.addCookie(c);
                    isCookieUser = true;
                }
            }
        }
        if (!isCookieUser) {
            resp.getWriter().println("BRAK");
        }
    }
}
