package com.ead;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MultiplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        PrintWriter pw = response.getWriter();

        pw.println("<h2>Result of Multiplication</h2>");
        pw.printf("<p> %d * %d = %d </p>", num1, num2, num1 * num2);
    }
}
