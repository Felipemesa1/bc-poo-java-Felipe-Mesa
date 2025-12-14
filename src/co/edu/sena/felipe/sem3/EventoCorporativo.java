package co.edu.sena.felipe.sem3;

/**
 * CLASE HIJA: EventoCorporativo
 * Hereda de EventoBase
 */
public class EventoCorporativo extends EventoBase {
    // ATRIBUTOS ESPECÍFICOS
    private String nombreEmpresa;
    private String tipoEvento; // "Conferencia", "Capacitación", "Lanzamiento"
    private boolean requiereEquipoAudiovisual;
    private boolean incluyeHospedaje;
    private int horasEvento;

    // CONSTRUCTOR
    public EventoCorporativo(String codigo, String nombreEvento, int numeroInvitados,
                             String fecha, String ubicacion, String nombreEmpresa,
                             String tipoEvento) {
        super(codigo, nombreEvento, numeroInvitados, fecha, ubicacion);
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEvento = tipoEvento;
        this.requiereEquipoAudiovisual = true;
        this.incluyeHospedaje = false;
        this.horasEvento = 4;
        this.costoBase = calcularCostoBase(); // Recalcular
    }

    // Constructor completo
    public EventoCorporativo(String codigo, String nombreEvento, int numeroInvitados,
                             String fecha, String ubicacion, String nombreEmpresa,
                             String tipoEvento, boolean requiereEquipoAudiovisual,
                             boolean incluyeHospedaje, int horasEvento) {
        super(codigo, nombreEvento, numeroInvitados, fecha, ubicacion);
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEvento = tipoEvento;
        this.requiereEquipoAudiovisual = requiereEquipoAudiovisual;
        this.incluyeHospedaje = incluyeHospedaje;
        this.horasEvento = horasEvento;
        this.costoBase = calcularCostoBase(); // Recalcular
    }

    // SOBRESCRITURA: Cálculo específico para eventos corporativos
    @Override
    public double calcularCostoBase() {
        // Eventos corporativos: $45,000 por persona
        double costo = numeroInvitados * 45000;

        // Costo por tipo de evento corporativo
        switch (tipoEvento) {
            case "Conferencia":
                costo += 1500000; // Salón, pantallas, etc.
                break;
            case "Capacitación":
                costo += 2000000; // Materiales didácticos
                break;
            case "Lanzamiento":
                costo += 3000000; // Marketing y decoración premium
                break;
        }

        // Equipos audiovisuales
        if (requiereEquipoAudiovisual) {
            costo += 800000;
        }

        // Hospedaje
        if (incluyeHospedaje) {
            costo += numeroInvitados * 150000; // Por persona
        }

        // Costo por hora adicional (después de 4 horas base)
        if (horasEvento > 4) {
            costo += (horasEvento - 4) * 300000;
        }

        return costo;
    }

    @Override
    public String obtenerTipoEvento() {
        return "EVENTO CORPORATIVO 🏢";
    }

    @Override
    public void mostrarDetallesEspecificos() {
        System.out.println("--- DETALLES DEL EVENTO CORPORATIVO ---");
        System.out.println("🏢 Empresa: " + nombreEmpresa);
        System.out.println("📊 Tipo: " + tipoEvento);
        System.out.println("🎥 Equipo Audiovisual: " + (requiereEquipoAudiovisual ? "SÍ" : "NO"));
        System.out.println("🏨 Hospedaje: " + (incluyeHospedaje ? "SÍ" : "NO"));
        System.out.println("⏰ Duración: " + horasEvento + " horas");
        System.out.println("💰 Costo Total: $" + String.format("%,.0f", calcularCostoBase()));
    }

    // GETTERS Y SETTERS
    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }

    public boolean isRequiereEquipoAudiovisual() { return requiereEquipoAudiovisual; }
    public void setRequiereEquipoAudiovisual(boolean requiereEquipoAudiovisual) {
        this.requiereEquipoAudiovisual = requiereEquipoAudiovisual;
    }

    public boolean isIncluyeHospedaje() { return incluyeHospedaje; }
    public void setIncluyeHospedaje(boolean incluyeHospedaje) {
        this.incluyeHospedaje = incluyeHospedaje;
    }

    public int getHorasEvento() { return horasEvento; }
    public void setHorasEvento(int horasEvento) { this.horasEvento = horasEvento; }
}