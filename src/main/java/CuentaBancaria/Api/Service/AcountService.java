package CuentaBancaria.Api.Service;

import CuentaBancaria.Api.Dto.Account.AccountRequest;
import CuentaBancaria.Api.Dto.Account.AccountResponse;
import CuentaBancaria.Api.Dto.Account.CreateAccountResponse;
import CuentaBancaria.Api.Entity.Account;
import CuentaBancaria.Api.Entity.User;
import CuentaBancaria.Api.Exception.AccountNotFound;
import CuentaBancaria.Api.Exception.UserNotFound;
import CuentaBancaria.Api.Mapper.AccountMapper;
import CuentaBancaria.Api.Repository.AccountRepository;
import CuentaBancaria.Api.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AcountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public AcountService(UserRepository userRepository,
                         AccountRepository accountRepository){

        this.userRepository = userRepository;
        this.accountRepository = accountRepository;

    }

    public CreateAccountResponse createAcount(AccountRequest request){

        User user = userRepository.findById(request.user_id()).orElseThrow(()-> new UserNotFound(""));

        Account account = AccountMapper.toEntity(request, user);

        accountRepository.save(account);

        return AccountMapper.toResponse(account);
    }

    public AccountResponse findAccountbyNumAccount(String numAccount){

        Account account = accountRepository.findBynumCuenta(numAccount).orElseThrow(()-> new AccountNotFound(""));

        return AccountMapper.tooResponse(account);

    }

    public AccountResponse deposit(String numAccount, double amount){

        Account account = accountRepository.findBynumCuenta(numAccount).orElseThrow(()-> new AccountNotFound(""));

        double newBalance = account.getSaldo() + amount;

        account.setSaldo(newBalance);

        accountRepository.save(account);

        return AccountMapper.tooResponse(account);
    }
}
