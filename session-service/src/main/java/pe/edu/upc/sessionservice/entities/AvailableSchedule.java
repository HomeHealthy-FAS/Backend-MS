package pe.edu.upc.sessionservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "available_schedules")
@Data
public class AvailableSchedule {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "start_at",length = 50, nullable = false)
    private String startAt;

    @Column(name="end_at",length = 50, nullable = false)
    private String endAt;

    @Column(name="state",length = 10, nullable = false)
    private String state;
}
