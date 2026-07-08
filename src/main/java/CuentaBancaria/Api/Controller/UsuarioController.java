package CuentaBancaria.Api.Controller;


import CuentaBancaria.Api.Dto.UsuarioRequest;
import CuentaBancaria.Api.Dto.UsuarioResponse;
import CuentaBancaria.Api.Dto.UsuariosResponse;
import CuentaBancaria.Api.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/getAll")
    public UsuariosResponse obtenerUsuarios(){
        return usuarioService.getAll();
    }

    @GetMapping("/getByRut")
    public UsuarioResponse obtenerUsuario(@RequestParam String rut){
        return usuarioService.getByrut(rut);
    }

    @PostMapping("/postUser")
    public UsuarioResponse createUsuario(@RequestBody UsuarioRequest request){

         return usuarioService.crearUsuario(request);
    }

}
