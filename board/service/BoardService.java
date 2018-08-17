package makeit.documents.board.service;

import makeit.documents.board.entity.Board;
import makeit.documents.board.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dahye on 2016-01-07.
 */
@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board saveBoardorWriteBoard(String name, String content) {

        Board board = new Board();

        board.setWriterName(name);
        board.setBoardContent(content);
        board.setCreateDate(new Date());
        board.setBoardTitle("테스트 제목");


        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }
    public Board findBoardDocumentOne(Long boardSrl) {

        Board board = boardRepository.findOne(boardSrl);

        return board;
    }
    public Board findBoardByContentEqual(String content) {
        Board board = boardRepository.findOneByBoardContent(content);
        return board;
    }
    public Board editBoard(Board board) {
        Board originamBoard = boardRepository.findOne(board.getBoardSrl());
        originamBoard.setBoardContent(board.getBoardContent());
        originamBoard.setBoardTitle(board.getBoardTitle());

        Board editedBoard = boardRepository.save(originamBoard);
        return editedBoard;
    }
    public List getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        return boardList;

//        Create Remove Update Delete
    }
    public List getBoardList(Pageable pageable) {
        Page<Board> boardList = boardRepository.findAll(pageable);
        return boardList.getContent();
    }
}
