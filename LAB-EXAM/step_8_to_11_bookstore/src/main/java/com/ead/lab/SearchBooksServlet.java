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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchBooksServlet {
    private DBConnectionManager db;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = "select * from books where title like ?";
        String description = request.getParameter("description");
        StringBuilder htmlResponse = new StringBuilder();
        db.openConnection();
        Connection connection = db.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + description + "%");
            ResultSet rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<Book>();
            while (rs.next()) {
                books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }

            htmlResponse.append("<html><head>");
            htmlResponse.append(
                    "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>");
            htmlResponse.append("</head><body>");
            htmlResponse.append(
                    "<div class='container'><h2 class='my-4'>Showing search results for: '" + description
                            + "'</h2><table class='table table-bordered'><thead class='thead-dark'>");
            htmlResponse.append("");
            htmlResponse.append("<tr><th>Book ID</th><th>Title</th><th>Author</th><th>Price</th></tr></thead><tbody>");
            for (Book book : books) {
                htmlResponse.append("<tr>");
                htmlResponse.append("<td>").append(book.id).append("</td>");
                htmlResponse.append("<td>").append(book.title).append("</td>");
                htmlResponse.append("<td>").append(book.author).append("</td>");
                htmlResponse.append("<td>").append(book.price).append("</td>");
                htmlResponse.append("</tr>");
            }
            htmlResponse.append("</tbody></table></div></body></html>");
        } catch (SQLException se) {
            se.printStackTrace();
            htmlResponse.append("<h1>").append(se.getMessage()).append("</h1>");
        } catch (Exception e) {
            e.printStackTrace();
            htmlResponse.append("<h1>").append(e.getMessage()).append("</h1>");
        }

        db.closeConnection();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(htmlResponse.toString());
    }
}
