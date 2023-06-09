package com.mySpringWeb.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mySpringWeb.domain.BoardVO;

@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values ((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE ="update board set title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE ="delete board where seq=?";
	private final String BOARD_GET ="select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	public void insertBoard(BoardVO vo)
	{
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	public void updateBoard(BoardVO vo)
	{
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getSeq());
		
	}
	public void deleteBoard(BoardVO vo)
	{
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		Object [] args = {vo.getSeq()};
		jdbcTemplate.update(BOARD_DELETE, args);
	}
	public BoardVO getBoard(BoardVO vo)
	{
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object [] args = {vo.getSeq()};
		BoardVO board = jdbcTemplate.queryForObject(BOARD_GET, args,new BoardRowMapper());
		return board;
	}
	public List<BoardVO> getBoardList()
	{
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardlist = jdbcTemplate.query(BOARD_LIST,new BoardRowMapper());
		return boardlist;
		
	}
}
