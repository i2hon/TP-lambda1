package Tp2_labda2P;

interface C {
    boolean metodo(String c);
}
class AprendiendoLambdas {
    public void unMetodo(C c) {
        System.out.println(c.metodo("abcd"));
    }
}
public class Main {
    public static void main(String[] args) {
        AprendiendoLambdas a = new AprendiendoLambdas();
        //comprueba si el largo de la palabra es par
        a.unMetodo((String c) -> c.length()%2 == 0);
        //comprueba primero que no este bacio, si no esta basio comprueba la pocicion del indice si concide con 'a'
        a.unMetodo((String c) -> !c.isEmpty() && c.charAt(0) == 'a');
    }
}
