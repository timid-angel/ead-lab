package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CircleServlet
 */
@WebServlet("/circle")
public class CircleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CircleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		double radius = Double.parseDouble(request.getParameter("radius"));
		String unit = request.getParameter("unit");

		double area = radius * radius * Math.PI;

		pw.println("<!DOCTYPE html>");
		pw.println("<html><head> <title> Circle Area Calculator </title> </head> <body>");
		pw.printf("<h1> Circle Area Calculator Result </h1> <p> Radius: %,.3f %s </p> <p> Area: %,.3f square %s </p>",
				radius, unit, area, unit);
		pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
