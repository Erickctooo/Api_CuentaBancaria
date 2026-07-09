package CuentaBancaria.Api.Mapper;

import CuentaBancaria.Api.Dto.Usuario.UsuarioRequest;
import CuentaBancaria.Api.Dto.Usuario.UsuarioResponse;
import CuentaBancaria.Api.Dto.Usuario.UsuariosResponse;
import CuentaBancaria.Api.Entity.Usuario;

import java.util.List;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request){

        Usuario usuario = new Usuario();

        usuario.setRut(request.rut());
        usuario.setNombre(request.nombre());
        usuario.setCorreo(request.correo());
        usuario.setContrasenna(request.contrasenna());
        usuario.setEstado(request.estado());

        return usuario;
    }

    public static UsuarioResponse toResponse(Usuario usuario){
        return new UsuarioResponse(

                usuario.getId(),
                usuario.getRut(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getEstado()
        );
    }

    public static UsuariosResponse toUsuariosResponse(List<Usuario> usuarios){
        return new UsuariosResponse(
                usuarios.stream().map(UsuarioMapper::toResponse).toList()
        );
    }
}
