public class Bebida {
    private final String nombre;
    private final String tamano;
    private final int precio;
    private final boolean leche;

    public Bebida(String nombre, String tamano, int precio, boolean leche) {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        this.nombre = nombre;
        this.tamano = tamano;
        this.precio = precio;
        this.leche = leche;
    }

    public Bebida(String nombre, int precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Sin nombre");
        }
        this(nombre, "mediano", precio, false);
    }

    public int precioCon(int extras) {
        return precio + extras * 1500;
    }

    public int precioCon(String cupon) {
        if ("CAFE10".equals(cupon)) {
            return precio * 90 / 100;
        }
        return precio;
    }

    public String descripcion() {
        String txt = nombre + " " + tamano + " $" + precio;
        if (leche) {
            txt += " · con leche";
        }
        return txt;
    }
}
