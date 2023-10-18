package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.PQRS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoUsuario;
import co.edu.uniquindio.proyectoFinal.repositorios.CitaRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.CuentaRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.MedicoRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.PQRSRepository;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //crea el constructor de todos los metodos
public class AdministradorServicioImpl implements AdministradorServicio {

    //@Autowired //intancia del objeto
    private final MedicoRepository medicoRepo;
    private final PQRSRepository pqrsRepo;
    private final MedicoRepository mensajeRepo;
    private final CuentaRepository cuentaRepo;
    private final CitaRepository citaRepo;

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
        medico.setHoraInicio( medicoDTO.horaInicio());
        medico.setHoraFin( medicoDTO.horaFin());
        medico.setCiudad(medicoDTO.ciudad());
        medico.setCorreo(medicoDTO.correo() );
        medico.setContrasenia(medicoDTO.contrasenia());
        medico.setURLfoto(medicoDTO.URLfoto());
        medico.setEstadoUsuario(EstadoUsuario.Activo);

        Medico medicoNuevo = medicoRepo.save(medico);

        return medicoNuevo.getCodigo();
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
    public List<InforMedicoAdminDTO> listarMedico() throws Exception {
        List<Medico> medicos = medicoRepo.findAll();

        if(medicos.isEmpty()){
            throw new Exception("No hay médicos registrados");
        }

        List<InforMedicoAdminDTO> respuesta = new ArrayList<>();

        for(Medico m: medicos ){
            respuesta.add( new InforMedicoAdminDTO(
                    m.getNombre(),
                    m.getCedula(),
                    m.getTelefono(),
                    m.getEspecialidad()) );
        }

        return respuesta;
    }

    @Override
    public DetalleMedicoAdminDTO obtenerMedico(int codigo) throws Exception {

        Optional<Medico> opcional = medicoRepo.findById(codigo);

        if( opcional.isEmpty()){
            throw new Exception(" No existe un medico con el código" + codigo);
        }

        Medico buscado = opcional.get();

        return new DetalleMedicoAdminDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getHoraInicio(),
                buscado.getHoraFin(),
                buscado.getTelefono(),
                buscado.getCorreo(),
                buscado.getURLfoto());
    }

    @Override
    public List<PQRSAdminDTO> listarPQRS() {
        List<PQRS> listaPqrs = pqrsRepo.findAll();
        List<PQRSAdminDTO> respuesta = new ArrayList<>();

        for(PQRS p : listaPqrs){
            respuesta.add(new PQRSAdminDTO(
                p.getCodigoCita().getCedulaPaciente().getNombre(),
                p.getCodigoCita().getCedulaPaciente().getCedula(),
                p.getCodigoCita().getMotivo(),
                p.getEstado()
            ));
        }

        return respuesta;
    }

    @Override
    public int responderPQRS(RespuestaPQRSDTO ResgistroRespuesta) throws Exception {

        /*Optional<PQRS> opcionalPQRS = pqrsRepo.findById(ResgistroRespuesta.codigoPQRS());

        if(opcionalPQRS.isEmpty()){
            throw new Exception("No existe un pqrs con el código: " + ResgistroRespuesta.codigoPQRS());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(ResgistroRespuesta.codigoUsuario());

        if(opcionalCuenta.isEmpty()){
            throw new Exception("No existe un usuario con el código: " +ResgistroRespuesta.codigoUsuario());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setCodigo_pqrs(opcionalPQRS.get());
        mensajeNuevo.setFechaCreacion(LocalDateTime.now());
        mensajeNuevo.setCodigo_cuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(ResgistroRespuesta.mensaje());

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();*/

        return 0;
    }

    @Override
    public DetallerPQRSAdminDTO verDetallePQRS(int codigo) throws Exception {

        /*Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception("No existe una pqrs con el código" + codigo);
        }

        PQRS buscado = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByCodigo_pqrsCodigo(codigo);

        *//*return new DetallerPQRSAdminDTO(

        );*/
        return null;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigoPQRS);

        if(opcional.isEmpty()){
            throw new Exception("No se encontro una PQRS con el código: "+codigoPQRS);
        }

        PQRS pqrs = opcional.get();
        pqrs.setEstado( estadoPQRS );

        pqrsRepo.save(pqrs);
    }



    @Override
    public List<CitaAdminDTO> listarCitas() throws Exception {
        List<Cita> citas = citaRepo.findAll();
        List<CitaAdminDTO> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas){
            respuesta.add(new CitaAdminDTO(
                    c.getCodigoMedico().getNombre(),
                    c.getFechaCita(),
                    c.getCedulaPaciente().getNombre()
            ));
        }
        return respuesta;
    }
}
