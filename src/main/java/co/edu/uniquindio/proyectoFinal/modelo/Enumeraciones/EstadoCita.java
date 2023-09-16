package co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones;

public enum EstadoCita {

    Activo("Cita Activo"),
    EnEspera("Cita En Espera"),
    Terminado("Cita Terminada");

    private String nombre;

    private EstadoCita (String nombre){}
}
