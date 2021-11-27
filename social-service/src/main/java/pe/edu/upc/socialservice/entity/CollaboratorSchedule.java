package pe.edu.upc.socialservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "collaborator_schedules")
@Data
public class CollaboratorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "collaborator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Collaborator collaborator;

    @NotNull
    @Column(length = 10, nullable = false)
    private String status;
}
