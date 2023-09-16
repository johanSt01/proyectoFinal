package co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones;

public enum EstadoPQRS {
    enEspera("PQRS en espera"),
    enviado("PQRS enviada"),
    cancelado("PQRS cancelada"),
    terminado("PQRS terminada");


    private String nombre;

    private EstadoPQRS (String nombre){}
}
