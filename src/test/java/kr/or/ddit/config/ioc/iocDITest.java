package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.person.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
// ioc.xml 제공
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/ioc.xml"})
// 확인
public class iocDITest {

	// ioc.xml을 바탕으로 스프링 빈이 잘 생성되었는지 확인
	// setter-boardService, constructor-boardServiceC 주입 확인
	
	// DI 
	// 스프링 빈중에 호환되는 타입의 빈이 있을 때 주입
	@Autowired
	ApplicationContext context;

	@Resource(name="boardService")
	BoardService boardService;
	
	@Resource(name="boardServiceC")
	BoardService boardServiceC;
	
	@Resource(name="person")
	Person person;
	
	// person 스프링빈의 age(value), boardRepository(ref) 두 속성에 주입이 잘 됐는지 확인
	@Test 
	public void valueRefTest() {
		/*** Given ***/
		
		/*** When ***/

		/*** Then ***/
		assertEquals(30, person.getAge());
		assertEquals("내용", person.getBoardRepository().getBoard(1).getContent());
		assertNotNull(person.getBoardRepository());
	}
	
	@Test
	public void DIAutowiredTest() {
		/*** Given ***/
		
		/*** When ***/

		/*** Then ***/
		assertNotNull(boardService);
	}
	
	// boardService, boardServiceC 스프링 빈에 주입한 boardRepositoy 스프링빈은 동일한 빈 임으로 
	// 두 객체의 getter 메서드를 통해 얻어온 boardRepository 객체는 동일해야 한다.
	@Test
	public void repositorySameTest() {
		/*** Given ***/
		
		/*** When ***/
		
		/*** Then ***/
		assertEquals(boardService.getBoardRepository(), boardServiceC.getBoardRepository());
	}

	// 스프링 컨테이너를 주입받아 DL을 통해 boardService 스프링 빈이 제대로 생성되는지 확인
	@Test
	public void DItest() {
		/*** Given ***/
		
		/*** When ***/
		BoardServiceI boardService = context.getBean("boardService", BoardServiceI.class);
		BoardVo boardVo = boardService.getBoard(1);

		/*** Then ***/
		assertEquals("첫번째 글", boardVo.getTitle());
	}

}
