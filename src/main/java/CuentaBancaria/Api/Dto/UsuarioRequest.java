package CuentaBancaria.Api.Dto;

public record UsuarioRequest(

        String rut,
        String nombre,
        String correo,
        String contrasenna,
        String estado
) {
}
