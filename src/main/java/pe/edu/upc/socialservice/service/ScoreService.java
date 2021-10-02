package pe.edu.upc.socialservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Score;

@Service
public interface ScoreService {
    Page<Score> getAllScore(Pageable pageable);
    Score getScoreById(Long id);
    Score createScore(Score scoreRequest);
    Score updateScore(Long id, Score scoreRequest);
    ResponseEntity<?> deleteScore(Long id);
}
