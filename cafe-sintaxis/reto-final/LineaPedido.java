public class LineaPedido {
    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad mínima: 1");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public int subtotal() {
        return producto.calcularPrecio() * cantidad;
    }

    public String texto() {
        return cantidad + " × " + producto.getNombre() + " = $" + subtotal();
    }
}
