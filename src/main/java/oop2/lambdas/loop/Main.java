package oop2.lambdas.loop;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Concurso p1 = new Concurso("Concurso X",
                LocalDateTime.of(2024, 3, 22, 10, 30, 10),
                LocalDateTime.of(2024, 4, 22, 10, 30, 10));
        Concurso p2 = new Concurso("Concurso Y",
                LocalDateTime.of(2024, 5, 22, 10, 30, 10),
                LocalDateTime.of(2024, 6, 22, 10, 30, 10));
        Concurso p3 = new Concurso("Concurso Z",
                LocalDateTime.of(2024, 7, 22, 10, 30, 10),
                LocalDateTime.of(2024, 8, 22, 10, 30, 10));

        var ps = new Concursos(p1, p2, p3);
        
        var conNombre = ps.concursoConNombre("Y");
        var empiezanEn = ps.concursosInicianEn(LocalDate.of(2024, 7, 22));

        for (Concurso c : conNombre) {
            System.out.println(c);
        }

        for (Concurso c : empiezanEn) {
            System.out.println(c);
        }

    }
}
