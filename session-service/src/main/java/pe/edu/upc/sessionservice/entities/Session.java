package pe.edu.upc.sessionservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name= "session")
@Data
public class Session {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @Column(name="start_at",length = 50, nullable = false)
    private String startAt;

    @Column(name="end_at",length = 50, nullable = false)
    private String endAt;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name="plan_id",nullable = false)
    private Long planId;

    @Column(name="employee_id",nullable = false)
    private Long employeeId;

    @Column(name="available_schedule_id",nullable = false)
    private Long availableScheduleId;
}
