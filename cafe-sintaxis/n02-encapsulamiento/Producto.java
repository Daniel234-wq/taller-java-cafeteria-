public class Producto {
    private String nombre;
    private int precio;
    private int stock;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio < 0 || precio > 50000) {
            throw new IllegalArgumentException("Precio fuera de rango: " + precio);
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void reponer(int unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("Unidades para reponer deben ser mayores a 0");
        }
        this.stock += unidades;
    }

    public void vender(int unidades) {
        if (unidades <= 0 || unidades > stock) {
            throw new IllegalArgumentException("Cantidad a vender inválida o excede el stock");
        }
        this.stock -= unidades;
    }
}
