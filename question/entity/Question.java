package makeit.question.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dahye on 2016-01-18.
 */
@Data
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long questionSrl;

    private String questionCategory;    //질문, 건의, 잡담, 기타타

    private String questionWriter;

    @Temporal(TemporalType.TIMESTAMP)
    private Date questionDate;

    @Lob
    private String questionContent;

//    private String questionPassword;

    private String questionTitle;

    private Long questionHit;
}
