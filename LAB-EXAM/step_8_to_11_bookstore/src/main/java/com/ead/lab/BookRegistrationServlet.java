// Nathan Mesfin Shiferaw - UGR/0534/14
package com.ead.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookRegistrationServlet {
    private DBConnectionManager db;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println(
                "<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'></head><body><div class='container'><h2 class='mt-5'>Book Registration Form</h2><form method='post' action='/bookstore/books/addBook'><div class='form-group'><label for='title'>Title:</label><input type='text' class='form-control' id='title' name='title'></div><div class='form-group'><label for='author'>Author:</label><input type='text' class='form-control' id='author' name='author'></div><div class='form-group'><label for='price'>Price:</label><input class='form-control' id='price' name='price'></div><button type='submit' class='btn btn-primary'>Add Book</button></form></div></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = "insert into books(title, author, price) values(?, ?, ?)";
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");

        db.openConnection();
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, price);
            int count = ps.executeUpdate();
            db.closeConnection();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (count == 1) {
                out.println("Book Registration Successful");
            } else {
                out.println("Book Registration Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Book Registration Failed");
        } finally {
            db.closeConnection();
        }
    }
}
