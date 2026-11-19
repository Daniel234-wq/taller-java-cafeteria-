public record ItemMenu(String nombre, CategoriaMenu categoria, int precio) {
    public ItemMenu {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio debe ser positivo");
        }
    }

    public ItemMenu conPrecio(int nuevo) {
        return new ItemMenu(nombre, categoria, nuevo);
    }
}
