package makeit.question.entity;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dahye on 2016-01-18.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAll();

    List<Question> findByQuestionTitle(String search);
}
