public class Bebida extends Producto {
    private final Tamano tamano;
    private final boolean conLeche;

    public Bebida(int id, String nombre, int precioBase, Categoria categoria, Tamano tamano, boolean conLeche) {
        super(id, nombre, precioBase, categoria);
        if (tamano == null) {
            throw new IllegalArgumentException("Tamaño de bebida inválido");
        }
        this.tamano = tamano;
        this.conLeche = conLeche;
    }

    public Bebida(int id, String nombre, int precioBase) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre de bebida inválido");
        }
        this(id, nombre, precioBase, Categoria.CALIENTE, Tamano.MEDIANO, false);
    }

    public Tamano getTamano() { return tamano; }
    public boolean isConLeche() { return conLeche; }

    @Override
    public int calcularPrecio() {
        return getPrecioBase() + tamano.recargo() + (conLeche ? 500 : 0);
    }

    @Override
    public int minutosPreparacion() {
        return 3;
    }
}
