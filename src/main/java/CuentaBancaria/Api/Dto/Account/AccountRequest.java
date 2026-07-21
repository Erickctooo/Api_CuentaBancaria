package CuentaBancaria.Api.Dto.Account;

public record AccountRequest(

        String banco,
        String numCuenta,
        String tipoCuenta,
        double saldo,
        Long user_id
) {
}
