package oop2.ejercicios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuariosDDL {

    private static final String SQL_CREATE_TABLE = """
            CREATE TABLE usuarios (
                id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                nombre VARCHAR(100) NOT NULL,
                email VARCHAR(150) NOT NULL UNIQUE
            )
            """;

    private final String jdbcUrl;

    public UsuariosDDL(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void crearTablaUsuarios() {
        try (Connection connection = DriverManager.getConnection(this.jdbcUrl);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL_CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la tabla usuarios", e);
        }
    }
}
