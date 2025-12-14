package co.edu.sena.felipe.sem5;

/**
 * SEMANA 5: DEMOSTRACIÓN DE MANEJO DE EXCEPCIONES
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   SABORES Y EVENTOS - Semana 5                 ║");
        System.out.println("║   MANEJO DE EXCEPCIONES                        ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ==================== CASO 1: RESERVA EXITOSA ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     CASO 1: RESERVA EXITOSA (SIN ERRORES)");
        System.out.println("═══════════════════════════════════════════════════\n");

        ReservaEvento reserva1 = new ReservaEvento("RES-001");

        try {
            reserva1.establecerCliente("María Fernanda López");
            reserva1.establecerTipoEvento("Boda");
            reserva1.establecerInvitados(150);
            reserva1.establecerFecha("2025-06-15");
            reserva1.verificarPresupuesto(12000000, 9750000);
            reserva1.confirmarReserva();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ==================== CASO 2: FECHA INVÁLIDA ====================
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     CASO 2: ERROR - FECHA INVÁLIDA");
        System.out.println("═══════════════════════════════════════════════════\n");

        ReservaEvento reserva2 = new ReservaEvento("RES-002");

        try {
            reserva2.establecerCliente("Carlos Ramírez");
            reserva2.establecerTipoEvento("Cumpleaños");
            reserva2.establecerInvitados(80);

            // Intentar con fecha pasada
            System.out.println("Intentando establecer fecha pasada...");
            reserva2.establecerFecha("2024-01-01");

        } catch (FechaNoValidaException e) {
            System.out.println(e.getMessage());
            System.out.println("💡 Solución: Utilice una fecha futura con al menos 7 días de anticipación");

            // Corregir y continuar
            try {
                reserva2.establecerFecha("2025-07-20");
            } catch (FechaNoValidaException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ==================== CASO 3: CAPACIDAD EXCEDIDA ====================
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     CASO 3: ERROR - CAPACIDAD EXCEDIDA");
        System.out.println("═══════════════════════════════════════════════════\n");

        ReservaEvento reserva3 = new ReservaEvento("RES-003");

        try {
            reserva3.establecerCliente("Empresa ABC S.A.S.");
            reserva3.establecerTipoEvento("Corporativo");

            // Intentar con más invitados de los permitidos
            System.out.println("Intentando reservar para 600 invitados...");
            reserva3.establecerInvitados(600);

        } catch (CapacidadExcedidaException e) {
            System.out.println(e.getMessage());
            System.out.println("💡 Capacidad máxima: " + e.getCapacidadMaxima() + " personas");
            System.out.println("💡 Puede dividir el evento en dos fechas");

            // Corregir con capacidad válida
            try {
                System.out.println("\nAjustando a capacidad máxima...");
                reserva3.establecerInvitados(500);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ==================== CASO 4: PRESUPUESTO INSUFICIENTE ====================
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     CASO 4: ERROR - PRESUPUESTO INSUFICIENTE");
        System.out.println("═══════════════════════════════════════════════════\n");

        ReservaEvento reserva4 = new ReservaEvento("RES-004");

        try {
            reserva4.establecerCliente("Ana Gómez");
            reserva4.establecerTipoEvento("Graduación");
            reserva4.establecerInvitados(100);
            reserva4.establecerFecha("2025-08-15");

            // Presupuesto insuficiente
            System.out.println("Verificando presupuesto...");
            reserva4.verificarPresupuesto(3000000, 4500000);

        } catch (PresupuestoInsuficienteException e) {
            System.out.println(e.getMessage());
            System.out.println("💡 Faltan: $" + String.format("%,.0f", e.getDiferencia()));
            System.out.println("💡 Opciones:");
            System.out.println("   1. Aumentar el presupuesto");
            System.out.println("   2. Reducir número de invitados");
            System.out.println("   3. Elegir un menú más económico");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ==================== CASO 5: DATOS INVÁLIDOS ====================
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     CASO 5: ERROR - DATOS INVÁLIDOS");
        System.out.println("═══════════════════════════════════════════════════\n");

        ReservaEvento reserva5 = new ReservaEvento("RES-005");

        try {
            // Nombre muy corto
            System.out.println("Intentando con nombre inválido...");
            reserva5.establecerCliente("AB");

        } catch (DatosInvalidosException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Tipo de evento inválido
            System.out.println("\nIntentando con tipo de evento inválido...");
            reserva5.establecerTipoEvento("Fiesta Loca");

        } catch (DatosInvalidosException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Muy pocos invitados
            System.out.println("\nIntentando con pocos invitados...");
            reserva5.establecerInvitados(5);

        } catch (DatosInvalidosException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ==================== CASO 6: MÚLTIPLES EXCEPCIONES ====================
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     CASO 6: MANEJO DE MÚLTIPLES ERRORES");
        System.out.println("═══════════════════════════════════════════════════\n");

        ReservaEvento reserva6 = new ReservaEvento("RES-006");
        int erroresEncontrados = 0;

        // Intentar establecer todos los datos y capturar todos los errores
        try {
            reserva6.establecerCliente("Pedro Sánchez");
        } catch (Exception e) {
            System.out.println("Error 1: " + e.getMessage());
            erroresEncontrados++;
        }

        try {
            reserva6.establecerTipoEvento("Boda");
        } catch (Exception e) {
            System.out.println("Error 2: " + e.getMessage());
            erroresEncontrados++;
        }

        try {
            reserva6.establecerInvitados(700); // Excede capacidad
        } catch (Exception e) {
            System.out.println("Error 3: " + e.getMessage());
            erroresEncontrados++;

            // Corregir
            try {
                reserva6.establecerInvitados(200);
            } catch (Exception ex) {}
        }

        try {
            reserva6.establecerFecha("2020-01-01"); // Fecha pasada
        } catch (Exception e) {
            System.out.println("Error 4: " + e.getMessage());
            erroresEncontrados++;

            // Corregir
            try {
                reserva6.establecerFecha("2025-09-20");
            } catch (Exception ex) {}
        }

        try {
            reserva6.verificarPresupuesto(5000000, 8000000); // Insuficiente
        } catch (Exception e) {
            System.out.println("Error 5: " + e.getMessage());
            erroresEncontrados++;
        }

        System.out.println("\n📊 Total de errores encontrados: " + erroresEncontrados);

        // ==================== CASO 7: TRY-CATCH-FINALLY ====================
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("     CASO 7: DEMOSTRACIÓN DE FINALLY");
        System.out.println("═══════════════════════════════════════════════════\n");

        ReservaEvento reserva7 = new ReservaEvento("RES-007");

        try {
            System.out.println("Iniciando proceso de reserva...");
            reserva7.establecerCliente("Laura Martínez");
            reserva7.establecerTipoEvento("Cumpleaños");
            reserva7.establecerInvitados(60);
            reserva7.establecerFecha("2025-10-10");
            reserva7.verificarPresupuesto(3500000, 2400000);
            reserva7.confirmarReserva();

        } catch (Exception e) {
            System.out.println("❌ Error en el proceso: " + e.getMessage());
        } finally {
            System.out.println("\n🔒 Bloque finally ejecutado (siempre se ejecuta)");
            System.out.println("   - Guardando log de la operación...");
            System.out.println("   - Liberando recursos...");
            System.out.println("   - Proceso finalizado");
        }

        // ==================== RESUMEN FINAL ====================
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           RESUMEN SEMANA 5                     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("✓ 5 excepciones personalizadas creadas");
        System.out.println("✓ Try-catch-finally demostrado");
        System.out.println("✓ Manejo de múltiples excepciones");
        System.out.println("✓ Validaciones implementadas correctamente");
        System.out.println("✓ Mensajes de error descriptivos");
        System.out.println("\n✅ Semana 5 completada exitosamente\n");
    }
}