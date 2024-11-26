<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="styles.css"> <!-- Agrega un archivo CSS si es necesario -->
</head>
<body>
<h1>Registro de Usuario</h1>
<form action="registroServlet" method="post">
    <label for="username">Nombre de Usuario:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required><br><br>

    <button type="submit">Registrarse</button>
</form>
<br>
<a href="login.jsp">¿Ya tienes una cuenta? Inicia sesión aquí</a>
</body>
</html>
