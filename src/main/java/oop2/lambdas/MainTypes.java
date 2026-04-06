package oop2.lambdas;

public class MainTypes {
    public static void main(String[] args) {
        //Tipo en lengajes imperativos, procedurales
        //unNumero pertenece a un conjuto de valores posibles
        //https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
        int unNumero = 1000000000;
        //¿que operaciones puedo realizar? suma, resta... No puedo hacer cualquier cosa.
        // no puedo pedirle un split o concat
        //tengo un conjunto limitado de acciones para hacer con esa entidad que esta tipada.
        //el tipo me define que es lo que puedo realizar y que no.

        //en objetos se refiere a los mensajes que puedo enviarle al objeto
        Integer otroNumber = 10;

        //Lenguajes tipados en compilacion vs tipados en ejecución
        //Estáticamente vs dinámicamente tipados
        Object o = new String("Hola");

//        o = new Integer(10);

        //cual es el tipo de o?
        //cual es el tipo de o2?
        //var o2 = new String("Hola");
    }
}