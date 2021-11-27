package pe.edu.upc.socialservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.socialservice.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
