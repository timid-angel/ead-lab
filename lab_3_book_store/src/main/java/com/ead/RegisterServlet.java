package com.ead;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String query = "insert into books(bookname, bookedition, bookprice) values(?, ?, ?)";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root",
                    "r00tadmin123");
            String bookName = request.getParameter("bookName");
            String bookEdition = request.getParameter("bookEdition");
            float bookPrice = Float.parseFloat(request.getParameter("bookPrice"));
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, bookName);
            ps.setString(2, bookEdition);
            ps.setFloat(3, bookPrice);

            int count = ps.executeUpdate();
            pw.println(
                    "<html><head> <link rel=\"stylesheet\" href=\"css/bootstrap.css\"> </head><body>");
            if (count == 1) {
                pw.println("<h2> Book registered successfully.</h2");
            } else {
                pw.println("<h2> Book Not registered successfully.</h2");
            }
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h1>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h1>");
        }

        pw.println("<div class=\"container text-center\">");
        pw.println("<div class=\"text-center\"> <a href='home.html' class=\"btn btn-primary\">Home</a> </div>");
        pw.print("<br>");
        pw.println("<div class=\"text-center\"> <a href='booklist' class=\"btn btn-primary\">Booklist</a> </div>");
        pw.println("</div>");
        pw.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
