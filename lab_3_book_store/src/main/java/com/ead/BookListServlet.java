package com.ead;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {

    private static final String query = "select id, bookname, bookedition, bookprice from books";

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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "r00tadmin123");
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<Book>();
            while (rs.next()) {
                books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4)));
            }

            pw.println(
                    "<html><head> <link rel=\"stylesheet\" href=\"css/bootstrap.css\"> </head><body>");
            pw.println("<table border='1' class=\"table table-striped\">");
            pw.println("<tr>");
            pw.println("<th>Book Id</th>");
            pw.println("<th>Book Name</th>");
            pw.println("<th>Book Edition</th>");
            pw.println("<th>Book Price</th>");
            pw.println("<th>Edit</th>");
            pw.println("<th>Delete</th>");
            pw.println("</tr>");
            for (Book book : books) {
                pw.println("<tr>");
                pw.println("<td>" + book.getId() + "</td>");
                pw.println("<td>" + book.getBookName() + "</td>");
                pw.println("<td>" + book.getBookEdition() + "</td>");
                pw.println("<td>" + book.getBookPrice() + "</td>");
                pw.println("<td><a href ='editScreen?id=" + book.getId() + "'>Edit</a></td>");
                pw.println("<td><a href ='deleteurl?id=" + book.getId() + "'>Delete</a></td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</body></html>");
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h1>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h1>");
        }

        pw.println("<div class=\"text-center\"> <a href='home.html' class=\"btn btn-primary\">Home</a> </div>");
        pw.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
