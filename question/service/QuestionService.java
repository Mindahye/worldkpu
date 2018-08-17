package makeit.question.service;

import makeit.question.entity.Question;
import makeit.question.entity.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dahye on 2016-01-18.
 */
@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getQuestionList(Pageable pageable){
        Page<Question> questionList = questionRepository.findAll(pageable);
        return questionList.getContent();
    }

    public Question writeQuestion (String writer, String category, String title, String content){
        Question question = new Question();

        question.setQuestionTitle(title);
        question.setQuestionCategory(category);
        question.setQuestionWriter(writer);
        question.setQuestionContent(content);
        question.setQuestionDate(new Date());

        Question saveQuestion = questionRepository.save(question);
        return saveQuestion;
    }

    /*public List<Question> findAllByQuestTitle(String title, Sort sort){
        List<Question> titleSort = questionRepository.findAllByQuestTitle(title,sort);
        return titleSort;
    }*/

    public Question viewQuestion(String title, String writer, String content, Date date, Long hit) {
        Question question = new Question();

        hit++;
        question.setQuestionTitle(title);
        question.setQuestionWriter(writer);
        question.setQuestionContent(content);
        question.setQuestionDate(date);
        question.setQuestionHit(hit);

        Question viewQuestion = (Question) questionRepository.findAll();
        return viewQuestion;
    }

    public List<Question> findByQuestionTitle(String search) {
        List<Question> question = questionRepository.findByQuestionTitle(search);
        return question;
    }



}
