package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.DTO.*;
import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Cita;
import co.edu.uniquindio.proyectoFinal.repositorios.CitaRepository;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepository citaRepo;
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
                        c.getCedula_paciente().getNombre()
                ));
            }

            return respuesta;
    }

    @Override
    public void atenderCita(AtencionCitaMedicoDTO atencionCitaMedicoDTO) throws Exception {

    }

    private boolean existe(String codigo) {
        return citaRepo.findByCodigo(codigo) != null;
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
                    c.getCedula_paciente().getNombre(),
                    c.getAtencion().getDiagnostico()
                    ));
        }
        return respuesta;
    }

    @Override
    public void agendarDiaLibre(DiaLibreMedicoDTO diaLibreDTO) throws Exception {

    }

    @Override
    public List<CitasHoyMedicoDTO> listarCitasRealizadas() throws Exception{

        List<Cita> citas = citaRepo.findAll();

        if (citas.isEmpty()){
            throw new Exception("no hay citas pendientes para el dia de hoy");
        }

        List<CitasHoyMedicoDTO> respuesta = new ArrayList<>();
        for (Cita c: citas){
            respuesta.add(new CitasHoyMedicoDTO(
                    c.getHoraCita(),
                    c.getCedula_paciente().getNombre()
            ));
        }
        return respuesta;
    }
}
