package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoUsuario;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyectoFinal.repositorios.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //crea el constructor de todos los metodos
public class AdministradorServicioImpl implements AdministradorServicio {

    //@Autowired //intancia del objeto
    private final MedicoRepository medicoRepo;

    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception {
        if( estaRepetidaCedula(medicoDTO.cedula()) ){
            throw new Exception("La cédula "+medicoDTO.cedula()+" ya está en uso");
        }

        if( estaRepetidoCorreo(medicoDTO.correo()) ){
            throw new Exception("El correo "+medicoDTO.cedula()+" ya está en uso");
        }

        Medico medico = new Medico();
        medico.setCedula(medicoDTO.cedula() );
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre() );
        medico.setEspecialidad( medicoDTO.especialidad() );
        medico.setCiudad(medicoDTO.ciudad());
        medico.setCorreo(medicoDTO.correo() );
        medico.setContrasenia(medicoDTO.contrasenia());
        medico.setURLfoto(medicoDTO.URLfoto());
        medico.setEstadoUsuario(EstadoUsuario.Activo);

        Medico medicoNuevo = medicoRepo.save(medico);

        asignarHorariosMedico( medicoNuevo, medicoDTO.horario() );

        return medicoNuevo.getCodigo();
    }

    private void asignarHorariosMedico(Medico medicoNuevo, List<HorarioDTO> horarios) {
        //falta por cuadrar
    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findByCorreo(correo) != null;
    }

    private boolean estaRepetidaCedula(String cedula) {
        return medicoRepo.findByCedula(cedula) != null;
    }

    @Override
    public int actualizarMedico(DetalleMedicoAdminDTO medicoDTO) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(medicoDTO.codigo());

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        buscado.setCedula(medicoDTO.cedula() );
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setNombre(medicoDTO.nombre() );
        buscado.setEspecialidad( medicoDTO.especialidad() );
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setCorreo(medicoDTO.correo() );
        buscado.setURLfoto(medicoDTO.urlFoto());

        medicoRepo.save( buscado );

        return buscado.getCodigo();
    }
    @Override
    public void eliminarMedico(int codigoMedico) throws Exception {

        Optional<Medico> opcional =medicoRepo.findById(codigoMedico);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+codigoMedico);
        }

        Medico buscado = opcional.get();
        buscado.setEstadoUsuario(EstadoUsuario.Inactivo);
        medicoRepo.save( buscado );

        //medicoRepo.delete(buscado);

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
