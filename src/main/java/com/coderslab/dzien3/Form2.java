package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/post2")
public class Form2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sentence = req.getParameter("input");
        String consequences = req.getParameter("consequences");

        List<String> swears = new ArrayList<>();
        swears.add("dupa");
        swears.add("kurde");
        swears.add("cholera");

        if (Objects.nonNull(consequences)) {
            resp.getWriter().append(sentence);
        } else {
            for (String swear: swears) {
                //fajne do analizy
                sentence = sentence.replaceAll(swear, swear.replaceAll(".", "*"));
            }
            resp.getWriter().append(sentence);
        }
    }
}
