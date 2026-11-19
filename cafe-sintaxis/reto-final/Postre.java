public class Postre extends Producto {
    private final boolean vegano;

    public Postre(int id, String nombre, int precioBase, boolean vegano) {
        super(id, nombre, precioBase, Categoria.POSTRE);
        this.vegano = vegano;
    }

    public boolean isVegano() { return vegano; }

    @Override
    public int calcularPrecio() {
        return getPrecioBase() + (vegano ? 1000 : 0);
    }

    @Override
    public int minutosPreparacion() {
        return 1;
    }
}
