package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Atencion;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.DiaLibre;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Medico;
import co.edu.uniquindio.proyectoFinal.repositorios.AtencionRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.CitaRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.DiaLibreRepository;
import co.edu.uniquindio.proyectoFinal.repositorios.MedicoRepository;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepository citaRepo;
    private final DiaLibreRepository diaLibreRepo;
    private final MedicoRepository medicoRepository;
    private final AtencionRepository atencionRepo;
    @Override
    public List<CitaMedicoDTO> listarCitasPendientes() throws Exception {

            List<Cita> citas = citaRepo.findAll();

            if (citas.isEmpty()) {
                throw new Exception("No hay citas pendientes");
            }

            List<CitaMedicoDTO> respuesta = new ArrayList<>();

            for (Cita c: citas){
                respuesta.add(new CitaMedicoDTO(
                        c.getFechaCita(),
                        c.getHoraCita(),
                        c.getCedulaPaciente().getNombre()
                ));
            }
        System.out.println(respuesta);
            return respuesta;
    }

    @Override
    public int atenderCita(AtencionCitaMedicoDTO atencionCita) throws Exception {
        Cita cita = citaRepo.findByCodigo(atencionCita.codigoCita());

        if (cita == null) {
            throw new Exception("No existe una cita con ese codigo");
        }

        Atencion atencion = new Atencion();
        atencion.setDiagnostico(atencionCita.diagnostico());
        atencion.setTratamiento(atencionCita.tratamiento());
        atencion.setNotasMedicas(atencionCita.notas());

        return atencionRepo.save(atencion).getCodigo();
    }

    @Override
    public List<HistorialCitasMedicoDTO> listarHistorialCitas() throws Exception{
        List<Cita> citas = citaRepo.findAll();

        if (citas.isEmpty()){
            throw new Exception("no hay citas pendientes para el dia de hoy");
        }

        List<HistorialCitasMedicoDTO> respuesta = new ArrayList<>();
        for (Cita c: citas){
            respuesta.add(new HistorialCitasMedicoDTO(
                    c.getFechaCita(),
                    c.getHoraCita(),
                    c.getCedulaPaciente().getNombre(),
                    c.getAtencion().getDiagnostico()
                    ));
        }

        System.out.println(respuesta);
        return respuesta;
    }

    @Override
    public DiaLibre agendarDiaLibre(LocalDate diaSeleccionado, int codMedico) throws Exception {

        if(!citaRepo.findByCodigoMedicoCodigoAndFechaCita(codMedico, diaSeleccionado).isEmpty()){
            throw new Exception("Hay citas programadas para el dia seleccionado, ingrese otro dia");
        }

        DiaLibre opcion = new DiaLibre();
        opcion.setCodigoMedico( medicoRepository.findById(codMedico).get());
        opcion.setDia(diaSeleccionado);

        return diaLibreRepo.save(opcion);
    }

    @Override
    public List<CitasHoyMedicoDTO> listarCitasHoy() throws Exception{

        List<Cita> citas = citaRepo.findAll();

        if (citas.isEmpty()){
            throw new Exception("no hay citas pendientes para el dia de hoy");
        }

        List<CitasHoyMedicoDTO> respuesta = new ArrayList<>();
        for (Cita c: citas){
            if(c.getFechaCita().isBefore( LocalDate.now() )) {
                respuesta.add(new CitasHoyMedicoDTO(
                        c.getHoraCita(),
                        c.getCedulaPaciente().getNombre()
                ));
            }
        }
        System.out.println("citas realizadas: "+citas);
        return respuesta;
    }

    @Override
    public void posponerCita(PosponerCitaMedicoDTO posponerCitaMedicoDTO) throws Exception {

        Cita cita = citaRepo.findByCodigo(posponerCitaMedicoDTO.codigoCita());

        if (cita==null){
            throw new Exception("No hay citas con este id");
        }
        if (!citaRepo.findByCodigoMedicoCodigoAndFechaCitaAndHoraCita(cita.getCedulaPaciente().getCodigo(), posponerCitaMedicoDTO.fechaPropuesta(), posponerCitaMedicoDTO.horaPropuesta()).isEmpty()){
            throw new Exception("Ya tienes citas para este dia y a esa hora");
        }

        cita.setFechaCita(posponerCitaMedicoDTO.fechaPropuesta());
        cita.setHoraCita(posponerCitaMedicoDTO.horaPropuesta());

        citaRepo.save(cita);
    }

}
