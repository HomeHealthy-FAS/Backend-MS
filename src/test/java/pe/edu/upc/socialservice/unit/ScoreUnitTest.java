package pe.edu.upc.socialservice.unit;

import org.junit.jupiter.api.Test;
import pe.edu.upc.socialservice.entity.Customer;
import pe.edu.upc.socialservice.entity.Score;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreUnitTest {

    @Test
    public void createScoreWithValidValue(){

        Score score = new Score();
        Long value = 5L;
        score.setId(1L);
        score.setValue(value);
        score.setStatus("CREATED");

        assertThat(score.getValue()).isLessThanOrEqualTo(value);
    }

}
