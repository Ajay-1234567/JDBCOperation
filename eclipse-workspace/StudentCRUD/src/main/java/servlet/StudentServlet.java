package servlet;

import DB.DbConnection;
import model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                Student s = new Student(rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getString("email"),
                                        rs.getString("country"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("studentList", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
