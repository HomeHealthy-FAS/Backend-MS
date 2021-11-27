package pe.edu.upc.socialservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.socialservice.entity.Review;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findReviewByCustomerIdAndCollaboratorId(Long customerId, Long collaboratorId);
}
