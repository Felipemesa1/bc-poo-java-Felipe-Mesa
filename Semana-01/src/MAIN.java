public class MAIN {
    public static void main(String[] args) {
        // Crear 3 objetos de tipo CateringEvent
        CateringEvent event1 = new CateringEvent("CAT-001", "Boda", 120);
        CateringEvent event2 = new CateringEvent("CAT-002", "Cumpleaños", 50);
        CateringEvent event3 = new CateringEvent("CAT-003", "Evento Corporativo", 200);
        CateringEvent event4 = new CateringEvent("CAT-004", "Bautizo", 80);
        CateringEvent event5 = new CateringEvent("CAT-005", "Matrimonio", 130);
        CateringEvent event6 = new CateringEvent("CAT-006", "Despedida de Soltera", 45);
        CateringEvent event7 = new CateringEvent("CAT-007", "Baby Shower",90);
        CateringEvent event8 = new CateringEvent("CAT-008","Primera Comunion",55);
        CateringEvent event9 = new CateringEvent("CAT-009","Evento Deportivo", 75);
        CateringEvent event10 = new CateringEvent("CAT-010","Graduacion", 160);
        // Mostrar información de los eventos

        event1.showInfo();
        event2.showInfo();
        event3.showInfo();
        event4.showInfo();
        event5.showInfo();
        event6.showInfo();
        event7.showInfo();
        event8.showInfo();
        event9.showInfo();
        event10.showInfo();
    }
}
