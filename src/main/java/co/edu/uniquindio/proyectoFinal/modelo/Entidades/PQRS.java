package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoPQRS;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PQRS implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(updatable = true, nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false, insertable = true, updatable = false)
    private String tipo, motivo;

    @OneToMany (mappedBy = "codigoPqrs")
    private List<Mensaje> mensaje;

    private EstadoPQRS estado;

    @ManyToOne
    private Cita codigoCita;
}
