package kr.or.ddit.board.service;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;

public interface BoardServiceI {
	BoardVo getBoard(int boardNo);

}
