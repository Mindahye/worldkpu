package makeit.documents.board.controller;

import makeit.documents.board.entity.Board;
import makeit.documents.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dahye on 2016-01-07.
 */
@RequestMapping("board")
@RestController
public class BoardController{

    @Autowired
    BoardService boardService;

    @RequestMapping(method = RequestMethod.GET)
    public Board writeBoard(@RequestParam String name, @RequestParam String content) {
        Board board = boardService.saveBoardorWriteBoard(name, content);

        return board;


    }

}
