package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(updatable = true, nullable = false)
    private Date fechaCreacion;

    @Column(updatable = true, nullable = false, insertable = true)
    private String mensaje;

    @ManyToOne
    private Cuenta codigo_cuenta;

    @ManyToOne
    private PQRS codigo_pqrs;

    @OneToOne
    private Mensaje codigo_mensaje;
}
