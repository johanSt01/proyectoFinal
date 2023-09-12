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
public class PQRS implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private int codigo;
    private Date fechaCreacion;
    private String tipo, motivo;

    @OneToMany (mappedBy = "codigo_pqrs")
    private List<Mensaje> mensaje;

    private EstadoPQRS codigo_estado;

    @ManyToOne
    private Cita codigo_cita;
}
