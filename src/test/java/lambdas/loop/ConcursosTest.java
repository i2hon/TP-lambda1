package lambdas.loop;

import oop2.lambdas.loop.Concurso;
import oop2.lambdas.loop.Concursos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcursosTest {

    @Test
    public void test01() {
        Concurso c1 = new Concurso("Concurso 1",
                LocalDateTime.of(2024, 3, 22, 10, 30, 10),
                LocalDateTime.of(2024, 4, 22, 10, 30, 10));
        Concurso c2 = new Concurso("Concurso 2",
                LocalDateTime.of(2024, 5, 22, 10, 30, 10),
                LocalDateTime.of(2024, 6, 22, 10, 30, 10));
        var concursos = new Concursos(c1, c2);
        var concursosFiltrados = concursos.concursosInicianEn(LocalDate.of(2024, 5, 22));
        assertEquals(1, concursosFiltrados.size());
        assertEquals("Concurso 2", concursosFiltrados.get(0).nombre());
    }

    @Test
    public void test02() {
        Concurso c1 = new Concurso("Concurso 1",
                LocalDateTime.of(2024, 3, 22, 10, 30, 10),
                LocalDateTime.of(2024, 4, 22, 10, 30, 10));
        Concurso c2 = new Concurso("Concurso 2",
                LocalDateTime.of(2024, 5, 22, 10, 30, 10),
                LocalDateTime.of(2024, 6, 22, 10, 30, 10));
        var concursos = new Concursos(c1, c2);
        var concursosFiltrados = concursos.concursosInicianEn(LocalDate.of(2024, 1, 22));
        assertEquals(0, concursosFiltrados.size());
    }

    @Test
    public void test03() {
        Concurso c1 = new Concurso("Sobre POO",
                LocalDateTime.of(2024, 3, 22, 10, 30, 10),
                LocalDateTime.of(2024, 4, 22, 10, 30, 10));
        Concurso c2 = new Concurso("Cuentos de Aventuras",
                LocalDateTime.of(2024, 5, 22, 10, 30, 10),
                LocalDateTime.of(2024, 6, 22, 10, 30, 10));
        var concursos = new Concursos(c1, c2);
        var concursosFiltradas = concursos.concursoConNombre("aventu");
        assertEquals(1, concursosFiltradas.size());
        assertEquals("Cuentos de Aventuras", concursosFiltradas.get(0).nombre());
    }
}
