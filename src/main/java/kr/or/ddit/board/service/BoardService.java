package kr.or.ddit.board.service;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;

public class BoardService implements BoardServiceI{
	
	private BoardRepositoryI boardRepository;

	public BoardRepositoryI getBoardRepository() {
		return boardRepository;
	}

	public void setBoardRepository(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}

	BoardService(BoardRepositoryI boardRepository){
		this.boardRepository = boardRepository;
	}
	BoardService(){
		
	}
	@Override
	public BoardVo getBoard(int boardNo) {
		// new 연산자를 통해 객체를 만들지 않았지만 ioc.xml(Spring 컨테이너)에서 속성 설정을 해줬기 때문에 객체를 자동으로 만들어 준다.
		return boardRepository.getBoard(boardNo);
	}
	
	
	
	
	
}
