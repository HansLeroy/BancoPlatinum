<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio de Sesión</title>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <form action="login" method="post">
        <label for="nombreUsuario">Usuario:</label>
        <input type="text" name="nombreUsuario" required><br>
        <label for="password">Contraseña:</label>
        <input type="password" name="password" required><br>
        <button type="submit">Iniciar Sesión</button>
    </form>
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Credenciales incorrectas.</p>
    <% } %>
</body>
</html>
