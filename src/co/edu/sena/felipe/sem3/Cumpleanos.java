package co.edu.sena.felipe.sem3;

/**
 * CLASE HIJA: Cumpleanos
 * Hereda de EventoBase
 */
public class Cumpleanos extends EventoBase {
    // ATRIBUTOS ESPECÍFICOS
    private String nombreCumpleanero;
    private int edad;
    private String tematica; // "Infantil", "Adolescente", "Adulto", "Sorpresa"
    private boolean incluyeTorta;
    private boolean incluyeAnimacion;

    // CONSTRUCTOR
    public Cumpleanos(String codigo, String nombreEvento, int numeroInvitados,
                      String fecha, String ubicacion, String nombreCumpleanero, int edad) {
        super(codigo, nombreEvento, numeroInvitados, fecha, ubicacion);
        this.nombreCumpleanero = nombreCumpleanero;
        this.edad = edad;
        this.tematica = asignarTematicaPorEdad(edad);
        this.incluyeTorta = true;
        this.incluyeAnimacion = (edad <= 12); // Animación solo para niños
        this.costoBase = calcularCostoBase(); // Recalcular
    }

    // Constructor completo
    public Cumpleanos(String codigo, String nombreEvento, int numeroInvitados,
                      String fecha, String ubicacion, String nombreCumpleanero,
                      int edad, String tematica, boolean incluyeTorta,
                      boolean incluyeAnimacion) {
        super(codigo, nombreEvento, numeroInvitados, fecha, ubicacion);
        this.nombreCumpleanero = nombreCumpleanero;
        this.edad = edad;
        this.tematica = tematica;
        this.incluyeTorta = incluyeTorta;
        this.incluyeAnimacion = incluyeAnimacion;
        this.costoBase = calcularCostoBase(); // Recalcular
    }

    // MÉTODO AUXILIAR
    private String asignarTematicaPorEdad(int edad) {
        if (edad <= 12) return "Infantil";
        else if (edad <= 17) return "Adolescente";
        else if (edad <= 50) return "Adulto";
        else return "Elegante";
    }

    // SOBRESCRITURA: Cálculo específico para cumpleaños
    @Override
    public double calcularCostoBase() {
        // Base según temática
        double costoPorPersona = 35000;

        if (tematica.equals("Infantil")) {
            costoPorPersona = 28000;
        } else if (tematica.equals("Elegante")) {
            costoPorPersona = 50000;
        }

        double costo = numeroInvitados * costoPorPersona;

        // Extras
        if (incluyeTorta) {
            if (edad <= 12) {
                costo += 250000; // Torta infantil temática
            } else {
                costo += 350000; // Torta adultos
            }
        }

        if (incluyeAnimacion) {
            costo += 600000; // Show infantil
        }

        return costo;
    }

    @Override
    public String obtenerTipoEvento() {
        return "CUMPLEAÑOS 🎂";
    }

    @Override
    public void mostrarDetallesEspecificos() {
        System.out.println("--- DETALLES DEL CUMPLEAÑOS ---");
        System.out.println("🎉 Cumpleañero: " + nombreCumpleanero);
        System.out.println("🎈 Edad: " + edad + " años");
        System.out.println("🎨 Temática: " + tematica);
        System.out.println("🎂 Incluye Torta: " + (incluyeTorta ? "SÍ" : "NO"));
        System.out.println("🤹 Animación: " + (incluyeAnimacion ? "SÍ" : "NO"));
        System.out.println("💰 Costo Total: $" + String.format("%,.0f", calcularCostoBase()));
    }

    // GETTERS Y SETTERS
    public String getNombreCumpleanero() { return nombreCumpleanero; }
    public void setNombreCumpleanero(String nombreCumpleanero) {
        this.nombreCumpleanero = nombreCumpleanero;
    }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getTematica() { return tematica; }
    public void setTematica(String tematica) { this.tematica = tematica; }

    public boolean isIncluyeTorta() { return incluyeTorta; }
    public void setIncluyeTorta(boolean incluyeTorta) { this.incluyeTorta = incluyeTorta; }

    public boolean isIncluyeAnimacion() { return incluyeAnimacion; }
    public void setIncluyeAnimacion(boolean incluyeAnimacion) {
        this.incluyeAnimacion = incluyeAnimacion;
    }
}