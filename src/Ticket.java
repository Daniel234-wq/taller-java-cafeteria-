public class Ticket {
    public String formatear(Pedido p, int totalFinal) {
        return "=== TICKET CAFÉ SINTAXIS ===\n" +
               "Mesa: " + p.getMesa() + "\n" +
               "Total original: $" + p.total() + "\n" +
               "Total a pagar:  $" + totalFinal + "\n" +
               "============================";
    }
}
