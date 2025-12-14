package co.edu.sena.felipe.sem4;

public interface Personalizable {
    void personalizarConCliente(String nombreCliente);
    String obtenerPersonalizacion();
}

interface Reservable {
    boolean verificarDisponibilidad(String fecha);
    void reservar(String fecha, String cliente);
    void cancelarReserva();
}

interface Calificable {
    void agregarCalificacion(int estrellas);
    double obtenerPromedioCalificaciones();
    int getCantidadCalificaciones();
}