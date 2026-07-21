package CuentaBancaria.Api.Dto.User;

import CuentaBancaria.Api.Dto.Account.AccountResponse;

import java.util.List;

public record UserWithAccountResponse(
        Long id,
        String rut,
        String nombre,
        String correo,
        String estado,
        List<AccountResponse> cuentas
) {
}
