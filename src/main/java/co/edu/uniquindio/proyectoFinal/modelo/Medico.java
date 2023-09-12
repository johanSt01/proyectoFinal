package co.edu.uniquindio.proyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medico extends Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private Especialidad codigo_especialidad;

    @OneToMany(mappedBy = "codigo_medico")
    private List<Horario> horario;

    @OneToMany(mappedBy = "codigo_medico")
    private List<DiaLibre> diaLibre;
}
