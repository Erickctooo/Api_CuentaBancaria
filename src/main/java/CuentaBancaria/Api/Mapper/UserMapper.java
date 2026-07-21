package CuentaBancaria.Api.Mapper;

import CuentaBancaria.Api.Dto.Account.AccountResponse;
import CuentaBancaria.Api.Dto.User.UserRequest;
import CuentaBancaria.Api.Dto.User.UserResponse;
import CuentaBancaria.Api.Dto.User.UserWithAccountResponse;
import CuentaBancaria.Api.Dto.User.UsersResponse;
import CuentaBancaria.Api.Entity.User;

import java.util.List;

public class UserMapper {

    public static User toEntity(UserRequest request){

        User user = new User();

        user.setRut(request.rut());
        user.setNombre(request.nombre());
        user.setCorreo(request.correo());
        user.setContrasenna(request.contrasenna());
        user.setEstado(request.estado());

        return user;
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(

                user.getId(),
                user.getRut(),
                user.getNombre(),
                user.getCorreo(),
                user.getEstado()
        );
    }


    public static UserWithAccountResponse tooResponseUser(User user){

        List<AccountResponse> cuenta = user.getAccounts()
                .stream()
                .map(c-> new AccountResponse(
                        c.getBanco(),
                        c.getNumCuenta(),
                        c.getTipoCuenta(),
                        c.getSaldo()
                )).toList();

        return new UserWithAccountResponse(
                user.getId(),
                user.getRut(),
                user.getNombre(),
                user.getCorreo(),
                user.getEstado(),
                cuenta
        );
    }

    public static UsersResponse toUsuariosResponse(List<User> users){
        return new UsersResponse(
                users.stream().map(UserMapper::toResponse).toList()
        );
    }
}
