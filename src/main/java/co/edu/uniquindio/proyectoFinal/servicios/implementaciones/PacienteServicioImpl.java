package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.PQRS;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Paciente;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoUsuario;
import co.edu.uniquindio.proyectoFinal.repositorios.CitaRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.PQRSRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.PacienteRepository;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.PacienteServicio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final CitaRepository citaRepo;
    private final PacienteRepository pacienteRepo;
    private final PQRSRepository pqrsRepo;

    @Override
    public int registrarse(RegistroUsuarioDTO registroUsuarioDTO) throws Exception {
        if (estaRepetidocedula(registroUsuarioDTO.cedula())) {
            throw new Exception("La cédula " + registroUsuarioDTO.cedula() + " ya está en uso");
        }

        if (estaRepetidoEmail(registroUsuarioDTO.email())) {
            throw new Exception("El correo " + registroUsuarioDTO.email() + " ya está en uso");
        }

        Paciente paciente = crearPaciente(registroUsuarioDTO);
        Paciente pacienteNuevo = pacienteRepo.save(paciente);
        pacienteRepo.save(pacienteNuevo);

        System.out.println("paciente creado " + pacienteNuevo);
        return pacienteNuevo.getCodigo();
    }

    public Paciente crearPaciente(RegistroUsuarioDTO registroUsuarioDTO) {
        Paciente paciente = new Paciente();
        paciente.setCedula(registroUsuarioDTO.cedula());
        paciente.setFechaNacimiento(registroUsuarioDTO.fechaNacimiento());
        paciente.setTelefono(registroUsuarioDTO.telefono());
        paciente.setNombre(registroUsuarioDTO.nombre());
        paciente.setCiudad(registroUsuarioDTO.ciudad());
        paciente.setAlergias(registroUsuarioDTO.alergias());
        paciente.setCodigo_tipo_sangre(registroUsuarioDTO.tipoSangre());
        paciente.setCodigo_eps(registroUsuarioDTO.eps());
        paciente.setCorreo(registroUsuarioDTO.email());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( registroUsuarioDTO.contrasenia() );

        paciente.setContrasenia(passwordEncriptada);
        paciente.setURLfoto(registroUsuarioDTO.urlFoto());
        paciente.setEstadoUsuario(EstadoUsuario.Activo);

        return paciente;
    }

    private boolean estaRepetidocedula(String cedula) {

        return pacienteRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoEmail(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception {

        Optional<Paciente> paciente =pacienteRepo.findById(pacienteDTO.codigo());

        if( paciente.isEmpty() ){
            throw new Exception("No existe un médico con el código "+pacienteDTO.codigo());
        }

        Paciente buscado = actualizarPerfil(pacienteDTO);

        pacienteRepo.save( buscado );

        return buscado.getCodigo();
    }

    public Paciente actualizarPerfil(DetallePacienteDTO detallePacienteDTO){
        Paciente paciente = new Paciente();

        paciente.setCodigo(detallePacienteDTO.codigo());
        paciente.setNombre(detallePacienteDTO.nombre());
        paciente.setCedula(detallePacienteDTO.cedula());
        paciente.setFechaNacimiento(detallePacienteDTO.fechaNacimiento());
        paciente.setTelefono(detallePacienteDTO.telefono());
        paciente.setCiudad(detallePacienteDTO.ciudad());
        paciente.setCodigo_tipo_sangre(detallePacienteDTO.tipoSangre());
        paciente.setCodigo_eps(detallePacienteDTO.eps());
        paciente.setAlergias(detallePacienteDTO.alergias());
        paciente.setCorreo(detallePacienteDTO.email());

        return paciente;
    }

    @Override
    public DetallePacienteDTO detallePaciente(int codigo) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception(" No existe un paciente con el código" + codigo);
        }

        Paciente buscado = opcional.get();

        return new DetallePacienteDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getFechaNacimiento(),
                buscado.getTelefono(),
                buscado.getCiudad(),
                buscado.getCodigo_tipo_sangre(),
                buscado.getCodigo_eps(),
                buscado.getAlergias(),
                buscado.getCorreo());
    }

    @Override
    public void eliminarCuenta(int codigoCuenta) throws Exception {
        Optional<Paciente> opcional = pacienteRepo.findById(codigoCuenta);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un paciente con el código " + codigoCuenta);
        }

        Paciente buscado = opcional.get();
        buscado.setEstadoUsuario(EstadoUsuario.Inactivo);
        pacienteRepo.save(buscado);

        //pacienteRepo.delete(buscado);
    }

    @Override
    public String enviarLinkRecuperacion(EnviarCorreoPacienteDTO correoPacienteDTO) throws Exception {
        return null;
    }

    @Override
    public String cambiarPassword(ContraseniaPacienteDTO contraseniaPaciente) throws Exception {
        return null;
    }

    @Override
    public String agendarCita(AgendarCitaPacienteDTO agendarCita) throws Exception {
        if (citaRepo.findByCodigoMedicoCodigoAndFechaCitaAndHoraCita(agendarCita.medico().getCodigo(), agendarCita.fecha(), agendarCita.hora()) == null) {
            System.out.println("cita: " + citaRepo.findByCodigoMedicoCodigoAndFechaCitaAndHoraCita(agendarCita.medico().getCodigo(), agendarCita.fecha(), agendarCita.hora()));
            throw new Exception("ya existe una cita para esa fecha y con ese medico");

        }

        Cita cita = datosCita(agendarCita);
        Cita citaNueva = citaRepo.save(cita);
        return "cita creada" + citaNueva.getCodigo();
    }

    public static Cita datosCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) {
        Cita cita = new Cita();
        cita.setEspecialidad(agendarCitaPacienteDTO.especialidad());
        cita.setCodigoMedico(agendarCitaPacienteDTO.medico());
        cita.setFechaCita(agendarCitaPacienteDTO.fecha());
        cita.setHoraCita(agendarCitaPacienteDTO.hora());
        cita.setMotivo(agendarCitaPacienteDTO.motivoCita());
        return cita;
    }

    @Override
    public int crearPQRS(PQRSPacienteDTO pqrsPacienteDTO) throws Exception {
        Cita cita = citaRepo.findByCodigo(pqrsPacienteDTO.citaAsociada().getCodigo());

        if(cita==null){
            throw new Exception("No existe la cita");
        }

        PQRS pqrs = new PQRS();
        pqrs.setFechaCreacion(LocalDate.now());
        pqrs.setTipo(pqrsPacienteDTO.tipoPQRS());
        pqrs.setMotivo(pqrsPacienteDTO.detalle());
        pqrs.setEstado(EstadoPQRS.enviado);
        pqrs.setCodigoCita(cita);

        PQRS pqrsCreada = pqrsRepo.save(pqrs);
        return pqrsCreada.getCodigo();
    }

    public PQRS datosPqrs(PQRSPacienteDTO pqrsPacienteDTO){
        PQRS pqrs = new PQRS();
        pqrs.setCodigoCita(pqrsPacienteDTO.citaAsociada());
        pqrs.setTipo(pqrsPacienteDTO.tipoPQRS());
        pqrs.setMotivo(pqrsPacienteDTO.detalle());

        return pqrs;
    }

    @Override
    public List<HistorialPQRSPacienteDTO> listarPQRSPaciente() throws Exception {

        List<PQRS> listaPqrs = pqrsRepo.findAll();
        if (listaPqrs.isEmpty()) {
            throw new Exception("no hay pqrs");
        }


        List<HistorialPQRSPacienteDTO> respuesta = new ArrayList<>();
        for (PQRS pqrs: listaPqrs){
            respuesta.add(new HistorialPQRSPacienteDTO(
                    pqrs.getCodigo(),
                    pqrs.getFechaCreacion(),
                    pqrs.getCodigoCita().getCodigo(),
                    pqrs.getEstado()
            ));
        }

        return respuesta;
    }


    @Override
    public void responderPQRS(String mensaje) {

    }

    //un error en el test
    @Override
    public List<CitasPacienteDTO> listarCitasPaciente(int codigoPaciente) throws Exception {

        List<Cita> citas = citaRepo.findByCedulaPacienteCodigo(codigoPaciente);

        if (citas.isEmpty()){
            throw new Exception("no hay citas pendientes para el dia de hoy");
        }

        List<CitasPacienteDTO> respuesta = new ArrayList<>();
        for (Cita c: citas){
            if(c.getCedulaPaciente().getCodigo() == codigoPaciente) {
                respuesta.add(new CitasPacienteDTO(
                        c.getFechaCreacion(),
                        c.getFechaCita(),
                        c.getHoraCita(),
                        c.getCodigoMedico().getNombre(),
                        c.getCodigoEstado(),
                        c.getMotivo()
                ));
            }
        }
        return respuesta;
    }

    @Override
    public List<Cita> filtrarCitasPorFecha(LocalDate fecha) throws Exception {
        List<Cita> citas = citaRepo.findByFechaCita(fecha);
        if (!citas.isEmpty()){
            throw new Exception("no hay citas para esa fecha");
        }
        return citas;
    }

    //no funciona bien
    @Override
    public List<Cita> filtrarCitasPorMedico(int codigoMedico) throws Exception {
        List<Cita> citas = citaRepo.findByCodigoMedicoCodigo(codigoMedico);
        if (citas.isEmpty()){
            throw new Exception("no hay citas con ese medico");
        }
        return citas;
    }

    @Override
    public DetalleCitaPacienteDTO verDetalleCita(int codigoCita) throws Exception {
        Cita cita = citaRepo.findByCodigo(codigoCita);
        if(cita==null){
            throw new Exception("no existen citas con este codigo");
        }

        DetalleCitaPacienteDTO detalle = new DetalleCitaPacienteDTO(cita.getFechaCita(),
                cita.getHoraCita(),
                cita.getCodigoMedico().getNombre(),
                cita.getCedulaPaciente().getNombre());
        System.out.println("el detalle de la cita es"+detalle);
        return detalle;
    }

    @Override
    public void posponerCita(int codigoCita, LocalDate fecha, LocalTime hora) throws Exception {
        Cita cita = citaRepo.findByCodigo(codigoCita);

        if (cita==null){
            throw new Exception("No hay citas con este id");
        }
        if (!citaRepo.findByCodigoMedicoCodigoAndFechaCitaAndHoraCita(cita.getCedulaPaciente().getCodigo(), fecha, hora).isEmpty()){
            throw new Exception("Ya tienes citas para este dia y a esa hora");
        }

        cita.setFechaCita(fecha);
        cita.setHoraCita(hora);

        citaRepo.save(cita);
    }
}
