//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class CateringEvent {
    String eventCode;
    String eventType;
    int guestCount;

    public CateringEvent(String eventCode, String eventType, int guestCount) {
        this.eventCode = eventCode;
        this.eventType = eventType;
        this.guestCount = guestCount;
    }

    public void showInfo() {
        System.out.println("==================================");
        System.out.println("Código del Evento: " + this.eventCode);
        System.out.println("Tipo de Evento: " + this.eventType);
        System.out.println("Número de Invitados: " + this.guestCount);
        System.out.println("==================================");
    }
}
