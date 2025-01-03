// Nathan Mesfin Shiferaw - UGR/0534/14
package com.ead.lab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet("/books")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookRegistrationServlet bookRegistrationServlet;
    private SearchBooksServlet searchBooksServlet;
    private DisplayBooksServlet displayBooksServlet;
    private DeleteBookServlet deleteBooksServlet;

    @Override
    public void init() throws ServletException {
        super.init();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookRegistrationServlet = (BookRegistrationServlet) context.getBean("bookRegistrationServlet");
        searchBooksServlet = (SearchBooksServlet) context.getBean("searchBooksServlet");
        displayBooksServlet = (DisplayBooksServlet) context.getBean("displayBooksServlet");
        deleteBooksServlet = (DeleteBookServlet) context.getBean("deleteBookServlet");
        context.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        String contextPath = request.getContextPath();
        String requestPath = path.substring(contextPath.length());
        switch (requestPath) {
            case "/books/addBook":
                if ("GET".equalsIgnoreCase(request.getMethod())) {
                    bookRegistrationServlet.doGet(request, response);
                } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                    bookRegistrationServlet.doPost(request, response);
                }
                break;
            case "/books/searchBooks":
                searchBooksServlet.doGet(request, response);
                break;
            case "/books/displayBooks":
                displayBooksServlet.doGet(request, response);
                break;
            case "/books/deleteBook":
                deleteBooksServlet.doPost(request, response);
                break;
            default:
                response.getWriter().println("<h1>404: Not Found</h1>");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

}
