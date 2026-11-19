public interface Notificador {
    void enviar(String destino, String mensaje);
}

class NotificadorConsola implements Notificador {
    public void enviar(String destino, String mensaje) {
        IO.println("[Notificación a " + destino + "]: " + mensaje);
    }
}
