package CuentaBancaria.Api.Controller;


import CuentaBancaria.Api.Dto.Account.AccountResponse;
import CuentaBancaria.Api.Dto.ApiResponse.ApiResponse;
import CuentaBancaria.Api.Dto.Account.AccountRequest;
import CuentaBancaria.Api.Dto.Account.CreateAccountResponse;
import CuentaBancaria.Api.Service.AcountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AcountService accountService;

    public AccountController(AcountService accountService){

        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CreateAccountResponse>> createAccount(@RequestBody AccountRequest request){

        HttpStatus status = HttpStatus.CREATED;

        CreateAccountResponse cuenta = accountService.createAcount(request);

        ApiResponse<CreateAccountResponse> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),cuenta);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{numAccount}/Account")
    public ResponseEntity<ApiResponse<AccountResponse>> findAccountbyNumAccount(@PathVariable String numAccount){

        HttpStatus status = HttpStatus.OK;

        AccountResponse account = accountService.findAccountbyNumAccount(numAccount);

        ApiResponse<AccountResponse> response =
                new ApiResponse<>(status.value(), status.getReasonPhrase(), account);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{numAccount}/Account")
    public ResponseEntity<ApiResponse<AccountResponse>> depositar(@PathVariable String numAccount , @RequestParam double amount){

        HttpStatus status = HttpStatus.OK;

        AccountResponse account = accountService.deposit(numAccount, amount);

        ApiResponse<AccountResponse> response =
                new ApiResponse<>(status.value(), status.getReasonPhrase(), account);

        return ResponseEntity.ok(response);
    }
}