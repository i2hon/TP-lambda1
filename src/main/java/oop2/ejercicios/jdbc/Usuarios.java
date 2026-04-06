package oop2.ejercicios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Consumer;

public class Usuarios {

    private final String jdbcUrl;

    public Usuarios(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    //usamos consumer porque no retornamos nada
    private void conecionDao(Consumer<Connection> conecion) {
        try (Connection connection = DriverManager.getConnection(this.jdbcUrl)) {
            connection.setAutoCommit(false);
            try {
                //cuando se lee esta línea ejecuta la secuencia del lambat
                //accept para Consumer, test para Predicate
                conecion.accept(connection);

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException("Error al acceder", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al acceder", e);
        }

    }

    public void insertar(String nombre, String email) {
        this.conecionDao(connection -> {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (nombre, email) VALUES (?, ?)")) {
                statement.setString(1, nombre);
                statement.setString(2, email);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void actualizarEmail(int id, String nuevoEmail) {
        this.conecionDao(connection -> {
            try (PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET email = ? WHERE id = ?")) {
                statement.setString(1, nuevoEmail);
                statement.setInt(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }


    /*
    public void insertar(String nombre, String email) {
        try (Connection connection = DriverManager.getConnection(this.jdbcUrl);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (nombre, email) VALUES (?, ?)")) {
            connection.setAutoCommit(false);
            statement.setString(1, nombre);
            statement.setString(2, email);
            try {
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException("Error al insertar usuario", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar usuario", e);
        }
    }

    public void actualizarEmail(int id, String nuevoEmail) {
        try (Connection connection = DriverManager.getConnection(this.jdbcUrl);
             PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET email = ? WHERE id = ?")) {
            connection.setAutoCommit(false);
            statement.setString(1, nuevoEmail);
            statement.setInt(2, id);
            try {
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException("Error al actualizar usuario", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar usuario", e);
        }
    }

     */
}