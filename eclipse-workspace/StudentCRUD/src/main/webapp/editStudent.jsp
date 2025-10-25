<%@ page import="java.sql.*, DB.DbConnection" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String name = "", email = "", country = "";
    try (Connection con = DbConnection.getConnection();
         PreparedStatement pst = con.prepareStatement("SELECT * FROM students WHERE id=?")) {
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            name = rs.getString("name");
            email = rs.getString("email");
            country = rs.getString("country");
        }
    } catch(Exception e) { e.printStackTrace(); }
%>
<html>
<head><title>Edit Student</title></head>
<body>
<h2>Edit Student</h2>
<form action="action" method="post">
    <input type="hidden" name="action" value="edit"/>
    <input type="hidden" name="id" value="<%= id %>"/>
    Name: <input type="text" name="name" value="<%= name %>"/><br/>
    Email: <input type="email" name="email" value="<%= email %>"/><br/>
    Country: <input type="text" name="country" value="<%= country %>"/><br/>
    <input type="submit" value="Update Student"/>
</form>
</body>
</html>
