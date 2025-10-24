package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import operations.StudentDAO;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        StudentDAO dao = new StudentDAO();
        dao.insertStudent("Ajay", "ajay@example.com", 22);

        out.println("<h2>Student inserted successfully</h2>");
    }
}
