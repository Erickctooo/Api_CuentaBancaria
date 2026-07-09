package CuentaBancaria.Api.Dto.ApiResponse;

public record ApiResponse<T>(
        int httpCode,
        String httpMessage,
        T data
) {
}
