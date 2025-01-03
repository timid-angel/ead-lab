// Nathan Mesfin Shiferaw - UGR/0534/14
package com.ead.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import lombok.Setter;

@WebServlet("/books/displayBooks")
public class DisplayBooksServlet extends HttpServlet {
    private static final String query = "select * from books";

    @Setter
    private DBConnectionManager db;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        StringBuilder responseBuilder = new StringBuilder();
        db = new DBConnectionManager();
        db.openConnection();
        Connection connection = db.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Book> bookList = new ArrayList<Book>();
            while (rs.next()) {
                bookList.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }

            responseBuilder.append("<html><head>");
            responseBuilder.append(
                    "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>");
            responseBuilder.append("</head><body>");
            responseBuilder.append("<div class='container'><h1 class='my-4'>Book List</h1>");
            responseBuilder.append("");
            responseBuilder.append("<table class='table table-striped'><thead class='thead-dark'><tr>");
            responseBuilder
                    .append("<th scope='col'>Book ID</th><th scope='col'>Title</th><th scope='col'>Description</th><th scope='col'>Author</th><th scope='col'>Delete</th></tr>");
            responseBuilder.append("</thead><tbody>");
            for (Book book : bookList) {
                responseBuilder.append("<tr><td>").append(book.id).append("</td>");
                responseBuilder.append("<td>").append(book.title).append("</td>");
                responseBuilder.append("<td>").append(book.author).append("</td>");
                responseBuilder.append("<td>").append(book.price).append("</td>");
                responseBuilder.append("<td><form method='post' action='/bookstore/books/deleteBook?id=")
                        .append(book.id)
                        .append("'>")
                        .append("<input type='submit' class='btn btn-danger' value='Delete'/>")
                        .append("</form></td>");
                responseBuilder.append("</tr>");
            }
            responseBuilder.append("</tbody>");
            responseBuilder.append("</table>");
            responseBuilder.append("</div>");
            responseBuilder.append("</body></html>");
        } catch (SQLException se) {
            se.printStackTrace();
            responseBuilder.append("<div class='alert alert-danger' role='alert'>").append(se.getMessage())
                    .append("</div>");
        } catch (Exception e) {
            e.printStackTrace();
            responseBuilder.append("<div class='alert alert-danger' role='alert'>").append(e.getMessage())
                    .append("</div>");
        }

        db.closeConnection();
        PrintWriter pw = response.getWriter();
        pw.print(responseBuilder.toString());
    }
}
