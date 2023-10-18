package co.edu.uniquindio.proyectoFinal.modelo.Entidades;

import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.Ciudad;
import co.edu.uniquindio.proyectoFinal.modelo.Enumeraciones.EstadoUsuario;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass //sirve para decirle a la base de datos que es una super clase, mas no una entidad
public class Usuario extends Cuenta implements Serializable {

    @Column(unique = true, length = 12, insertable = true, updatable = true, nullable = false)
    private String cedula;

    @Column(unique = false, length = 200, insertable = true, updatable = true, nullable = false)
    private String nombre;

    @Column(unique = true, length = 10, insertable = true, updatable = true, nullable = false)
    private String telefono;

    @Column(unique = false, insertable = true, updatable = true, nullable = false)
    private String URLfoto;

    @Column(nullable = false,length = 15)
    private Ciudad ciudad;

    private EstadoUsuario estadoUsuario;
}
