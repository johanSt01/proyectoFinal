package co.edu.uniquindio.proyectoFinal.modelo.Servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Servicios.AdministradorServicio;
import co.edu.uniquindio.proyectoFinal.repositorios.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor //crea el constructor de todos los metodos
public class AdministradorServicioImpl implements AdministradorServicio {

    //@Autowired //intancia del objeto
    private final MedicoRepository medicoRepository;

    @Override
    public int crearMedico(MedicoDTO medico) throws Exception {
        return 0;
    }

    @Override
    public int actualizarMedico(int codigoMedico, MedicoDTO medicoDTO) throws Exception {
        return 0;
    }

    @Override
    public String eliminarMedico(int codigoMedico) throws Exception {
        return null;
    }

    @Override
    public List<InforMedicoAdminDTO> listarMedico() {
        return null;
    }

    @Override
    public void obtenerMedico(int codigo) {

    }

    @Override
    public List<PQRSAdminDTO> listarPQRS() {
        return null;
    }

    @Override
    public void responderPQRS(RespuestaPQRSDTO respuesta) throws Exception {

    }

    @Override
    public DetallerPQRSAdministradorDTO verDetallePQRS(int codigo) {
        return null;
    }

    @Override
    public void listarCitas() {

    }
}
