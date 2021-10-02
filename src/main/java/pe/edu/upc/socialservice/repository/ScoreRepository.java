package pe.edu.upc.socialservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.socialservice.entity.Score;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {
    Optional<Score> findScoreByValue(Long value);
    Optional<Score> findScoreByName(String name);
}
