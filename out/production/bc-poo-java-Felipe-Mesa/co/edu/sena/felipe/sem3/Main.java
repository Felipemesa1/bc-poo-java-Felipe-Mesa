package co.edu.sena.felipe.sem3;

/**
 * SEMANA 3: DEMOSTRACIÓN DE HERENCIA Y POLIMORFISMO
 * Main que muestra cómo funcionan las clases heredadas
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   SABORES Y EVENTOS - Semana 3                 ║");
        System.out.println("║   HERENCIA Y POLIMORFISMO                      ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ==================== PARTE 1: CREAR EVENTOS ESPECÍFICOS ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 1: CREACIÓN DE EVENTOS ESPECIALIZADOS");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Crear una BODA
        Boda boda1 = new Boda(
                "BOD-001",
                "Boda María & Carlos",
                180,
                "2025-06-15",
                "Hacienda Santa Bárbara",
                "María López & Carlos Ramírez",
                true,
                "Orquesta",
                true
        );

        // Crear un EVENTO CORPORATIVO
        EventoCorporativo corporativo1 = new EventoCorporativo(
                "CORP-001",
                "Lanzamiento Producto 2025",
                250,
                "2025-03-10",
                "Centro de Convenciones",
                "Tech Solutions S.A.S.",
                "Lanzamiento",
                true,
                false,
                6
        );

        // Crear un CUMPLEAÑOS
        Cumpleanos cumple1 = new Cumpleanos(
                "CUM-001",
                "Cumpleaños de Sofía",
                40,
                "2025-05-20",
                "Salón Infantil Arcoíris",
                "Sofía García",
                8,
                "Infantil",
                true,
                true
        );

        // Crear otro CUMPLEAÑOS (adulto)
        Cumpleanos cumple2 = new Cumpleanos(
                "CUM-002",
                "50 Años de Alberto",
                80,
                "2025-07-30",
                "Restaurante El Mirador",
                "Alberto Martínez",
                50
        );

        System.out.println("✓ 4 eventos especializados creados\n");

        // ==================== PARTE 2: MOSTRAR INFORMACIÓN (POLIMORFISMO) ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 2: DEMOSTRACIÓN DE POLIMORFISMO");
        System.out.println("═══════════════════════════════════════════════════\n");

        boda1.mostrarInformacionGeneral();
        corporativo1.mostrarInformacionGeneral();
        cumple1.mostrarInformacionGeneral();
        cumple2.mostrarInformacionGeneral();

        // ==================== PARTE 3: POLIMORFISMO CON ARRAY ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 3: ARRAY POLIMÓRFICO");
        System.out.println("═══════════════════════════════════════════════════\n");

        // Array que puede contener cualquier tipo de EventoBase
        EventoBase[] eventos = new EventoBase[4];
        eventos[0] = boda1;
        eventos[1] = corporativo1;
        eventos[2] = cumple1;
        eventos[3] = cumple2;

        System.out.println("📋 LISTADO DE TODOS LOS EVENTOS:");
        System.out.println("─────────────────────────────────────────────────");

        double costoTotalTodos = 0;

        for (int i = 0; i < eventos.length; i++) {
            EventoBase evento = eventos[i];
            System.out.println((i + 1) + ". " + evento.obtenerTipoEvento());
            System.out.println("   Código: " + evento.getCodigo());
            System.out.println("   Nombre: " + evento.getNombreEvento());
            System.out.println("   Invitados: " + evento.getNumeroInvitados());
            System.out.println("   Costo: $" + String.format("%,.0f", evento.getCostoBase()));
            System.out.println();

            costoTotalTodos += evento.getCostoBase();
        }

        System.out.println("─────────────────────────────────────────────────");
        System.out.println("💰 COSTO TOTAL DE TODOS LOS EVENTOS: $" +
                String.format("%,.0f", costoTotalTodos));
        System.out.println();

        // ==================== PARTE 4: COMPARACIÓN DE COSTOS ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 4: ANÁLISIS Y COMPARACIONES");
        System.out.println("═══════════════════════════════════════════════════\n");

        EventoBase eventoMasCaro = eventos[0];
        EventoBase eventoMasBarato = eventos[0];

        for (EventoBase evento : eventos) {
            if (evento.getCostoBase() > eventoMasCaro.getCostoBase()) {
                eventoMasCaro = evento;
            }
            if (evento.getCostoBase() < eventoMasBarato.getCostoBase()) {
                eventoMasBarato = evento;
            }
        }

        System.out.println("🏆 EVENTO MÁS COSTOSO:");
        System.out.println("   " + eventoMasCaro.obtenerTipoEvento());
        System.out.println("   " + eventoMasCaro.getNombreEvento());
        System.out.println("   $" + String.format("%,.0f", eventoMasCaro.getCostoBase()));
        System.out.println();

        System.out.println("💵 EVENTO MÁS ECONÓMICO:");
        System.out.println("   " + eventoMasBarato.obtenerTipoEvento());
        System.out.println("   " + eventoMasBarato.getNombreEvento());
        System.out.println("   $" + String.format("%,.0f", eventoMasBarato.getCostoBase()));
        System.out.println();

        // ==================== PARTE 5: INSTANCEOF (Verificar tipo) ====================
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     PARTE 5: IDENTIFICACIÓN DE TIPOS (instanceof)");
        System.out.println("═══════════════════════════════════════════════════\n");

        int contadorBodas = 0;
        int contadorCorporativos = 0;
        int contadorCumpleanos = 0;

        for (EventoBase evento : eventos) {
            if (evento instanceof Boda) {
                contadorBodas++;
                System.out.println("💍 " + evento.getNombreEvento() + " es una BODA");
            } else if (evento instanceof EventoCorporativo) {
                contadorCorporativos++;
                System.out.println("🏢 " + evento.getNombreEvento() + " es CORPORATIVO");
            } else if (evento instanceof Cumpleanos) {
                contadorCumpleanos++;
                System.out.println("🎂 " + evento.getNombreEvento() + " es un CUMPLEAÑOS");
            }
        }

        System.out.println("\n📊 RESUMEN POR TIPO:");
        System.out.println("   Bodas: " + contadorBodas);
        System.out.println("   Eventos Corporativos: " + contadorCorporativos);
        System.out.println("   Cumpleaños: " + contadorCumpleanos);
        System.out.println();

        // ==================== RESUMEN FINAL ====================
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           RESUMEN SEMANA 3                     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("✓ Herencia implementada correctamente");
        System.out.println("✓ Polimorfismo demostrado con éxito");
        System.out.println("✓ 4 eventos especializados funcionando");
        System.out.println("✓ Cálculos específicos por tipo de evento");
        System.out.println("\n✅ Semana 3 completada exitosamente\n");
    }
}