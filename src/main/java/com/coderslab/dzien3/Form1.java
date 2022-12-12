package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/post1")
public class Form1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userFirstName = req.getParameter("userFirstName");
        String userLastName = req.getParameter("userLastName");

        resp.setContentType("text/html;charset=utf-8");
        //resp.setHeader("Accept-Encoding", "UTF-8");
        resp.getWriter().append("Witaj ").append(userFirstName).append(" ").append(userLastName).append("</br>");
        resp.getWriter().append("<a href=\"http://localhost:8080/").append("\">Home Page</a>");
    }
}
