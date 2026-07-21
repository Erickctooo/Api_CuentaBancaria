package CuentaBancaria.Api.Mapper;

import CuentaBancaria.Api.Dto.Account.AccountRequest;
import CuentaBancaria.Api.Dto.Account.AccountResponse;
import CuentaBancaria.Api.Dto.Account.CreateAccountResponse;
import CuentaBancaria.Api.Dto.User.UserResponse;
import CuentaBancaria.Api.Entity.Account;
import CuentaBancaria.Api.Entity.User;

public class AccountMapper {

    public static CreateAccountResponse toResponse(Account account){

        UserResponse usuarioResponse = new UserResponse(
                account.getUser().getId(),
                account.getUser().getRut(),
                account.getUser().getNombre(),
                account.getUser().getCorreo(),
                account.getUser().getEstado()
        );
        return new CreateAccountResponse(
                account.getBanco(),
                account.getNumCuenta(),
                account.getTipoCuenta(),
                account.getSaldo(),
                usuarioResponse

        );
    }

    public static Account toEntity(AccountRequest request, User user){

        Account account = new Account();

        account.setBanco(request.banco());
        account.setNumCuenta(request.numCuenta());
        account.setTipoCuenta(request.tipoCuenta());
        account.setSaldo(request.saldo());
        account.setUser(user);

        return account;

    }

    public static AccountResponse tooResponse(Account account){

        return new AccountResponse(
                account.getBanco(),
                account.getNumCuenta(),
                account.getTipoCuenta(),
                account.getSaldo()
        );

    }
}
