package CuentaBancaria.Api.Dto.Usuario;

public record UsuarioResponse(

        Long id,
        String rut,
        String nombre,
        String correo,
        String estado
) {
}
