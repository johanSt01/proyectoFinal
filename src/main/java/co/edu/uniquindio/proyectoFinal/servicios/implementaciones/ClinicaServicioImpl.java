package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EPS;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.TipoSangre;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicaServicioImpl implements ClinicaServicio {
    @Override
    public List<Ciudad> listarCiudades() throws Exception {
        return List.of( Ciudad.values());
    }

    @Override
    public List<EPS> listarEPS() throws Exception {
        return List.of( EPS.values());
    }

    @Override
    public List<TipoSangre> listarTipoSangre() throws Exception {
        return List.of( TipoSangre.values());
    }

    @Override
    public List<Especialidad> listarEspecialidades() throws Exception {
        return List.of( Especialidad.values());
    }
}
