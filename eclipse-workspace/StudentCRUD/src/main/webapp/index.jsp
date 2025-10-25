<%@ page import="java.util.*, model.Student" %>
<html>
<head><title>Student List</title></head>
<body>
<h2>Student List</h2>
<a href="addStudent.jsp">Add New Student</a>
<table border="1">
<tr>
    <th>ID</th><th>Name</th><th>Email</th><th>Country</th><th>Actions</th>
</tr>
<%
    List<Student> students = (List<Student>) request.getAttribute("studentList");
    if (students != null) {
        for (Student s : students) {
%>
<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getEmail() %></td>
    <td><%= s.getCountry() %></td>
    <td>
        <a href="editStudent.jsp?id=<%= s.getId() %>">Edit</a> |
        <form action="action" method="post" style="display:inline;">
            <input type="hidden" name="action" value="delete"/>
            <input type="hidden" name="id" value="<%= s.getId() %>"/>
            <input type="submit" value="Delete"/>
        </form>
    </td>
</tr>
<%
        }
    } else {
%>
<tr><td colspan="5">No students found.</td></tr>
<%
    }
%>
</table>
</body>
</html>
