package CuentaBancaria.Api.Dto;

public record UsuarioResponse(

        Long id,
        String rut,
        String nombre,
        String correo,
        String estado
) {
}
