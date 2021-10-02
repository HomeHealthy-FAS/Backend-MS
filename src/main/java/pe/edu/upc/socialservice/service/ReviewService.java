package pe.edu.upc.socialservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Review;

@Service
public interface ReviewService {
    Page<Review> getAllReviews(Pageable pageable);
    Review getReviewByCustomerAndCollaborator(Long customerId, Long collaboratorId);
    Review createReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest);
    Review updateReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest);
    ResponseEntity<?> deleteReview(Long customerId, Long collaboratorId);
}
