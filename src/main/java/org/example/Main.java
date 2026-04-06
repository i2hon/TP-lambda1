package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

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
    //implementa la interfase A
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

public class Main {
    public static void main(String[] args) {
        AprendiendoLambdas a = new AprendiendoLambdas();
        a.unMetodo((b) -> { System.out.println("abcd" + b);});
        /*
        envia el parametro b pero no retorna nada entonces llama a unMetodo(B b)
        */
        a.unMetodo(() -> System.out.println("abcd"));
        /*
        no envia parametros y no retorna nada entonces llama a unMetodo(A a)
        */
        a.unMetodo((variable) -> {System.out.println("abcd");});
        /*
        envia el parametro variable pero no retorna nada entonces llama a unMetodo(B b)
        */
        //a.unMetodo((variable) -> {System.out.println("abcd"); return true;});
        /*
        envia un parametro no esplicito 'variable'
        entonces el metodo no sabe a que metodo llamar si el unMetodo(C c) o unMetodo(D<Long, Long> d)
        ya que los 2 tienen returns
        para que funcione tendria que ser a.unMetodo((boolean variable) -> {System.out.println("abcd"); return true;});
        */
        a.unMetodo((Long variable) -> {
            System.out.println("abcd");
            return 10L;
        });
        /*
        envia el parametro variable de tipo long y recibe un tipo long entonces llama a unMetodo(D d)
        */
    }
}