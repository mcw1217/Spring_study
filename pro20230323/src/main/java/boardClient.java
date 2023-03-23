import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mySpringWeb.domain.BoardVO;
import com.mySpringWeb.service.BoardService;

public class boardClient {
	public static void main(String[] args)
	{
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService)factory.getBean("boardService");
		List<BoardVO> a =  boardService.getBoardList();
		for(BoardVO vo: a)
		{
			System.out.println(vo);
		}
	}
		/*
		 * Connection conn = JDBCUtil.getConnection(); if(conn != null) {
		 * System.out.println("생성 OK"); }
		 */
		/*
		  BoardDAO dao = new BoardDAO(); 
		  BoardVO vo = new BoardVO();
		  vo.setSeq(2);
		  BoardVO a = dao.getBoard(vo); 
		  System.out.println(a);*/
/*
		  BoardDAO dao = new BoardDAO(); 
		  BoardVO vo = new BoardVO();
		  vo.setSeq(2);
		  vo.setContent("사과나asadsfdf무 어엉ㅋㅋ");
		  vo.setTitle("테스트 asdf제목");
		  vo.setWriter("테스트작asadsfdfasdf성자");;
		  dao.insertBoard(vo);*/
		/*
		BoardDAO dao = new BoardDAO();
		BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		List<BoardVO> a = dao.getBoardList(vo);
		for(BoardVO board : a) {
			System.out.println(board);			
		}
		 */
 
	
}
