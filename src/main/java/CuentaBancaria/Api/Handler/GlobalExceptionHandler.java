package CuentaBancaria.Api.Handler;

import CuentaBancaria.Api.Dto.ApiResponse.ApiResponse;
import CuentaBancaria.Api.Exception.AccountNotFound;
import CuentaBancaria.Api.Exception.UserAlreadyExistsException;
import CuentaBancaria.Api.Exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> HandleAlReadyExists(UserAlreadyExistsException ex){

        HttpStatus status = HttpStatus.CONFLICT;

        ApiResponse<Void> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),null);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ApiResponse<Void>> HandleNotFound(UserNotFound ex){

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiResponse<Void> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<ApiResponse<Void>> HandleAccountNotFound(AccountNotFound ex){

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiResponse<Void> response =
                new ApiResponse<>(status.value(), status.getReasonPhrase(), null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
