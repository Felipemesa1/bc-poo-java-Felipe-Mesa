package co.edu.sena.felipe.sem4;

/**
 * Servicio de Decoración que solo implementa Personalizable
 */
public class ServicioDecoracion extends ServicioAdicional implements Personalizable {

    private String tipoDecoracion; // "Floral", "Temática", "Minimalista", "Elegante"
    private int metrosCuadrados;
    private String personalizacion;

    public ServicioDecoracion(String idServicio, String tipoDecoracion, int metrosCuadrados) {
        super(idServicio, "Decoración " + tipoDecoracion, 150000);
        this.tipoDecoracion = tipoDecoracion;
        this.metrosCuadrados = metrosCuadrados;
        this.personalizacion = "";
    }

    @Override
    public double calcularCosto() {
        double costoPorMetro = 0;

        switch (tipoDecoracion) {
            case "Floral":
                costoPorMetro = 50000;
                break;
            case "Temática":
                costoPorMetro = 35000;
                break;
            case "Minimalista":
                costoPorMetro = 25000;
                break;
            case "Elegante":
                costoPorMetro = 60000;
                break;
            default:
                costoPorMetro = 30000;
        }

        return precioBase + (costoPorMetro * metrosCuadrados);
    }

    @Override
    public String obtenerDescripcion() {
        return "Decoración " + tipoDecoracion + " para " + metrosCuadrados + " m²";
    }

    @Override
    public String getCategoria() {
        return "Decoración y Ambientación";
    }

    // IMPLEMENTACIÓN DE INTERFAZ: Personalizable

    public void personalizarConCliente(String nombreCliente) {
        this.personalizacion = "Decoración personalizada con iniciales de " + nombreCliente;
        System.out.println("✓ Decoración personalizada creada");
    }

    public String obtenerPersonalizacion() {
        return personalizacion.isEmpty() ? "Sin personalización" : personalizacion;
    }

    // GETTERS
    public String getTipoDecoracion() { return tipoDecoracion; }
    public int getMetrosCuadrados() { return metrosCuadrados; }
}