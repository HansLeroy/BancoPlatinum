package com.banco.controller;

import com.banco.dao.UsuarioDAO;
import com.banco.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/login") // Esto mapea el servlet a la URL /login
public class LoginServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        // Obtener la conexión de la base de datos desde el contexto de la aplicación
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        usuarioDAO = new UsuarioDAO(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        try {
            // Buscar el usuario en la base de datos
            Usuario usuario = usuarioDAO.obtenerUsuarioPorNombre(nombreUsuario);
            if (usuario != null && usuario.getPassword().equals(password)) {
                // Autenticación exitosa, guardar el usuario en la sesión
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                response.sendRedirect("dashboard.jsp"); // Redirigir al dashboard
            } else {
                // Fallo en la autenticación, redirigir al login con error
                response.sendRedirect("login.jsp?error=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=true"); // Redirigir con error en caso de excepción
        }
    }
}
