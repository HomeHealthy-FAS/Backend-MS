package pe.edu.upc.sessionservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name= "session_detail")
@Data
public class SessionDetail {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @Column(name="state",length = 10, nullable = false)
    private String state;
}
