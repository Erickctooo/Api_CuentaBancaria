package CuentaBancaria.Api.Controller;


import CuentaBancaria.Api.Dto.ApiResponse.ApiResponse;
import CuentaBancaria.Api.Dto.User.UserRequest;
import CuentaBancaria.Api.Dto.User.UserResponse;
import CuentaBancaria.Api.Dto.User.UserWithAccountResponse;
import CuentaBancaria.Api.Dto.User.UsersResponse;
import CuentaBancaria.Api.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<UsersResponse>> getAllUsers(){

        HttpStatus status = HttpStatus.OK;

        UsersResponse usuarios = userService.getAll();

        ApiResponse<UsersResponse> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(), usuarios);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserByRut(@PathVariable  String rut){

        HttpStatus status = HttpStatus.OK;

        UserResponse usuario = userService.getByrut(rut);

        ApiResponse<UserResponse> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),usuario);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest request){

        HttpStatus status = HttpStatus.CREATED;

         UserResponse usuario = userService.createUser(request);

         ApiResponse<UserResponse> response =
                 new ApiResponse<>(status.value(),status.getReasonPhrase(),usuario);
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body(response);
    }

    @GetMapping("/{rut}/accounts")
    public ResponseEntity<ApiResponse<UserWithAccountResponse>> getUserWithAccounts(@PathVariable String rut){

        HttpStatus status = HttpStatus.OK;

        UserWithAccountResponse usuario = userService.getUserAcount(rut);

        ApiResponse<UserWithAccountResponse> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),usuario);

        return ResponseEntity.ok(response);
    }

}
