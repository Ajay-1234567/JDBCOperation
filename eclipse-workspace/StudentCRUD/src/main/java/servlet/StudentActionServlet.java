package servlet;

import DB.DbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/action")
public class StudentActionServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addStudent(request);
        } else if ("edit".equals(action)) {
            editStudent(request);
        } else if ("delete".equals(action)) {
            deleteStudent(request);
        }

        response.sendRedirect("students");
    }

    private void addStudent(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        String sql = "INSERT INTO students (name, email, country) VALUES (?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, country);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editStudent(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        String sql = "UPDATE students SET name=?, email=?, country=? WHERE id=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, country);
            pst.setInt(4, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
