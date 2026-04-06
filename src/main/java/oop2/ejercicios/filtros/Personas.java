package oop2.ejercicios.filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Personas {

    public List<Persona> nombresQueEmpiezanConE(List<Persona> p) {
        return this.filtrar(p, persona -> persona.nombre().startsWith("E"));
    }

    public List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> p) {
        return this.filtrar(p, persona -> persona.nombre().length() % 2 == 0);
    }

    //
    public List<Persona> filtrar(List<Persona> p, Predicate<Persona> criterio) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona persona : p) {
            if (criterio.test(persona)) {
                resultado.add(persona);
            }
        }
        return resultado;
    }

    /* original
    //filtra la lista de personas devolviendo otra lista con
    //solo aquellas cuyo nombre comienza con E
    public List<Persona> nombresQueEmpiezanConE(List<Persona> p) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona persona : p) {
            if (persona.nombre().startsWith("E")) {
                resultado.add(persona);
            }
        }
        return resultado;
    }

    public List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> p) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona persona : p) {
            if (persona.nombre().length() % 2 == 0) {
                resultado.add(persona);
            }
        }
        return resultado;
    }

     */


}
