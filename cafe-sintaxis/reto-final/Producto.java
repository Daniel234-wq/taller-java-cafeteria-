public abstract class Producto implements Identificable {
    private final int id;
    private final String nombre;
    private final int precioBase;
    private final Categoria categoria;

    protected Producto(int id, String nombre, int precioBase, Categoria categoria) {
        if (id < 1) {
            throw new IllegalArgumentException("Id de producto inválido");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre de producto inválido");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Categoría requerida");
        }
        if (precioBase <= 0) {
            throw new IllegalArgumentException("Precio base debe ser mayor a 0");
        }
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }

    @Override
    public int id() { return id; }
    public String getNombre() { return nombre; }
    public int getPrecioBase() { return precioBase; }
    public Categoria getCategoria() { return categoria; }

    public abstract int calcularPrecio();
    public abstract int minutosPreparacion();

    public String ficha() {
        return "#" + id + " " + nombre + " [" + categoria.etiqueta() + "] $" + calcularPrecio() + " (" + minutosPreparacion() + " min)";
    }
}
