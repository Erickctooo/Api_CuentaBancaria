package CuentaBancaria.Api.Dto.User;

public record UserResponse(

        Long id,
        String rut,
        String nombre,
        String correo,
        String estado
) {
}
