package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.DiaLibre;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MedicoServicio {

    List<CitaMedicoDTO> listarCitasPendientes()throws Exception;
    int atenderCita(AtencionCitaMedicoDTO atencionCitaMedicoDTO) throws Exception;
    List<HistorialCitasMedicoDTO> listarHistorialCitas()throws Exception;
    DiaLibre agendarDiaLibre(LocalDate diaSeleccionado, int codMedico) throws Exception;
    List<CitasHoyMedicoDTO> listarCitasHoy()throws Exception;
    void posponerCita(PosponerCitaMedicoDTO posponerCitaMedicoDTO) throws Exception;

}
