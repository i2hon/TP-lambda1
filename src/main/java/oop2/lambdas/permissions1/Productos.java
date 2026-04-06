package oop2.lambdas.permissions1;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Productos {
    public static final String SIN_PERMISOS = "No tiene los permisos necesarios";
    private List<Producto> productos;
    private SecuritySubSystem security;

    public Productos(List<Producto> productos, SecuritySubSystem security) {
        this.security = security;
        this.productos = productos;
    }

    private <T> T ejecutarSiUserTienePermiso(String userId, Supplier<T> supplier) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        return supplier.get();
    }

    public void addProducto(String userId, Producto producto) {
        this.ejecutarSiUserTienePermiso(userId, () -> this.productos.add(producto));
    }

    public void removeProducto(String userId, Producto producto) {
        this.ejecutarSiUserTienePermiso(userId, () -> this.productos.remove(producto));

    }

    public List<Producto> listAll(String userId) {
        return this.ejecutarSiUserTienePermiso(userId, () -> Collections.unmodifiableList(this.productos));
    }

    /* original
    public void addProducto(String userId, Producto producto) {
        verificarUserId(userId);
        this.productos.add(producto);
    }

    public void removeProducto(String userId, Producto producto) {
        verificarUserId(userId);
        this.productos.remove(producto);
    }

    public List<Producto> listAll(String userId) {
        verificarUserId(userId);
        return Collections.unmodifiableList(this.productos);
    }

    private void verificarUserId(String userId) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
    }
     */

    /*
    Runnable no funciona para este tp lo tengo para recordar como va
    private void ejecutarSiUserTienePermiso(String userId, Runnable runnable) {
        //primero cuando se invoque chequea si tiene permiso
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        //aca se ejecuta la lambda que se le paso
        runnable.run();
    }

    public void addProducto(String userId, Producto producto) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        this.productos.add(producto);
        this.ejecutarSiUserTienePermiso(userId, () -> this.productos.add(producto));

    }

    public void removeProducto(String userId, Producto producto) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        this.productos.remove(producto);
    }

    public List<Producto> listAll(String userId) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        return Collections.unmodifiableList(this.productos);
    }
     */

    int cantidad() {
        return this.productos.size();
    }

    boolean contiene(Producto unProducto) {
        return this.productos.contains(unProducto);
    }
}
