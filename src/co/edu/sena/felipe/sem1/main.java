package co.edu.sena.felipe.sem1;

public class main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║     SABORES Y EVENTOS - Actividad 4            ║");
        System.out.println("║     Múltiples Objetos de Catering             ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();

        CateringEvent evento1 = new CateringEvent("CAT-001", "Boda", 150);
        CateringEvent evento2 = new CateringEvent("CAT-002", "Evento Corporativo", 80);
        CateringEvent evento3 = new CateringEvent("CAT-003", "Cumpleaños", 50);
        CateringEvent evento4 = new CateringEvent("CAT-004", "Conferencia", 200);
        CateringEvent evento5 = new CateringEvent("CAT-005", "Coctel de Lanzamiento", 120);
        CateringEvent evento6 = new CateringEvent("CAT-006", "Primera Comunión", 70);
        CateringEvent evento7 = new CateringEvent("CAT-007", "Graduación", 180);
        CateringEvent evento8 = new CateringEvent("CAT-008", "Baby Shower", 45);

        System.out.println("EVENTO 1:");
        evento1.showInfo();

        System.out.println("EVENTO 2:");
        evento2.showInfo();

        System.out.println("EVENTO 3:");
        evento3.showInfo();

        System.out.println("EVENTO 4:");
        evento4.showInfo();

        System.out.println("EVENTO 5:");
        evento5.showInfo();

        System.out.println("EVENTO 6:");
        evento6.showInfo();

        System.out.println("EVENTO 7:");
        evento7.showInfo();

        System.out.println("EVENTO 8:");
        evento8.showInfo();

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              RESUMEN EJECUTIVO                 ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Total de eventos creados: 8");
        System.out.println("Actividad 4 completada exitosamente");
        System.out.println();
    }
}