package co.edu.uniquindio.proyectoFinal.servicios.implementaciones;

import co.edu.uniquindio.proyectoFinal.modelo.Entidades.Usuario;
import co.edu.uniquindio.proyectoFinal.repositorios.UsuarioRepository;
import co.edu.uniquindio.proyectoFinal.servicios.Interfaces.ImagenesServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImagenesServicioImpl implements ImagenesServicio{

    private final UsuarioRepository usuarioRep;
    @Override
    public void subirImagen(String url) throws Exception {
        Usuario usuario = usuarioRep.findByURLfoto(url);
        if (usuario!=null){
            throw new Exception("el usuario ya tiene una foto");
        }
        if (usuario.getURLfoto().isEmpty()){
            throw new Exception("No hay ninguna imagen seleccionada");
        }

        usuario.setURLfoto(url);
    }

    @Override
    public void eliminarMensaje(String url) throws Exception {
        Usuario usuario = usuarioRep.findByURLfoto(url);
        if (usuario.getURLfoto().isEmpty()){
            throw new Exception("No hay ninguna imagen seleccionada");
        }

        usuario.setURLfoto("");
    }
}
