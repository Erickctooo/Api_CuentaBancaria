package CuentaBancaria.Api.Dto.User;

public record UserRequest(

        String rut,
        String nombre,
        String correo,
        String contrasenna,
        String estado
) {
}
