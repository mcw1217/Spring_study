package com.mySpringWeb.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mySpringWeb.common.JDBCUtil;
import com.mySpringWeb.domain.BoardVO;

@Repository
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values ((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE ="update board set title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE ="delete board where seq=?";
	private final String BOARD_GET ="select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	public void insertBoard(BoardVO vo)
	{
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(BOARD_INSERT);
		pstmt.setString(1,vo.getTitle());
		pstmt.setString(2,vo.getWriter());
		pstmt.setString(3,vo.getContent());
		pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:insert_board]:" +e.getMessage());
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	public void updateBoard(BoardVO vo)
	{
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getSeq());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:insert_board]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(pstmt, conn);
		}
	}
	public void deleteBoard(BoardVO vo)
	{
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:delete_board]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(pstmt, conn);
		}
	}
	public BoardVO getBoard(BoardVO vo)
	{
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:get_board]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(rs,pstmt, conn);
		}
		return board;
	}
	public List<BoardVO> getBoardList()
	{
		System.out.println("===> JDBC로 getBoadList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:getBoardList]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(rs,pstmt, conn);
		}
		
		return boardList;
	}
}
