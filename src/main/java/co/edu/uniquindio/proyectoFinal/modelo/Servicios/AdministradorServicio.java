package co.edu.uniquindio.proyectoFinal.modelo.Servicios;

import co.edu.uniquindio.proyectoFinal.DTO.*;

import java.util.List;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;

public interface AdministradorServicio {

    void crearMedico(MedicoDTO medicoDTO) throws Exception;
    int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO)throws Exception;
    String eliminarMedico(int codigoMedico) throws Exception;
    List<InforMedicoAdminDTO> listarMedico();
    void obtenerMedico(int codigo);
    List<PQRSAdminDTO> listarPQRS();
    void responderPQRS(RespuestaPQRSDTO respuesta) throws Exception;
    DetallerPQRSAdministradorDTO verDetallePQRS(int codigo);
    void listarCitas();

}
