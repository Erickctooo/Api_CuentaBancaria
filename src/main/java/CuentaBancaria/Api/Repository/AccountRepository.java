package CuentaBancaria.Api.Repository;

import CuentaBancaria.Api.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {


    Optional<Account> findBynumCuenta(String numAccount);
}
