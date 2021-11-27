package pe.edu.upc.product.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "diet")
@Data
public class Diet extends Plan {
}
