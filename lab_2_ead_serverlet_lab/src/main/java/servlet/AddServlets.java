package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlets extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		PrintWriter pw = response.getWriter();
		pw.println("Result: " + (num1 + num2));
		System.out.println(num1 + num2);
	}

}
