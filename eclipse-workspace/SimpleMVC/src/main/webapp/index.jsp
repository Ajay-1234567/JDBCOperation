<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Simple MVC Login</h2>
    <form action="login" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

    <p style="color:red;">${errorMessage}</p>
</body>
</html>
