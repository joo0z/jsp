package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.repository.BoardRepository;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@Configuration
public class JavaSprinConfig {

	// boardRepository, boardService
	// 메서드 이름 ==> 스프링 빈이름 (기본적)
	
	// xml : <bean id="boardRepository(메서드 이름) class="BoardRepository"/>
	@Bean
	public BoardRepositoryI boardRepository() {
//		BoardRepositoryI boardRepository = new BoardRepository();
		return new BoardRepository();
	}
	
	// xml : <bean id="boardService(메서드 이름) class="BoardService"/>
	@Bean
	public BoardServiceI boardService() {
		BoardServiceI boardService = new BoardService();
		((BoardService) boardService).setBoardRepository(boardRepository());
		
		// 아래와 같이 직접 new 연산자를 통해 생성한 객체는 스프링빈이 아니다
		// @Bean 어노테이션이 붙은 메서드를 호출해야 스프링컨테이너에서 관리되는 스프링빈을 얻을 수 있다.
//		boardService.setBoardRepository(new boardRepository());
		return boardService;
	}
}
