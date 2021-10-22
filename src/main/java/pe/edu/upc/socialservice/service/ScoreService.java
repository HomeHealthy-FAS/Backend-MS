package pe.edu.upc.socialservice.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Score;

import java.util.List;

@Service
public interface ScoreService {
    List<Score> getAllScore();
    Score getScoreById(Long id);
    Score createScore(Score scoreRequest);
    Score updateScore(Long id, Score scoreRequest);
    Score deleteScore(Long id);
}
