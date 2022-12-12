package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/removeCookie")
public class Cookie4Del extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        Cookie[] cookies = req.getCookies();

        boolean isCookieInCookies = false;

        if (Objects.nonNull(cookies)) {
            for (Cookie cookie: cookies) {
                if (key.equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    isCookieInCookies = true;
                }
            }
        }
        if (!isCookieInCookies) {
            resp.getWriter().append("Brak ciasteczka");
        }

    }
}
