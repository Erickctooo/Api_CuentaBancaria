package CuentaBancaria.Api.Dto.Account;

public record AccountResponse(
        String banco,
        String numCuenta,
        String tipoCuenta,
        double saldo
) {
}
