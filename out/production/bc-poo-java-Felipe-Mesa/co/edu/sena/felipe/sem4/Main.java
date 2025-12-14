package co.edu.sena.felipe.sem4;

/**
 * SEMANA 4: DEMOSTRACIÓN DE CLASES ABSTRACTAS E INTERFACES
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   SABORES Y EVENTOS - Semana 4                 ║");
        System.out.println("║   CLASES ABSTRACTAS E INTERFACES               ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ==================== PARTE 1: CREAR SERVICIOS ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 1: CREACIÓN DE SERVICIOS ADICIONALES");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Crear servicio de fotografía (implementa 3 interfaces)
        ServicioFotografia foto1 = new ServicioFotografia("FOTO-001", 8, true);

        // Crear servicio de DJ (implementa 2 interfaces)
        ServicioDJ dj1 = new ServicioDJ("DJ-001", 6, true, true);

        // Crear servicio de decoración (implementa 1 interfaz)
        ServicioDecoracion deco1 = new ServicioDecoracion("DECO-001", "Floral", 100);

        System.out.println("✓ 3 servicios adicionales creados\n");

        // ==================== PARTE 2: USO DE POLIMORFISMO CON CLASE ABSTRACTA ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 2: POLIMORFISMO CON CLASE ABSTRACTA");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Array de tipo ServicioAdicional (clase abstracta)
        ServicioAdicional[] servicios = new ServicioAdicional[3];
        servicios[0] = foto1;
        servicios[1] = dj1;
        servicios[2] = deco1;

        double costoTotal = 0;

        System.out.println("📋 CATÁLOGO DE SERVICIOS:");
        System.out.println("─────────────────────────────────────────────────");

        for (int i = 0; i < servicios.length; i++) {
            ServicioAdicional servicio = servicios[i];
            System.out.println((i + 1) + ". " + servicio.getNombreServicio());
            System.out.println("   Categoría: " + servicio.getCategoria());
            System.out.println("   Descripción: " + servicio.obtenerDescripcion());
            System.out.println("   Costo: $" + String.format("%,.0f", servicio.calcularCosto()));
            System.out.println();

            costoTotal += servicio.calcularCosto();
        }

        System.out.println("─────────────────────────────────────────────────");
        System.out.println("💰 COSTO TOTAL DE SERVICIOS: $" + String.format("%,.0f", costoTotal));
        System.out.println();

        // ==================== PARTE 3: USO DE INTERFACES ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 3: DEMOSTRACIÓN DE INTERFACES");
        System.out.println("═══════════════════════════════════════════════════\n");

        // --- PERSONALIZABLE ---
        System.out.println("🎨 SERVICIOS PERSONALIZABLES:");
        System.out.println("─────────────────────────────────────────────────");

        foto1.personalizarConCliente("María & Carlos");
        deco1.personalizarConCliente("María & Carlos");

        System.out.println("Fotografía: " + foto1.obtenerPersonalizacion());
        System.out.println("Decoración: " + deco1.obtenerPersonalizacion());
        System.out.println();

        // --- RESERVABLE ---
        System.out.println("📅 SERVICIOS RESERVABLES:");
        System.out.println("─────────────────────────────────────────────────");

        foto1.reservar("2025-06-15", "María López");
        dj1.reservar("2025-06-15", "María López");

        System.out.println();

        // Intentar reservar en fecha ocupada
        System.out.println("Intentando reservar fotografía en fecha ocupada:");
        foto1.reservar("2025-06-15", "Otro Cliente");
        System.out.println();

        // --- CALIFICABLE ---
        System.out.println("⭐ SERVICIOS CALIFICABLES:");
        System.out.println("─────────────────────────────────────────────────");

        foto1.agregarCalificacion(5);
        foto1.agregarCalificacion(5);
        foto1.agregarCalificacion(4);

        dj1.agregarCalificacion(5);
        dj1.agregarCalificacion(4);
        dj1.agregarCalificacion(5);
        dj1.agregarCalificacion(5);

        System.out.println("\nCalificaciones:");
        System.out.println("Fotografía: " + String.format("%.1f", foto1.obtenerPromedioCalificaciones()) +
                " ⭐ (" + foto1.getCantidadCalificaciones() + " calificaciones)");
        System.out.println("DJ: " + String.format("%.1f", dj1.obtenerPromedioCalificaciones()) +
                " ⭐ (" + dj1.getCantidadCalificaciones() + " calificaciones)");
        System.out.println();

        // ==================== PARTE 4: VERIFICACIÓN DE INTERFACES (instanceof) ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 4: VERIFICACIÓN DE INTERFACES");
        System.out.println("═══════════════════════════════════════════════════\n");

        for (ServicioAdicional servicio : servicios) {
            System.out.println("Servicio: " + servicio.getNombreServicio());

            if (servicio instanceof Personalizable) {
                System.out.println("  ✓ Es Personalizable");
            }

            if (servicio instanceof Reservable) {
                System.out.println("  ✓ Es Reservable");
            }

            if (servicio instanceof Calificable) {
                System.out.println("  ✓ Es Calificable");
            }

            System.out.println();
        }

        // ==================== PARTE 5: INFORMACIÓN DETALLADA ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 5: INFORMACIÓN DETALLADA");
        System.out.println("═══════════════════════════════════════════════════\n");

        foto1.mostrarInformacion();
        System.out.println();
        foto1.mostrarEstadoReserva();
        System.out.println();

        dj1.mostrarInformacion();
        System.out.println();

        deco1.mostrarInformacion();
        System.out.println();

        // ==================== PARTE 6: OPERACIONES ADICIONALES ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 6: OPERACIONES Y CAMBIOS");
        System.out.println("═══════════════════════════════════════════════════\n");

        System.out.println("Cambiando disponibilidad de servicios:");
        foto1.cambiarDisponibilidad();
        dj1.cambiarDisponibilidad();
        System.out.println();

        System.out.println("Cancelando reservas:");
        foto1.cancelarReserva();
        dj1.cancelarReserva();
        System.out.println();

        // ==================== RESUMEN FINAL ====================
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           RESUMEN SEMANA 4                     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("✓ Clase abstracta ServicioAdicional implementada");
        System.out.println("✓ 3 interfaces creadas (Personalizable, Reservable, Calificable)");
        System.out.println("✓ 3 clases concretas funcionando");
        System.out.println("✓ Polimorfismo con interfaces demostrado");
        System.out.println("✓ Múltiples implementaciones de interfaces");
        System.out.println("\n✅ Semana 4 completada exitosamente\n");
    }
}