package com.mySpringWeb.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mySpringWeb.common.JDBCUtil;
import com.mySpringWeb.domain.BoardVO;
import com.mySpringWeb.domain.UserVO;

@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String USER_INSERT = "insert into users(uid,passwd,name,role) values(?,?,?,?)";
	private final String USER_UPDATE = "update users set passwd=?, name=?, role=?, where uid=?";
	private final String USER_DELETE = "delete users where uid=? and passwd=?";
	private final String USER_GET = "select * from users where uid=?";
	private final String USER_LIST = "select * from users;";
	
	public void insertUser(UserVO vo)
	{
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		try {
		conn = JDBCUtil.getConnection();
		pstmt = conn.prepareStatement(USER_INSERT);
		pstmt.setString(1,vo.getUid());
		pstmt.setString(2,vo.getPasswd());
		pstmt.setString(3,vo.getName());
		pstmt.setString(4,vo.getRole());
		pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:insert_User]:" +e.getMessage());
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	public void updateUser(UserVO vo)
	{
		System.out.println("===> JDBC로 updateUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_UPDATE);
			pstmt.setString(1, vo.getPasswd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getRole());
			pstmt.setString(4, vo.getUid());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:insert_user]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(pstmt, conn);
		}
	}
	public void deleteUser(UserVO vo)
	{
		System.out.println("===> JDBC로 deleteUser() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_DELETE);
			pstmt.setString(1, vo.getUid());
			pstmt.setString(2, vo.getPasswd());
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:delete_user]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(pstmt, conn);
		}
	}
	public UserVO getUser(UserVO vo)
	{
		System.out.println("===> JDBC로 getUser() 기능 처리");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getUid());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				user = new UserVO();
				user.setUid(rs.getString("uid"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));

			}
			
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:get]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(rs,pstmt, conn);
		}
		return user;
	}
	public List<UserVO> getUserList()
	{
		System.out.println("===> JDBC로 getUserList() 기능 처리");
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_LIST);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				UserVO user = new UserVO();
				user.setUid(rs.getString("uid"));
				user.setPasswd(rs.getString("passwd"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				userList.add(user);
			}
			
		}catch(Exception e)
		{
			System.out.println("Exception[JDBC:getBoardList]:" +e.getMessage());
		}finally
		{
			JDBCUtil.close(rs,pstmt, conn);
		}
		
		return userList;
	}
}
