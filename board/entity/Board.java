package makeit.documents.board.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import makeit.account.entity.Account;
import makeit.documents.DocCategory;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jinhyung on 2015. 12. 7..
 */
@Data       // Getter Setter 를 어노테이션 하나로 만들어줍니다.
@Entity     // Jpa 를 사용해서 간단하게 DB를 쓰기위함
public class Board {

    @Id                     // primary key 를 명시합니다.
    @GeneratedValue         // Auto increment 를 명시합니다.
    private Long boardSrl;

    private DocCategory category;

    private String writerName;         //작성자

    private String boardWriterName;

    @Temporal(TemporalType.TIMESTAMP)       // DATE, TIME ,DATETIME, TIMESTAMP < 타입으로 사용
    private Date createDate;

    @Lob                    // Long binary Data
    private String boardContent;

    private String password;

    private Long boardView;

    private String boardTitle;


}
