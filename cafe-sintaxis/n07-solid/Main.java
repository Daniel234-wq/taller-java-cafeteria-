import java.util.List;

void main() {
    IO.println("=== Nivel 07: Principios SOLID ===");

    // Caso de estudio: Caja Registradora Limpia
    IO.println("--- Caja con Inyección de Dependencias ---");
    Caja caja = new Caja(new SmsSimulado());
    var pedido = List.of(9500, 7000, 3500);

    // OCP & LSP: Descuento del 10% y Descuento Fidelidad
    caja.cobrar(pedido, new Porcentaje(10), "300 555 0101");
    // Verificando que Fidelidad respete contrato sin arrojar negativo (LSP)
    caja.cobrar(List.of(1500), new Fidelidad(), "300 555 0103");

    // Práctica guiada: Doble de prueba en memoria
    IO.println("\n--- Práctica Guiada: Doble de Prueba (Memoria) ---");
    var memoria = new NotificadorMemoria();
    Caja cajaPrueba = new Caja(memoria);
    cajaPrueba.cobrar(List.of(9500), new Porcentaje(0), "300 555 0104");
    cajaPrueba.cobrar(List.of(3500), new Porcentaje(50), "300 555 0105");

    IO.println("Mensajes en memoria enviados: " + memoria.enviados().size());
    IO.println("Último despacho registrado: " + memoria.enviados().getLast());

    // Reto autocompletado: Impresora y Cocina
    IO.println("\n--- Reto Autocompletado: Cocina e Impresora ---");
    Cocina cocina = new Cocina(new ImpresoraConsola());
    cocina.enviarComanda("Sándwich de pollo", 4);

    // Reto libre: Reporte Diario Refactorizado
    IO.println("\n--- Reto Libre: Reporte Diario (SRP, OCP, DIP) ---");
    var ventasDelDia = List.of(9500, 11000, 7000, 3500, 8000);

    ReporteDiario reporteTexto = new ReporteDiario(new FormatoTexto(), new DestinoConsola());
    reporteTexto.emitir(ventasDelDia);

    DestinoMemoria memoriaCsv = new DestinoMemoria();
    ReporteDiario reporteCSV = new ReporteDiario(new FormatoCSV(), memoriaCsv);
    reporteCSV.emitir(ventasDelDia);
    IO.println("Contenido CSV capturado en memoria:\n" + memoriaCsv.getRegistros().getFirst());
}
