package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutput;
import java.io.IOException;


@WebServlet("/getForm3")
public class Form3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int page = Integer.parseInt(req.getParameter("page"));

        resp.getWriter().append("Dzielniki liczby ").append(String.valueOf(page)).append(" to: 1, ");
        for (int i = 2; i <=(page/2) ; i++) {
            if (page%i == 0) {
                resp.getWriter().println(i);
            }
        }

    }
}
