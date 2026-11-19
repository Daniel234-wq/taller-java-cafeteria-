public class Caja {
    private int saldoEnCaja;
    private final Notificador notificador;
    private final Ticket ticket = new Ticket();

    public Caja(Notificador notificador) {
        this.notificador = notificador;
    }

    public int getSaldoEnCaja() {
        return saldoEnCaja;
    }

    public int cobrar(Pedido pedido, Descuento descuento, String clienteTel) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        if (descuento == null) {
            throw new IllegalArgumentException("El descuento no puede ser nulo");
        }
        if (clienteTel == null || clienteTel.isBlank()) {
            throw new IllegalArgumentException("El teléfono del cliente es requerido");
        }

        int original = pedido.total();
        int totalFinal = descuento.aplicar(original);

        saldoEnCaja += totalFinal;
        IO.println(ticket.formatear(pedido, totalFinal));
        notificador.enviar(clienteTel, "¡Gracias por su compra en Café Sintaxis!");
        return totalFinal;
    }
}
