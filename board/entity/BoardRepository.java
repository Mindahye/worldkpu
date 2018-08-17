package makeit.documents.board.entity;

        import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dahye on 2016-01-07.
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findOneByBoardContent(String boardContent);   //<타입 , 키>
}
