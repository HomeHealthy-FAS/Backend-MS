package pe.edu.upc.socialservice.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Review;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewByCustomerAndCollaborator(Long customerId, Long collaboratorId);
    Review createReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest);
    Review updateReview(Long id, Review reviewRequest);
    Review deleteReview(Long reviewId);
}
