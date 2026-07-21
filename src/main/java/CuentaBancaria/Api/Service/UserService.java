package CuentaBancaria.Api.Service;

import CuentaBancaria.Api.Dto.User.UserRequest;
import CuentaBancaria.Api.Dto.User.UserResponse;
import CuentaBancaria.Api.Dto.User.UserWithAccountResponse;
import CuentaBancaria.Api.Dto.User.UsersResponse;
import CuentaBancaria.Api.Entity.User;
import CuentaBancaria.Api.Exception.UserAlreadyExistsException;
import CuentaBancaria.Api.Exception.UserNotFound;
import CuentaBancaria.Api.Mapper.UserMapper;
import CuentaBancaria.Api.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UsersResponse getAll(){

        List<User> users = userRepository.findAll();

        return UserMapper.toUsuariosResponse(users);
    }

    public UserResponse getByrut(String rut){

        User user = userRepository.findByRut(rut).orElseThrow(()-> new UserNotFound(""));

        return UserMapper.toResponse(user);

    }

    public UserResponse createUser(UserRequest request){

        UserResponse usuario = getByrut(request.rut());

        if(usuario!=null){
            throw new UserAlreadyExistsException("");
        }

        User nuevoUser = UserMapper.toEntity(request);

        userRepository.save(nuevoUser);

        return UserMapper.toResponse(nuevoUser);

    }

    public UserWithAccountResponse getUserAcount(String rut){

        User user = userRepository.findByRut(rut).orElseThrow(()-> new UserNotFound(""));

        return UserMapper.tooResponseUser(user);

    }

}
