package CuentaBancaria.Api.Handler;

import CuentaBancaria.Api.Dto.ApiResponse.ApiResponse;
import CuentaBancaria.Api.Exception.UsuarioAlreadyExistsException;
import CuentaBancaria.Api.Exception.UsuarioNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> HandleAlReadyExists(UsuarioAlreadyExistsException ex){

        HttpStatus status = HttpStatus.CONFLICT;

        ApiResponse<Void> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),null);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }

    @ExceptionHandler(UsuarioNotFound.class)
    public ResponseEntity<ApiResponse<Void>> HandleNotFound(UsuarioNotFound ex){

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiResponse<Void> response =
                new ApiResponse<>(status.value(),status.getReasonPhrase(),null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
