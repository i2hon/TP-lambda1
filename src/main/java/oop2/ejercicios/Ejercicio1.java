package oop2.ejercicios;

interface A {
    void metodo();
}

interface B {
    void metodo(String b);
}

interface C {
    boolean metodo(String c);
}

interface D<T, R> {
    R metodo(T c);
}

class AprendiendoLambdas {
    public void unMetodo(A a) {
        a.metodo();
    }

    public void unMetodo(B b) {
        b.metodo("unString");
    }

    public void unMetodo(C c) {
        System.out.println(c.metodo("otroString") ? "true" : "false");
    }

    public void unMetodo(D<Long, Long> d) {
        d.metodo(10L);
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        AprendiendoLambdas a = new AprendiendoLambdas();
        a.unMetodo((b) -> {
            System.out.println("abcd" + b);
        });
        a.unMetodo(() -> System.out.println("abcd"));
        a.unMetodo((String variable) -> {
            System.out.println("abcd");
            return true;
        });
        a.unMetodo((Long variable) -> {
            System.out.println("abcd");
            return 10L;
        });
    }
}
