import java.util.List;

class Algoritmos {
    static <T> T ultimo(List<T> lista) {
        return lista.getLast();
    }

    static int sumarPrecios(List<? extends Producto> lista) {
        int s = 0;
        for (Producto p : lista) {
            s += p.getPrecio();
        }
        return s;
    }

    static <T extends Comparable<T>> T maximo(List<T> lista) {
        T mejor = lista.getFirst();
        for (T x : lista) {
            if (x.compareTo(mejor) > 0) {
                mejor = x;
            }
        }
        return mejor;
    }

    static <T> int contar(List<T> lista, T buscado) {
        int c = 0;
        for (T item : lista) {
            if (item.equals(buscado)) {
                c++;
            }
        }
        return c;
    }

    static int sumar(List<? extends Number> lista) {
        int s = 0;
        for (Number n : lista) {
            s += n.intValue();
        }
        return s;
    }
}

void main() {
    IO.println("=== Nivel 08: Genéricos ===");

    // Caso de estudio: Repositorio<T>
    IO.println("--- Repositorio Genérico Tipado ---");
    var productos = new Repositorio<Producto>();
    productos.guardar(new Producto(1, "Latte", 9500));
    productos.guardar(new Producto(2, "Brownie", 7000));

    var clientes = new Repositorio<Cliente>();
    clientes.guardar(new Cliente(7, "Sofía"));

    Producto p = productos.porId(2); // Sin necesidad de cast
    IO.println(p.getNombre() + " $" + p.getPrecio());
    IO.println("Cliente: " + clientes.porId(7).nombre());

    IO.println("Último elemento de lista: " + Algoritmos.ultimo(List.of("tinto", "latte", "moka")));

    var masProductos = List.of(new Producto(3, "Té", 4000), new Producto(4, "Moka", 10500));
    IO.println("Total (comodín ? extends): $" + Algoritmos.sumarPrecios(masProductos));

    // Práctica guiada: Máximo con Comparable
    IO.println("\n--- Práctica Guiada: Algoritmo Genérico maximo ---");
    List<Integer> precios = List.of(9500, 3500, 10500, 7000);
    List<String> nombres = List.of("latte", "moka", "tinto");
    IO.println("Precio más alto: " + Algoritmos.maximo(precios));
    IO.println("Último en el menú alfabético: " + Algoritmos.maximo(nombres));

    // Reto autocompletado: Bandeja
    IO.println("\n--- Reto Autocompletado: Bandeja<T> ---");
    Bandeja<String> b = new Bandeja<>(2);
    b.poner("latte");
    b.poner("moka");
    IO.println("¿Cabe un tinto? " + b.poner("tinto"));
    IO.println(b.primera() + " · Total cosas: " + b.cantidad());

    // Reto libre: Historial
    IO.println("\n--- Reto Libre: Historial<T> con Límite ---");
    Historial<String> pedidosHist = new Historial<>(3);
    pedidosHist.agregar("Pedido #1");
    pedidosHist.agregar("Pedido #2");
    pedidosHist.agregar("Pedido #3");
    pedidosHist.agregar("Pedido #4"); // Desaloja #1 con removeFirst()
    IO.println("Historial pedidos (capacidad 3): " + pedidosHist.todos());
    IO.println("Más reciente: " + pedidosHist.masReciente());

    Historial<Integer> cobrosHist = new Historial<>(4);
    cobrosHist.agregar(9500);
    cobrosHist.agregar(7000);
    cobrosHist.agregar(9500);
    IO.println("Apariciones de 9500: " + Algoritmos.contar(cobrosHist.todos(), 9500));
    IO.println("Suma de cobros en historial: $" + Algoritmos.sumar(cobrosHist.todos()));
}
