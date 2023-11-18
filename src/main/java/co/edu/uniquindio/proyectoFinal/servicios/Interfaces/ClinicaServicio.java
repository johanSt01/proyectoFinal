package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.InforMedicoAdminDTO;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EPS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.TipoSangre;

import java.util.List;

public interface ClinicaServicio {
    List<Ciudad> listarCiudades() throws Exception;
    List<EPS> listarEPS() throws Exception;
    List<TipoSangre> listarTipoSangre() throws Exception;
    List<Especialidad> listarEspecialidades() throws Exception;
}
