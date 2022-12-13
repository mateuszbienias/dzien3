package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/addToSession")
public class Session3Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("<form action=\"addToSession\" method=\"POST\">\n" +
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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String key = req.getParameter("key");
        String value = req.getParameter("value");

        if (session.isNew() && Objects.isNull(session.getAttribute("keys"))) {
            List<String> keysList = new ArrayList<>();
            session.setAttribute("keys", keysList);
        }
        if(Objects.nonNull(key) && Objects.nonNull(value)) {

                resp.getWriter().println("nie jestem nulem"+ session.getAttribute("keys"));
                List<String> keysSessiionList = (List<String>) session.getAttribute("keys");
                session.setAttribute(key, value);
                keysSessiionList.add(key);
                session.setAttribute("keys", keysSessiionList);
        }
        doGet(req, resp);

    }
}
