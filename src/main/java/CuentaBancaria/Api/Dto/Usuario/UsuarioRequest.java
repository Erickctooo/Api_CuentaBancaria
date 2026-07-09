package CuentaBancaria.Api.Dto.Usuario;

public record UsuarioRequest(

        String rut,
        String nombre,
        String correo,
        String contrasenna,
        String estado
) {
}
