package oop2.ejercicios.jdbc;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:derby:memory:usuariosDb;create=true";

        UsuariosDDL usuariosDDL = new UsuariosDDL(jdbcUrl);
        Usuarios usuarios = new Usuarios(jdbcUrl);

        usuariosDDL.crearTablaUsuarios();
        usuarios.insertar("Ana", "ana@mail.com");
        usuarios.insertar("Luis", "luis@mail.com");
        usuarios.actualizarEmail(1, "ana.actualizada@mail.com");

    }
}
