package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cuenta implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, updatable = true)
    private String correo;

    @Column(nullable = false, updatable = true, length = 20)
    private String contraseña;

    @OneToMany (mappedBy = "codigo_cuenta")
    private List<Mensaje> mensaje;

}
