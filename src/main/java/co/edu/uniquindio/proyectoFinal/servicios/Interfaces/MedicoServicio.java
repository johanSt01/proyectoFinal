package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.AtencionCitaMedicoDTO;
import co.edu.uniquindio.proyectoFinal.DTO.CitaMedicoDTO;
import co.edu.uniquindio.proyectoFinal.DTO.DiaLibreMedicoDTO;
import co.edu.uniquindio.proyectoFinal.DTO.historialCitasMedico;

import java.util.List;

public interface MedicoServicio {

    List<CitaMedicoDTO> listarCitasPendientes(int codigo)throws Exception;
    void atenderCita(AtencionCitaMedicoDTO atencionCitaMedicoDTO) throws Exception;
    List<historialCitasMedico> listarCitasMedicas(int codigoPaciente);
    void agendarDiaLibre(DiaLibreMedicoDTO diaLibreDTO) throws Exception;
    List<CitaMedicoDTO> listarCitasRealizadas();

}
