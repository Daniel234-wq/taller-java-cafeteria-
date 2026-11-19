public class Producto {
    String nombre;
    int precio;
    int stock;

    String descripcion() {
        return nombre + " · $" + precio + " · stock " + stock;
    }

    boolean hayStock() {
        return stock > 0;
    }

    int vender(int cantidad) {
        if (cantidad > stock) {
            IO.println("No alcanza: hay " + stock);
            return 0;
        }
        stock = stock - cantidad;
        return cantidad * precio;
    }
}
