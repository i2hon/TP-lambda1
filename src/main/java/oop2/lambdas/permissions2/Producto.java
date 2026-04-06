package oop2.lambdas.permissions2;

import java.util.Objects;

public class Producto {
    private String name;

    public Producto(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(name, producto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
