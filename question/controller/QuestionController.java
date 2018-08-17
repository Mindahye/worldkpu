package makeit.question.controller;

import makeit.question.entity.Question;
import makeit.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by dahye on 2016-01-18.
 */
@RequestMapping("question")
@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    //question 데이터베이스 전체 리스트 제이슨 출력
    //
    @RequestMapping(value = "/questionList", method = RequestMethod.GET)
    public List<Question> questionList( Pageable pageable){
        return questionService.getQuestionList(pageable);
    }

    //글 작성
    @RequestMapping(value = "/questionWrite.do", method = RequestMethod.GET)
    public Question questionWrite(@RequestParam String writer,
                                  @RequestParam String category,
                                        @RequestParam String title,
                                        @RequestParam String content){
        Question question = questionService.writeQuestion(writer,category,title,content);
        return question;
    }

    //글 읽기
    @RequestMapping(value = "/questionView", method = RequestMethod.POST)
    public Question questionView(@RequestParam String title,
                                 @RequestParam String writer,
                                 @RequestParam String content,
                                 @RequestParam Date date,
                                 @RequestParam Long hit) {
        Question question = questionService.viewQuestion(title, writer, content, date, hit);
        return question;
    }

    //제목으로 찾기
    @RequestMapping(value = "/questionSearch", method = RequestMethod.GET)
    public List<Question> questionSearch(@RequestParam(required = true) String search){
        List<Question> question = questionService.findByQuestionTitle(search);
        return question;
    }

}
