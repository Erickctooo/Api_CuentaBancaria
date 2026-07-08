package CuentaBancaria.Api.Service;

import CuentaBancaria.Api.Dto.UsuarioRequest;
import CuentaBancaria.Api.Dto.UsuarioResponse;
import CuentaBancaria.Api.Dto.UsuariosResponse;
import CuentaBancaria.Api.Entity.Usuario;
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

        Usuario usuario = usuarioRepository.findByRut(rut).orElseThrow(()-> new RuntimeException("Null"));

        return UsuarioMapper.toResponse(usuario);

    }

    public UsuarioResponse crearUsuario(UsuarioRequest request){

        Usuario nuevoUsuario = UsuarioMapper.toEntity(request);

        usuarioRepository.save(nuevoUsuario);

        return UsuarioMapper.toResponse(nuevoUsuario);

    }
}
