package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(updatable = true, nullable = false)
    private Date dia;

    @Column(updatable = true, nullable = false)
    private Time horaIncio;

    @Column(updatable = true, nullable = false)
    private Time horaFin;

    @ManyToOne
    private Medico codigoMedico;
}
