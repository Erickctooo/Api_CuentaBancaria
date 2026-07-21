package CuentaBancaria.Api.Dto.Account;

import CuentaBancaria.Api.Dto.User.UserResponse;

public record CreateAccountResponse(

        String banco,
        String numCuenta,
        String tipoCuenta,
        double saldo,
        UserResponse usuario

) {
}
