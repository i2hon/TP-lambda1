package lambdas.permissions1;

import oop2.lambdas.permissions1.Producto;
import oop2.lambdas.permissions1.Productos;
import oop2.lambdas.permissions1.SecuritySubSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductosTest {

    private List<Producto> productosIniciales;

    @BeforeEach
    public void before() {
        productosIniciales = new ArrayList<>();
        productosIniciales.add(new Producto("p1"));
        productosIniciales.add(new Producto("p2"));
        productosIniciales.add(new Producto("p3"));
        productosIniciales.add(new Producto("p4"));
        productosIniciales.add(new Producto("p5"));
        productosIniciales.add(new Producto("p6"));
        productosIniciales.add(new Producto("p7"));
    }

    @Test
    public void testAdd() {
        var productos = new Productos(this.productosIniciales, new SecuritySubSystem());
        var a1 = new Producto("a1");
        productos.addProducto("1", a1);
        assertEquals(8, productos.cantidad());
        assertTrue(productos.contiene(new Producto("a1")));
    }

    @Test
    public void testRemove() {
        var productos = new Productos(this.productosIniciales, new SecuritySubSystem());
        var p6 = new Producto("p6");
        productos.removeProducto("1", p6);
        assertEquals(6, productos.cantidad());
        assertFalse(productos.contiene(new Producto("p6")));
    }

    @Test
    public void listAll() {
        var productos = new Productos(this.productosIniciales, new SecuritySubSystem());
        var listado = productos.listAll("1");
        assertEquals(7, listado.size());
    }

    @Test
    public void testAddSinPermisosAdd() {
        var productos = new Productos(this.productosIniciales, new SecuritySubSystem());
        var a1 = new Producto("a1");
        assertThrows(RuntimeException.class, () -> productos.addProducto("2", a1));
    }

    @Test
    public void testAddSinPermisosRemove() {
        var productos = new Productos(this.productosIniciales, new SecuritySubSystem());
        var a1 = new Producto("a1");
        assertThrows(RuntimeException.class, () -> productos.removeProducto("2", a1));
    }

    @Test
    public void testAddSinPermisosList() {
        var productos = new Productos(this.productosIniciales, new SecuritySubSystem());
        assertThrows(RuntimeException.class, () -> productos.listAll("2"));
    }
}
