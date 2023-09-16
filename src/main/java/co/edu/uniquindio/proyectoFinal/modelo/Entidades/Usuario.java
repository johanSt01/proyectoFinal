package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass //sirve para decirle a la base de datos que es una super clase, mas no una entidad
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(unique = true, length = 12, insertable = true, updatable = true, nullable = false)
    private String cedula;

    @Column(unique = false, length = 30, insertable = true, updatable = true, nullable = false)
    private String nombre;

    @Column(unique = true, length = 10, insertable = true, updatable = true, nullable = false)
    private String telefono;

    @Column(unique = true, insertable = true, updatable = true, nullable = false)
    private String URLfoto;

    private Ciudad codigo_ciudad;
}
