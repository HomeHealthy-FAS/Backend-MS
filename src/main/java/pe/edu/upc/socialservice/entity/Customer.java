package pe.edu.upc.socialservice.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 25, unique = true)
    private String username;

    @NotNull
    @Column(length = 25)
    private String password;

    @NotNull
    @Column(length = 50)
    private String name;

    @NotNull
    @Column(length = 50)
    private String lastname;

    @NotNull
    @Column(length = 50, unique = true)
    private String email;

    @NotNull
    @Column(length = 50)
    private Long phone;

    @NotNull
    @Column(length = 50)
    private String address;

    @NotNull
    @Column(length = 10, nullable = false)
    private String status;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
}
