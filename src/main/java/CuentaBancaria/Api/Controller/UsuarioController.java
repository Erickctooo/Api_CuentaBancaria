package CuentaBancaria.Api.Controller;


import CuentaBancaria.Api.Dto.ApiResponse.ApiResponse;
import CuentaBancaria.Api.Dto.Usuario.UsuarioRequest;
import CuentaBancaria.Api.Dto.Usuario.UsuarioResponse;
import CuentaBancaria.Api.Dto.Usuario.UsuariosResponse;
import CuentaBancaria.Api.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<UsuariosResponse>> obtenerUsuarios(){

        HttpStatus status = HttpStatus.OK;

        UsuariosResponse usuarios = usuarioService.getAll();

        ApiResponse<UsuariosResponse> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(), usuarios);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getByRut")
    public ResponseEntity<ApiResponse<UsuarioResponse>> obtenerUsuario(@RequestParam String rut){

        HttpStatus status = HttpStatus.OK;

        UsuarioResponse usuario = usuarioService.getByrut(rut);

        ApiResponse<UsuarioResponse> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),usuario);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/postUser")
    public ResponseEntity<ApiResponse<UsuarioResponse>> createUsuario(@RequestBody UsuarioRequest request){

        HttpStatus status = HttpStatus.CREATED;

         UsuarioResponse usuario = usuarioService.crearUsuario(request);

         ApiResponse<UsuarioResponse> response =
                 new ApiResponse<>(status.value(),status.getReasonPhrase(),usuario);
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body(response);
    }

}
