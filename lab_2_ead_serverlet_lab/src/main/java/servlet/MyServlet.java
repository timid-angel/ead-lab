package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// PrintWriter pw = response.getWriter();
	// pw.println("Hello World");
	// }

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// PrintWriter pw = response.getWriter();
	// String username = request.getParameter("username");
	// int age = Integer.parseInt(request.getParameter("age"));
	// pw.printf("%s is %d years old", username, age);
	// }

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// response.setContentType("text/html");
	// PrintWriter pw = response.getWriter();
	// String firstName = request.getParameter("first-name");
	// if (firstName == null) {
	// firstName = "Guest";
	// }
	//
	// pw.println("<html><body>");
	// pw.println("<h1>Hello, " + firstName + "</h1>");
	// pw.println("</body></html>");
	// }

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// response.setContentType("text/html");
	// PrintWriter pw = response.getWriter();
	//
	// String username = request.getParameter("username");
	// String email = request.getParameter("email");
	//
	// pw.println("<html><body>");
	// pw.println("<h1> Form Submitted</h1>");
	// pw.println("<p>Username: " + username + "</p>");
	// pw.println("<p>Email: " + email + "</p>");
	// pw.println("<p>Email: <a href='mailto:" + email + "'>" + email +
	// "</a></p>");
	// pw.println("</body></html>");
	// }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("admin".equals(username) && "123".equals(password)) {
			pw.println("<h1> Welcome, " + username + "</h1>");
		} else {
			pw.println("<h1>Invalid login, please try again.</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
