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

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, updatable = true)
    private Especialidad codigo_especialidad;

    @OneToMany(mappedBy = "codigo_medico")
    private List<Horario> horario;

    @OneToMany(mappedBy = "codigo_medico")
    private List<DiaLibre> diaLibre;

    @OneToMany(mappedBy = "codigo_medico")
    private List<Cita> cita;
}
