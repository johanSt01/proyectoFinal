package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Column(nullable = false, updatable = true)
    private Especialidad especialidad;

    @Column(nullable = false, updatable = true)
    private LocalTime horaInicio, horaFin;

    @OneToMany(mappedBy = "codigoMedico")
    private List<DiaLibre> diaLibre;

    @OneToMany(mappedBy = "codigoMedico")
    private List<Cita> cita;
}
