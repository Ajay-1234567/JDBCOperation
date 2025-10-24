package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import model.User;
import dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);
        UserDao dao = new UserDao();

        if (dao.validate(user)) {
            request.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid credentials");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
