package co.edu.uniquindio.proyectoFinal.modelo.Servicios.Interfaces;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medico) throws Exception;
    int actualizarMedico(DetalleMedicoAdminDTO detalleMedicoAdminDTOd)throws Exception;
    void eliminarMedico(int codigoMedico) throws Exception;
    List<InforMedicoAdminDTO> listarMedico();
    void obtenerMedico(int codigo);
    List<PQRSAdminDTO> listarPQRS();
    void responderPQRS(RespuestaPQRSDTO respuesta) throws Exception;
    DetallerPQRSAdministradorDTO verDetallePQRS(int codigo);
    void listarCitas();

}
