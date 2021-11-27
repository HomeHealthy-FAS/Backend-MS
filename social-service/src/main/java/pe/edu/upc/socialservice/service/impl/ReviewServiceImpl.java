package pe.edu.upc.socialservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.*;
import pe.edu.upc.socialservice.repository.CollaboratorRepository;
import pe.edu.upc.socialservice.repository.CustomerRepository;
import pe.edu.upc.socialservice.repository.ReviewRepository;
import pe.edu.upc.socialservice.repository.ScoreRepository;
import pe.edu.upc.socialservice.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewByCustomerAndCollaborator(Long customerId, Long collaboratorId) {
        return reviewRepository.findReviewByCustomerIdAndCollaboratorId(customerId, collaboratorId).orElse(null);
    }

    @Override
    public Review createReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest) {
        Review review = reviewRequest;
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Collaborator collaborator = collaboratorRepository.findById(collaboratorId).orElse(null);
        Score score = scoreRepository.findById(scoreId).orElse(null);

        review.setStatus("CREATED");
        review.setCustomer(customer);
        review.setCollaborator(collaborator);
        review.setScore(score);

        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review reviewRequest) {
        Review reviewDb = reviewRepository.findById(id).orElse(null);

        if (reviewDb == null){
            return  null;
        }

        reviewDb.setStatus(reviewRequest.getDescription());
        reviewDb.setStatus(reviewRequest.getStatus());

        return reviewRepository.save(reviewDb);
    }

    @Override
    public Review deleteReview(Long reviewId) {
        Review reviewDb = reviewRepository.findById(reviewId).orElse(null);
        if (reviewDb == null){
            return null;
        }
        reviewDb.setStatus("DELETED");

        return reviewRepository.save(reviewDb);
    }
}
