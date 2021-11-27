package pe.edu.pe.planningservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "routine")
@Data
public class Routine extends Plan{
}
