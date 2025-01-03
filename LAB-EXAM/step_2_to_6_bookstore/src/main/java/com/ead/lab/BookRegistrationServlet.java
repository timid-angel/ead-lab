// Nathan Mesfin Shiferaw - UGR/0534/14
package com.ead.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Setter;

@WebServlet("/books/addBook")
public class BookRegistrationServlet extends HttpServlet {
    private static final String query = "insert into books(title, author, price) values(?, ?, ?)";

    @Setter
    private DBConnectionManager db;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println(
                "<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'></head><body><div class='container'><h2 class='mt-5'>Book Registration Form</h2><form method='post' action='/bookstore/books/addBook'><div class='form-group'><label for='title'>Title:</label><input type='text' class='form-control' id='title' name='title'></div><div class='form-group'><label for='author'>Author:</label><input type='text' class='form-control' id='author' name='author'></div><div class='form-group'><label for='price'>Price:</label><input class='form-control' id='price' name='price'></div><button type='submit' class='btn btn-primary'>Add Book</button></form></div></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");

        db = new DBConnectionManager();
        db.openConnection();
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, price);
            int count = ps.executeUpdate();
            db.closeConnection();
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            if (count == 1) {
                pw.println("Book Registration Successful");
            } else {
                pw.println("Book Registration Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("Book Registration Failed");
        } finally {
            db.closeConnection();
        }
    }
}
