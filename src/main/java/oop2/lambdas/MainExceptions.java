package oop2.lambdas;

import java.nio.file.Files;
import java.nio.file.Path;

public class MainExceptions {
    public static void main(String[] args) {
        //Throwable -> Exception -> RuntimeException
        //checked vs unchedcked exceptions
        var m = new MainExceptions();
        m.lanzaCheckedException();
        m.lanzaUnCheckedException();
    }

    public void lanzaCheckedException() {
        try {
            Files.writeString(Path.of(""), "string bajar a disco");
            //throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void lanzaUnCheckedException() {
        throw new RuntimeException();
    }
}
