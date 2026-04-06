package oop2.lambdas.loop;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Concurso {

    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Concurso(String nombre, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean empiezaEn(LocalDate fechaInicio) {
        return this.fechaInicio.toLocalDate().isEqual(fechaInicio);
    }

    public boolean nombreContiene(String parteOTodoElNombre) {
        return this.nombre.toLowerCase().contains(parteOTodoElNombre.toLowerCase());
    }

    public String nombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}