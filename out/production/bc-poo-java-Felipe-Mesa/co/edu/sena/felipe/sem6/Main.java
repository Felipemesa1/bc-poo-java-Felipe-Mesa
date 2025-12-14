package co.edu.sena.felipe.sem6;

import java.util.ArrayList;

/**
 * SEMANA 6: DEMOSTRACIÓN DE COLECCIONES AVANZADAS
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   SABORES Y EVENTOS - Semana 6                 ║");
        System.out.println("║   COLECCIONES AVANZADAS (HashMap, TreeMap)    ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ========== CREAR SISTEMA ==========
        SistemaGestionEventos sistema = new SistemaGestionEventos();

        // ========== PARTE 1: AGREGAR EVENTOS (HASHMAP) ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 1: AGREGAR EVENTOS CON HASHMAP");
        System.out.println("═══════════════════════════════════════════════════\n");

        EventoCompleto evento1 = new EventoCompleto(
                "EVT-001",
                "Boda Jardín Primavera",
                "Boda",
                "2025-03-15",
                "Hacienda Santa Bárbara",
                180,
                9500000
        );

        EventoCompleto evento2 = new EventoCompleto(
                "EVT-002",
                "Lanzamiento Tech 2025",
                "Corporativo",
                "2025-02-10",
                "Centro de Convenciones",
                300,
                12000000
        );

        EventoCompleto evento3 = new EventoCompleto(
                "EVT-003",
                "Cumpleaños Sofía 10 años",
                "Cumpleaños",
                "2025-04-20",
                "Salón Infantil Arcoíris",
                60,
                2400000
        );

        EventoCompleto evento4 = new EventoCompleto(
                "EVT-004",
                "Graduación Medicina UNAL",
                "Graduación",
                "2025-06-30",
                "Auditorio León de Greiff",
                250,
                7500000
        );

        EventoCompleto evento5 = new EventoCompleto(
                "EVT-005",
                "Aniversario 25 años ABC",
                "Corporativo",
                "2025-01-25",
                "Hotel Tequendama",
                150,
                6800000
        );

        sistema.agregarEvento(evento1);
        sistema.agregarEvento(evento2);
        sistema.agregarEvento(evento3);
        sistema.agregarEvento(evento4);
        sistema.agregarEvento(evento5);

        System.out.println();

        // ========== PARTE 2: BUSCAR EVENTOS (HASHMAP - O(1)) ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 2: BÚSQUEDA RÁPIDA CON HASHMAP");
        System.out.println("═══════════════════════════════════════════════════\n");

        System.out.println("🔍 Buscando evento EVT-003...");
        EventoCompleto encontrado = sistema.buscarEventoPorId("EVT-003");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        }

        System.out.println("\n🔍 Verificando si existe EVT-999...");
        if (sistema.existeEvento("EVT-999")) {
            System.out.println("✓ Evento existe");
        } else {
            System.out.println("✗ Evento no encontrado");
        }

        // ========== PARTE 3: TREEMAP - EVENTOS ORDENADOS ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 3: EVENTOS ORDENADOS (TREEMAP)");
        System.out.println("═══════════════════════════════════════════════════\n");

        sistema.mostrarEventosOrdenadosPorFecha();

        System.out.println("\n🗓️ PRÓXIMO EVENTO:");
        EventoCompleto proximo = sistema.obtenerProximoEvento();
        if (proximo != null) {
            proximo.mostrarInfo();
        }

        System.out.println("\n🗓️ ÚLTIMO EVENTO:");
        EventoCompleto ultimo = sistema.obtenerUltimoEvento();
        if (ultimo != null) {
            ultimo.mostrarInfo();
        }

        // ========== PARTE 4: LINKEDHASHMAP - CLIENTES VIP ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 4: CLIENTES VIP (LINKEDHASHMAP)");
        System.out.println("═══════════════════════════════════════════════════\n");

        ClienteVIP cliente1 = new ClienteVIP("VIP-001", "María López", "3101234567");
        cliente1.contratarEvento();
        cliente1.contratarEvento();
        cliente1.contratarEvento();
        cliente1.contratarEvento();
        cliente1.contratarEvento(); // 5 eventos = 15% descuento

        ClienteVIP cliente2 = new ClienteVIP("VIP-002", "Empresa ABC", "6012345678");
        cliente2.contratarEvento();
        cliente2.contratarEvento();

        ClienteVIP cliente3 = new ClienteVIP("VIP-003", "Carlos Ramírez", "3209876543");
        cliente3.contratarEvento();
        cliente3.contratarEvento();
        cliente3.contratarEvento(); // 3 eventos = 10% descuento

        sistema.agregarClienteVIP(cliente1);
        sistema.agregarClienteVIP(cliente2);
        sistema.agregarClienteVIP(cliente3);

        System.out.println();
        sistema.mostrarClientesVIPEnOrden();

        // ========== PARTE 5: HASHSET - UBICACIONES ÚNICAS ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 5: UBICACIONES ÚNICAS (HASHSET)");
        System.out.println("═══════════════════════════════════════════════════\n");

        sistema.mostrarUbicacionesUsadas();

        System.out.println("\n🔍 Verificando disponibilidad de ubicaciones:");
        System.out.println("Hotel Tequendama: " +
                (sistema.ubicacionDisponible("Hotel Tequendama") ? "DISPONIBLE" : "OCUPADA"));
        System.out.println("Jardín Botánico: " +
                (sistema.ubicacionDisponible("Jardín Botánico") ? "DISPONIBLE" : "OCUPADA"));

        // ========== PARTE 6: ARRAYLIST - SERVICIOS ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 6: SERVICIOS DISPONIBLES (ARRAYLIST)");
        System.out.println("═══════════════════════════════════════════════════");

        sistema.mostrarServiciosDisponibles();

        System.out.println("\n📝 Agregando nuevo servicio...");
        sistema.agregarServicio("Catering Premium Internacional");
        sistema.agregarServicio("Fotografía 360°");

        sistema.mostrarServiciosDisponibles();

        // ========== PARTE 7: BÚSQUEDAS Y FILTROS ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 7: BÚSQUEDAS Y FILTROS");
        System.out.println("═══════════════════════════════════════════════════\n");

        System.out.println("🔍 Buscando eventos CORPORATIVOS:");
        ArrayList<EventoCompleto> corporativos = sistema.buscarEventosPorTipo("Corporativo");
        System.out.println("Encontrados: " + corporativos.size() + " eventos");
        for (EventoCompleto evt : corporativos) {
            System.out.println("  • " + evt.getNombre() + " - " + evt.getFecha());
        }

        System.out.println("\n💰 Evento más costoso:");
        EventoCompleto masCostoso = sistema.obtenerEventoMasCostoso();
        if (masCostoso != null) {
            masCostoso.mostrarInfo();
        }

        // ========== PARTE 8: ELIMINAR EVENTO ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 8: ELIMINAR EVENTO");
        System.out.println("═══════════════════════════════════════════════════\n");

        System.out.println("🗑️ Eliminando evento EVT-003...");
        sistema.eliminarEvento("EVT-003");

        System.out.println("\n🗑️ Intentando eliminar evento inexistente...");
        sistema.eliminarEvento("EVT-999");

        // ========== PARTE 9: ESTADÍSTICAS COMPLETAS ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 9: ESTADÍSTICAS DEL SISTEMA");
        System.out.println("═══════════════════════════════════════════════════");

        sistema.generarEstadisticas();

        // ========== PARTE 10: ITERACIÓN CON DIFERENTES MÉTODOS ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     PARTE 10: RECORRER CLIENTES VIP");
        System.out.println("═══════════════════════════════════════════════════\n");

        System.out.println("Buscando cliente VIP-001:");
        ClienteVIP clienteBuscado = sistema.buscarClienteVIP("VIP-001");
        if (clienteBuscado != null) {
            clienteBuscado.mostrarInfo();
        }

        // ========== RESUMEN FINAL ==========
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           RESUMEN SEMANA 6                     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("✓ HashMap: Búsqueda rápida O(1)");
        System.out.println("✓ TreeMap: Datos ordenados automáticamente");
        System.out.println("✓ LinkedHashMap: Orden de inserción preservado");
        System.out.println("✓ HashSet: Sin duplicados de ubicaciones");
        System.out.println("✓ ArrayList: Lista de servicios dinámica");
        System.out.println("✓ Estadísticas y reportes implementados");
        System.out.println("\n📊 TOTALES:");
        System.out.println("  • Eventos: " + sistema.getTotalEventos());
        System.out.println("  • Clientes VIP: " + sistema.getTotalClientesVIP());
        System.out.println("  • Ubicaciones: " + sistema.getTotalUbicaciones());
        System.out.println("\n✅ Semana 6 completada exitosamente\n");
    }
}