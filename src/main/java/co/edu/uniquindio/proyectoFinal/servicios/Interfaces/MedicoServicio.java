package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.*;

import java.util.List;

public interface MedicoServicio {

    List<CitaMedicoDTO> listarCitasPendientes()throws Exception;
    void atenderCita(AtencionCitaMedicoDTO atencionCitaMedicoDTO) throws Exception;
    List<HistorialCitasMedicoDTO> listarHistorialCitas()throws Exception;
    void agendarDiaLibre(DiaLibreMedicoDTO diaLibreDTO) throws Exception;
    List<CitasHoyMedicoDTO> listarCitasRealizadas()throws Exception;

}
