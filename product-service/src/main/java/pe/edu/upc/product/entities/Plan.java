package pe.edu.upc.product.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private Long id;

    @Column(length = 30,nullable = false)
    private String title;

    @Column(length = 200,nullable = false)
    private String description;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(length = 1,nullable = false)
    private String status;

    public long getId() {
        return id;
    }

    public Plan setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Plan setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Plan setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Plan setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Plan setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
