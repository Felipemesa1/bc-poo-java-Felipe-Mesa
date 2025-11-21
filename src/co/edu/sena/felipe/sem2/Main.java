package co.edu.sena.felipe.sem2;

public class Main {
    public static void main(String[] args) {
// System
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║  SABORES Y EVENTOS - Sistema Gestión Completo ║");
        System.out.println("║          Semana 02 - POO Avanzado             ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ========== CREAR GESTORA PRINCIPAL ==========
        GestoraEventos gestora = new GestoraEventos("Sabores y Eventos");
        System.out.println("✓ Sistema inicializado correctamente\n");

        // ========== PARTE 1: REGISTRAR CLIENTES ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 1: REGISTRO DE CLIENTES");
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
                "Empresa Tech Solutions S.A.S.",
                "6012345678",
                "eventos@techsolutions.com",
                "Corporativo"
        );

        Cliente cliente3 = new Cliente(
                "CLI-003",
                "Carlos Andrés Ramírez",
                "3209876543",
                "carlos.ramirez@gmail.com"
        );

        gestora.agregarCliente(cliente1);
        gestora.agregarCliente(cliente2);
        gestora.agregarCliente(cliente3);

        System.out.println();

        // ========== PARTE 2: CREAR CATÁLOGO DE SERVICIOS ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 2: CATÁLOGO DE SERVICIOS");
        System.out.println("═══════════════════════════════════════════════════\n");

        Servicio servicio1 = new Servicio(
                "SRV-001",
                "Fotografía Profesional",
                "Entretenimiento",
                800000,
                "Sesión completa de 8 horas con álbum digital"
        );

        Servicio servicio2 = new Servicio(
                "SRV-002",
                "DJ y Sonido",
                "Entretenimiento",
                1200000,
                "Música en vivo, iluminación y efectos especiales"
        );

        Servicio servicio3 = new Servicio(
                "SRV-003",
                "Decoración Floral Premium",
                "Decoración",
                1500000,
                "Arreglos florales elegantes para evento completo"
        );

        Servicio servicio4 = new Servicio(
                "SRV-004",
                "Bartender Especializado",
                "Personal",
                600000,
                "Servicio de coctelería profesional"
        );

        Servicio servicio5 = new Servicio(
                "SRV-005",
                "Video y Drone",
                "Entretenimiento",
                1000000,
                "Grabación aérea y edición profesional"
        );

        gestora.agregarServicioACatalogo(servicio1);
        gestora.agregarServicioACatalogo(servicio2);
        gestora.agregarServicioACatalogo(servicio3);
        gestora.agregarServicioACatalogo(servicio4);
        gestora.agregarServicioACatalogo(servicio5);

        System.out.println();
        gestora.mostrarCatalogoServicios();

        // ========== PARTE 3: CREAR EVENTOS BASE ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 3: CREAR EVENTOS BASE");
        System.out.println("═══════════════════════════════════════════════════\n");

        CateringEvent evento1 = new CateringEvent(
                "EVT-001",
                "Boda",
                150,
                "2024-12-20",
                "Hacienda Santa Bárbara",
                "Premium",
                cliente1
        );

        CateringEvent evento2 = new CateringEvent(
                "EVT-002",
                "Evento Corporativo",
                200,
                "2025-01-15",
                "Centro de Convenciones",
                "Estándar",
                cliente2
        );

        CateringEvent evento3 = new CateringEvent(
                "EVT-003",
                "Cumpleaños",
                80,
                "2025-02-10",
                "Salón de Eventos La Esperanza",
                "Básico"
        );

        System.out.println("✓ 3 eventos base creados\n");

        // ========== PARTE 4: CREAR PAQUETES CON SERVICIOS ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 4: CREAR PAQUETES COMPLETOS");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Paquete 1: Boda Premium (con múltiples servicios)
        PaqueteEvento paquete1 = new PaqueteEvento("PKG-001", evento1);
        paquete1.agregarServicio(servicio1);  // Fotografía
        paquete1.agregarServicio(servicio2);  // DJ
        paquete1.agregarServicio(servicio3);  // Decoración
        paquete1.agregarServicio(servicio5);  // Video
        paquete1.cambiarEstado("Confirmado");

        gestora.agregarPaquete(paquete1);
        System.out.println();

        // Paquete 2: Evento Corporativo
        PaqueteEvento paquete2 = new PaqueteEvento("PKG-002", evento2, 0.05);
        paquete2.agregarServicio(servicio2);  // DJ
        paquete2.agregarServicio(servicio5);  // Video
        paquete2.cambiarEstado("Confirmado");

        gestora.agregarPaquete(paquete2);
        System.out.println();

        // Paquete 3: Cumpleaños Simple
        PaqueteEvento paquete3 = new PaqueteEvento("PKG-003", evento3);
        paquete3.agregarServicio(servicio1);  // Solo fotografía
        paquete3.cambiarEstado("Cotizado");

        gestora.agregarPaquete(paquete3);
        System.out.println();

        // ========== PARTE 5: MOSTRAR DETALLES DE PAQUETES ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 5: DETALLE DE PAQUETES");
        System.out.println("═══════════════════════════════════════════════════");

        paquete1.mostrarDetallePaquete();
        paquete2.mostrarDetallePaquete();
        paquete3.mostrarDetallePaquete();

        // ========== PARTE 6: OPERACIONES CON ARRAYLIST ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 6: OPERACIONES CON ARRAYLIST");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Mostrar todos los paquetes
        gestora.mostrarTodosPaquetes();

        // Mostrar todos los clientes
        gestora.mostrarTodosClientes();

        // Buscar un paquete específico
        System.out.println("🔍 Buscando paquete PKG-001...");
        PaqueteEvento paqueteEncontrado = gestora.buscarPaquete("PKG-001");
        if (paqueteEncontrado != null) {
            System.out.println("✓ Paquete encontrado: " + paqueteEncontrado.getIdPaquete());
            System.out.println("  Evento: " + paqueteEncontrado.getEvento().getEventType());
        }
        System.out.println();

        // Buscar servicios por categoría
        System.out.println("🔍 Buscando servicios de 'Entretenimiento'...");
        var serviciosEntretenimiento = gestora.buscarServiciosPorCategoria("Entretenimiento");
        System.out.println("✓ Encontrados " + serviciosEntretenimiento.size() + " servicios:");
        for (Servicio s : serviciosEntretenimiento) {
            System.out.println("  • " + s.getNombreServicio());
        }
        System.out.println();

        // Listar servicios de un paquete
        System.out.println("📋 Servicios del paquete PKG-001:");
        paquete1.listarServicios();
        System.out.println();

        // Eliminar un servicio de un paquete
        System.out.println("🗑️ Eliminando servicio SRV-005 del paquete PKG-001...");
        paquete1.eliminarServicio("SRV-005");
        paquete1.listarServicios();
        System.out.println();

        // ========== PARTE 7: CONTRATAR MÁS EVENTOS PARA DESCUENTOS ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 7: SISTEMA DE FIDELIZACIÓN");
        System.out.println("═══════════════════════════════════════════════════\n");

        System.out.println("Cliente 1 contrata eventos adicionales:");
        cliente1.contratarEvento();
        cliente1.contratarEvento();
        cliente1.contratarEvento();
        cliente1.contratarEvento();
        System.out.println();

        // Crear nuevo evento con el descuento del cliente
        CateringEvent evento4 = new CateringEvent(
                "EVT-004",
                "Aniversario",
                100,
                "2025-03-20",
                "Restaurante El Mirador",
                "Premium",
                cliente1
        );

        PaqueteEvento paquete4 = new PaqueteEvento("PKG-004", evento4);
        paquete4.agregarServicio(servicio1);
        paquete4.agregarServicio(servicio3);
        paquete4.cambiarEstado("Confirmado");

        gestora.agregarPaquete(paquete4);

        System.out.println("\nPaquete con descuento de cliente frecuente:");
        paquete4.mostrarDetallePaquete();

        // ========== PARTE 8: INFORMACIÓN DE CLIENTES ==========
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 8: INFORMACIÓN DE CLIENTES");
        System.out.println("═══════════════════════════════════════════════════\n");
        cliente1.mostrarDatos();
        System.out.println();
        cliente2.mostrarDatos();
        System.out.println();
    }
}