package co.edu.uniquindio.proyectoFinal.modelo;

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
    private Date dia;
    private Time horaIncio;
    private Time horaFin;

    @ManyToOne
    private Medico codigo_medico;
}
