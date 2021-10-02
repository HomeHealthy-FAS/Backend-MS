package pe.edu.upc.socialservice.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reasons")
@Data
public class Reason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String description;

    public Long getId() {
        return id;
    }

    public Reason setId(Long id) {
        this.id = id;
        return this;
    }

}
