package co.edu.uniquindio.proyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Paciente extends Usuario implements Serializable  {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Date fecha;
    private String alergias;

    @OneToMany(mappedBy = "cedula_paciente")
    private List<Cita> cita;

    private EPS codigo_eps;

    private TipoSangre codigo_tipo_sangre;
}
