package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addToSession")
public class Session3Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("<form action=\"/addToSession\" method=\"get\">\n" +
                "    <label>\n" +
                "        Klucz:\n" +
                "        <input type=\"text\" name=\"key\">\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Wartość:\n" +
                "        <input type=\"text\" name=\"value\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\">\n" +
                "</form>");

        resp.getWriter().append("<br/> ################### <br/>");

        HttpSession session = req.getSession();

        if (session.isNew()) {
            session.setAttribute("keys", new ArrayList<String>());
            session.setAttribute(req.getParameter("key"), req.getParameter("value"));

        } else {
            ArrayList<String> keys = (ArrayList<String>) session.getAttribute("keys");
            String key = req.getParameter("key");
            keys.add(key);
            session.setAttribute("keys", keys);
            session.setAttribute(key, req.getParameter("value"));
        }

    }
}
