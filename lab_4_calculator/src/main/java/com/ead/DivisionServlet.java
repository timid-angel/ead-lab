package com.ead;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DivisionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        PrintWriter pw = response.getWriter();
        if (num2 == 0) {
            pw.println("Division by zero is not allowed");
            return;
        }

        float result = (float) num1 / num2;
        pw.println("<h2>Result of Division</h2>");
        pw.printf("<p> %d / %d = %.3f </p>", num1, num2, result);
    }
}
