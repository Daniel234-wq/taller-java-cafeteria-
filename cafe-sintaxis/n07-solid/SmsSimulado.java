public class SmsSimulado implements Notificador {
    public void enviar(String destino, String mensaje) {
        IO.println("SMS a " + destino + ": " + mensaje);
    }
}
