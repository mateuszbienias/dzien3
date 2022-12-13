package com.coderslab.dzien3;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (Objects.nonNull(session.getAttribute("keys"))) {
            ArrayList<String> keys = (ArrayList<String>) session.getAttribute("keys");
            for (String key: keys
            ) {
                String value = session.getAttribute(key).toString();
                resp.getWriter().println(key + " : " + value);
            }
        } else {
            resp.getWriter().println("Nie ma sesji");
        }


    }
}
