package com.coderslab.dzien3;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<String> keys = (ArrayList<String>) session.getAttribute("keys");

        for (String key: keys
             ) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().append(key).append(" : ").append(session.getAttribute(key).toString()).append("<br/>");
        }

    }
}
