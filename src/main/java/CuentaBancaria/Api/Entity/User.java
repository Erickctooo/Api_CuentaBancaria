package CuentaBancaria.Api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="rut")
    private String rut;

    @Column (name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenna")
    private String contrasenna;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts = new ArrayList<>();


}
