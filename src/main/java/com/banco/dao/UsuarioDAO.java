package com.banco.dao;

import com.banco.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) throws Exception {
        String query = "SELECT * FROM usuario WHERE nombreUsuario = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, nombreUsuario);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombreUsuario(rs.getString("nombreUsuario"));
            usuario.setPassword(rs.getString("password"));
            return usuario;
        }
        return null;
    }
}
