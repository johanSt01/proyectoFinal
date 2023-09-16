package co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones;

public enum TipoSangre {
    Apositivo("Sangre A+"),
    Anegativo("Sangre A-"),
    Bpositivo("Sangre B+"),
    Bnegativo("Sangre B-"),
    ABpositivos("Sangre AB+"),
    ABnegativos("Sangre AB-");

    private String nombre;

    private TipoSangre (String nombre){}
}
