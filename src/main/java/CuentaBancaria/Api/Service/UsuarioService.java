package CuentaBancaria.Api.Service;

import CuentaBancaria.Api.Dto.Usuario.UsuarioRequest;
import CuentaBancaria.Api.Dto.Usuario.UsuarioResponse;
import CuentaBancaria.Api.Dto.Usuario.UsuariosResponse;
import CuentaBancaria.Api.Entity.Usuario;
import CuentaBancaria.Api.Exception.UsuarioAlreadyExistsException;
import CuentaBancaria.Api.Exception.UsuarioNotFound;
import CuentaBancaria.Api.Mapper.UsuarioMapper;
import CuentaBancaria.Api.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UsuariosResponse getAll(){

        List<Usuario> usuarios = usuarioRepository.findAll();

        return UsuarioMapper.toUsuariosResponse(usuarios);
    }

    public UsuarioResponse getByrut(String rut){

        Usuario usuario = usuarioRepository.findByRut(rut).orElseThrow(()-> new UsuarioNotFound(""));

        return UsuarioMapper.toResponse(usuario);

    }

    public UsuarioResponse crearUsuario(UsuarioRequest request){

        UsuarioResponse usuario = getByrut(request.rut());

        if(usuario!=null){
            throw new UsuarioAlreadyExistsException("");
        }

        Usuario nuevoUsuario = UsuarioMapper.toEntity(request);

        usuarioRepository.save(nuevoUsuario);

        return UsuarioMapper.toResponse(nuevoUsuario);

    }
}
