package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        boolean isCookieInCookies = false;

        if (Objects.nonNull(cookies)) {
            resp.getWriter().append("Witamy na stronie Cookie52");
            for (Cookie cookie: cookies) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                isCookieInCookies = true;

            }
        }
        if (!isCookieInCookies) {
            String message = "Nie odwiedziles jeszcze tej strony";
            resp.sendRedirect("cookie51?msg=" + URLEncoder.encode(message, "UTF-8"));

        }

    }
}
