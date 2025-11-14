package co.edu.sena.felipe.sem1;

public class main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║     SABORES Y EVENTOS - Sistema Completo       ║");
        System.out.println("║     Gestión de Clientes y Eventos             ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();

        // PARTE 1: CREAR CLIENTES
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("          PARTE 1: REGISTRO DE CLIENTES");
        System.out.println("═══════════════════════════════════════════════════\n");

        Cliente cliente1 = new Cliente(
                "CLI-001",
                "María Fernanda López",
                "3101234567",
                "maria.lopez@email.com",
                "Personal"
        );

        Cliente cliente2 = new Cliente(
                "CLI-002",
                "Empresa ABC S.A.S.",
                "6012345678",
                "eventos@empresaabc.com",
                "Corporativo"
        );

        Cliente cliente3 = new Cliente(
                "CLI-003",
                "Carlos Andrés Ramírez",
                "3209876543",
                "carlos.ramirez@gmail.com"
        );

        System.out.println("✓ 3 clientes registrados exitosamente\n");

        //  PARTE 2: EVENTOS SIN CLIENTE
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 2: EVENTOS SIN CLIENTE ASIGNADO");
        System.out.println("═══════════════════════════════════════════════════\n");

        CateringEvent evento1 = new CateringEvent("CAT-001", "Boda", 150);
        CateringEvent evento2 = new CateringEvent("CAT-002", "Evento Corporativo", 80);
        CateringEvent evento3 = new CateringEvent("CAT-003", "Cumpleaños", 50);

        System.out.println("EVENTO 1:");
        evento1.showInfo();

        System.out.println("EVENTO 2:");
        evento2.showInfo();

        System.out.println("EVENTO 3:");
        evento3.showInfo();

        //  PARTE 3: EVENTOS CON CLIENTE ASIGNADO
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 3: EVENTOS CON CLIENTE ASIGNADO");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Cliente 1 contrata su primer evento
        CateringEvent evento4 = new CateringEvent(
                "CAT-004",
                "Graduación",
                180,
                "2024-12-15",
                "Auditorio Central Engativá",
                "Estándar",
                cliente1
        );
        cliente1.contratarEvento();

        System.out.println("\nEVENTO 4 (Con Cliente):");
        evento4.showInfo();

        // Cliente 1 contrata más eventos para obtener descuento
        System.out.println("\n--- CLIENTE 1 CONTRATA MÁS EVENTOS ---");
        cliente1.contratarEvento();
        cliente1.contratarEvento();
        cliente1.contratarEvento();

        // Cliente 1 contrata evento con descuento
        CateringEvent evento5 = new CateringEvent(
                "CAT-005",
                "Primera Comunión",
                70,
                "2025-01-20",
                "Salón de Eventos La Esperanza",
                "Premium",
                cliente1
        );

        System.out.println("\nEVENTO 5 (Con Descuento del Cliente 1):");
        evento5.showInfo();

        // Cliente 2 (Corporativo) contrata evento
        CateringEvent evento6 = new CateringEvent(
                "CAT-006",
                "Conferencia",
                200,
                "2024-12-10",
                "Hotel Tequendama",
                "Premium",
                cliente2
        );
        cliente2.contratarEvento();

        System.out.println("\nEVENTO 6 (Cliente Corporativo):");
        evento6.showInfo();

        // ========== PARTE 4: INFORMACIÓN DE CLIENTES ==========
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("       PARTE 4: RESUMEN DE CLIENTES");
        System.out.println("═══════════════════════════════════════════════════\n");

        cliente1.mostrarDatos();
        System.out.println();

        cliente2.mostrarDatos();
        System.out.println();

        cliente3.mostrarDatos();
        System.out.println();

        //  PARTE 5: MÁS EVENTOS
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("          PARTE 5: EVENTOS ADICIONALES");
        System.out.println("═══════════════════════════════════════════════════\n");

        CateringEvent evento7 = new CateringEvent("CAT-007", "Coctel de Lanzamiento", 120);
        CateringEvent evento8 = new CateringEvent("CAT-008", "Baby Shower", 45);

        System.out.println("EVENTO 7:");
        evento7.showInfo();

        System.out.println("EVENTO 8:");
        evento8.showInfo();

        //  RESUMEN FINAL
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              RESUMEN EJECUTIVO                 ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("✓ Total de clientes registrados: 3");
        System.out.println("✓ Total de eventos creados: 8");
        System.out.println("✓ Eventos con cliente asignado: 3");
        System.out.println("✓ Eventos sin cliente: 5");
        System.out.println("✓ Clientes con descuento: 1 (" + cliente1.getNombreCompleto() + ")");
        System.out.println("\n✅ Sistema completo funcionando correctamente");
        System.out.println();
    }
}


