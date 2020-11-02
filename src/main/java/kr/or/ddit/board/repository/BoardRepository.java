package kr.or.ddit.board.repository;

import kr.or.ddit.board.model.BoardVo;

public class BoardRepository implements BoardRepositoryI{

	@Override
	public BoardVo getBoard(int boardNo) {
		// DB에서 조회해야하나 지금 설정이 갖춰지지 않았으므로 가짜 객체를 반환
		if (boardNo == 1) {
			return new BoardVo(1, "첫번째 글", "내용");
		}
		else
			return null;
	}

}
