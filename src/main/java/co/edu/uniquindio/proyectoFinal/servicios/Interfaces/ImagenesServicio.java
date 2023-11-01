package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import java.lang.reflect.Executable;

public interface ImagenesServicio {
    void subirImagen(String url) throws Exception;
    void eliminarImagen(String url)throws Exception;
}
