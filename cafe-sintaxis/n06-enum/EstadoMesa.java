public enum EstadoMesa {
    LIBRE("Mesa lista para recibir clientes"),
    OCUPADA("Clientes en servicio"),
    POR_LIMPIAR("Mesa desocupada pendiente de aseo"),
    RESERVADA("Mesa apartada con reserva"),
    FUERA_DE_SERVICIO("Mesa inhabilitada temporalmente");

    private final String aviso;

    EstadoMesa(String aviso) {
        this.aviso = aviso;
    }

    public String aviso() {
        return aviso;
    }

    public EstadoMesa siguiente() {
        return switch (this) {
            case OCUPADA -> POR_LIMPIAR;
            case POR_LIMPIAR -> LIBRE;
            case RESERVADA -> OCUPADA;
            case LIBRE -> OCUPADA;
            case FUERA_DE_SERVICIO -> FUERA_DE_SERVICIO;
        };
    }

    public boolean disponible() {
        return this == LIBRE;
    }
}
