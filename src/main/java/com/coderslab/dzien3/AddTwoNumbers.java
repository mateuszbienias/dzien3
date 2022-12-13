package com.coderslab.dzien3;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/add")
public class AddTwoNumbers extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Table Example</title></head>");
        out.println("<body>");
        out.println("<h3>Add Two Numbers</h3>");
        out.println("<form method='post' action='add'>");
        out.println("<p>Enter First Number: <input type='text' name='first'></p>");
        out.println("<p>Enter Second Number: <input type='text' name='second'></p>");
        out.println("<p><input type='submit' value='submit'></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        String a = request.getParameter("first");
        String b = request.getParameter("second");

        int sum = Integer.parseInt(a) + Integer.parseInt(b);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Add</title></head><body>");

        out.println("<p>The sum of " + a + " and "
                + b + " is " + sum + ".</p>");

        out.println("</body></html>");

    }
}