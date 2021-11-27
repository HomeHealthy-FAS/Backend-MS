package pe.edu.upc.socialservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Score;
import pe.edu.upc.socialservice.repository.ScoreRepository;
import pe.edu.upc.socialservice.service.ScoreService;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<Score> getAllScore() {
        return scoreRepository.findAll();
    }

    @Override
    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    @Override
    public Score createScore(Score scoreRequest) {
       return scoreRepository.save(scoreRequest);
    }

    @Override
    public Score updateScore(Long id, Score scoreRequest) {
        Score scoreDb = getScoreById(id);
        if (scoreDb == null){
            return  null;
        }
        scoreDb.setValue(scoreRequest.getValue());

        return  scoreRepository.save(scoreDb);
    }

    @Override
    public Score deleteScore(Long id) {
        Score scoreDb = getScoreById(id);
        if (scoreDb ==null){
            return  null;
        }
        scoreDb.setStatus("DELETED");
        return scoreRepository.save(scoreDb);
    }
}
