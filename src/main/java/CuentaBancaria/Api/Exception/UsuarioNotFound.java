package CuentaBancaria.Api.Exception;

public class UsuarioNotFound extends RuntimeException {
    public UsuarioNotFound(String message) {
        super(message);
    }
}
