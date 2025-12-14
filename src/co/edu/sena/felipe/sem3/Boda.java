package co.edu.sena.felipe.sem3;

/**
 * CLASE HIJA: Boda
 * Hereda de EventoBase y añade características específicas
 */
public class Boda extends EventoBase {
    // ATRIBUTOS ESPECÍFICOS DE BODA
    private String nombreNovios;
    private boolean incluyeLunaRegalos;
    private String tipoMusica; // "Orquesta", "DJ", "Banda"
    private boolean ceremoniaCivil;

    // CONSTRUCTOR
    public Boda(String codigo, String nombreEvento, int numeroInvitados,
                String fecha, String ubicacion, String nombreNovios) {
        super(codigo, nombreEvento, numeroInvitados, fecha, ubicacion);
        this.nombreNovios = nombreNovios;
        this.incluyeLunaRegalos = true;
        this.tipoMusica = "Orquesta";
        this.ceremoniaCivil = false;
        this.costoBase = calcularCostoBase(); // Recalcular
    }

    // Constructor completo
    public Boda(String codigo, String nombreEvento, int numeroInvitados,
                String fecha, String ubicacion, String nombreNovios,
                boolean incluyeLunaRegalos, String tipoMusica, boolean ceremoniaCivil) {
        super(codigo, nombreEvento, numeroInvitados, fecha, ubicacion);
        this.nombreNovios = nombreNovios;
        this.incluyeLunaRegalos = incluyeLunaRegalos;
        this.tipoMusica = tipoMusica;
        this.ceremoniaCivil = ceremoniaCivil;
        this.costoBase = calcularCostoBase(); // Recalcular
    }

    // SOBRESCRITURA (OVERRIDE): Cambiar el cálculo del costo base
    @Override
    public double calcularCostoBase() {
        // Las bodas son más costosas: $65,000 por persona
        double costo = numeroInvitados * 65000;

        // Agregar extras
        if (incluyeLunaRegalos) {
            costo += 500000; // Costo de luna de regalos
        }

        if (ceremoniaCivil) {
            costo += 800000; // Costo de ceremonia civil
        }

        // Costo por tipo de música
        switch (tipoMusica) {
            case "Orquesta":
                costo += 2500000;
                break;
            case "DJ":
                costo += 1200000;
                break;
            case "Banda":
                costo += 1800000;
                break;
        }

        return costo;
    }

    // SOBRESCRITURA: Cambiar el tipo de evento
    @Override
    public String obtenerTipoEvento() {
        return "BODA 💍";
    }

    // SOBRESCRITURA: Mostrar detalles específicos de boda
    @Override
    public void mostrarDetallesEspecificos() {
        System.out.println("--- DETALLES DE LA BODA ---");
        System.out.println("👰🤵 Novios: " + nombreNovios);
        System.out.println("🎁 Luna de Regalos: " + (incluyeLunaRegalos ? "SÍ" : "NO"));
        System.out.println("🎵 Tipo de Música: " + tipoMusica);
        System.out.println("📋 Ceremonia Civil: " + (ceremoniaCivil ? "SÍ" : "NO"));
        System.out.println("💰 Costo Total: $" + String.format("%,.0f", calcularCostoBase()));
    }

    // GETTERS Y SETTERS ESPECÍFICOS
    public String getNombreNovios() { return nombreNovios; }
    public void setNombreNovios(String nombreNovios) { this.nombreNovios = nombreNovios; }

    public boolean isIncluyeLunaRegalos() { return incluyeLunaRegalos; }
    public void setIncluyeLunaRegalos(boolean incluyeLunaRegalos) {
        this.incluyeLunaRegalos = incluyeLunaRegalos;
    }

    public String getTipoMusica() { return tipoMusica; }
    public void setTipoMusica(String tipoMusica) { this.tipoMusica = tipoMusica; }

    public boolean isCeremoniaCivil() { return ceremoniaCivil; }
    public void setCeremoniaCivil(boolean ceremoniaCivil) {
        this.ceremoniaCivil = ceremoniaCivil;
    }
}