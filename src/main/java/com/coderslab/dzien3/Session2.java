package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/session2")
public class Session2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <form action=\"/session2\" method=\"get\">\n" +
                "    <input type=\"number\" name=\"grade\"/> <br/>\n" +
                "    <button type=\"submit\">Wyślij</button>\n" +
                "  </form>\n" +
                "</body>\n" +
                "</html>");
        resp.getWriter().append("<br/> ################### <br/>");

        HttpSession session = req.getSession();

        if (session.isNew()) {
            session.setAttribute("grades", new ArrayList<Integer>());
        } else {
            ArrayList<Integer> grades = (ArrayList<Integer>) session.getAttribute("grades");
            Integer grade = Integer.parseInt( req.getParameter("grade"));
            grades.add(grade);
            session.setAttribute("grades", grades);

            Integer sum  = 0;
            for (Integer g: grades){
                sum += g;
                resp.getWriter().println("grade : " + g + "<br/>");
            }
            resp.getWriter().println("Avg : " + (double)sum/grades.size());
        }
    }
}
