package CuentaBancaria.Api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "acounts")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "banco")
    private String banco;

    @Column(name = "numcuenta")
    private String numCuenta;

    @Column(name = "tipocuenta")
    private String tipoCuenta;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
