package co.edu.uniquindio.proyectoFinal.servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medico) throws Exception;
    int actualizarMedico(DetalleMedicoAdminDTO detalleMedicoAdminDTOd)throws Exception;
    void eliminarMedico(int codigoMedico) throws Exception;
    List<InforMedicoAdminDTO> listarMedico() throws Exception;
    DetalleMedicoAdminDTO obtenerMedico(int codigo) throws Exception;
    List<PQRSAdminDTO> listarPQRS();
    int responderPQRS(RespuestaPQRSDTO respuesta) throws Exception;
    DetallerPQRSAdminDTO verDetallePQRS(int codigo) throws Exception;
    void cambiarEstadoPQRS (int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;
    List<CitaAdminDTO> listarCitas() throws Exception;

}
