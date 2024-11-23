package com.ead;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OperationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String operation = request.getParameter("Operation");
        RequestDispatcher dispatcher = null;
        switch (operation) {
            case "add":
                dispatcher = request.getRequestDispatcher("/addservlet");
                break;
            case "subtract":
                dispatcher = request.getRequestDispatcher("/subtractservlet");
                break;
            case "multiply":
                dispatcher = request.getRequestDispatcher("/multiplyservlet");
                break;
            case "divide":
                dispatcher = request.getRequestDispatcher("/divideservlet");
                break;
            default:
                response.getWriter().println("Invalid Operation");
                return;
        }

        dispatcher.forward(request, response);
    }
}