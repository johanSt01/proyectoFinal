package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Especialidad;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Column(nullable = false, updatable = true)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "codigoMedico")
    private List<Horario> horario;

    @OneToOne(mappedBy = "codigoMedico")
    private DiaLibre diaLibre;

    @OneToMany(mappedBy = "codigoMedico")
    private List<Cita> cita;
}
