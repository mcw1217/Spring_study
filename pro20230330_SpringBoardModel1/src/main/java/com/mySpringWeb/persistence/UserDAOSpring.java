package com.mySpringWeb.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mySpringWeb.domain.UserVO;

@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String USER_INSERT = "insert into User(uid,passwd,name,role) values ((select nvl(max(seq),0)+1 from User),?,?,?)";
	private final String USER_UPDATE ="update User set passwd=?, name=?, role=? where uid=?";
	private final String USER_DELETE ="delete User where uid=? and passwd=?";
	private final String USER_GET ="select * from User where uid=?";
	private final String USER_LIST = "select * from users";
	
	public void insertUser(UserVO vo)
	{
		System.out.println("===> Spring JDBC로 insertUser() 기능 처리");
		jdbcTemplate.update(USER_INSERT, vo.getUid(),vo.getPasswd(),vo.getName(),vo.getRole());
	}
	public void updateUser(UserVO vo)
	{
		System.out.println("===> Spring JDBC로 updateUser() 기능 처리");
		jdbcTemplate.update(USER_UPDATE, vo.getPasswd(),vo.getName(),vo.getRole(),vo.getUid());
		
	}
	public void deleteUser(UserVO vo)
	{
		System.out.println("===> Spring JDBC로 deleteUser() 기능 처리");
		jdbcTemplate.update(USER_DELETE,vo.getUid(),vo.getPasswd() );
	}
	public UserVO getUser(UserVO vo)
	{
		System.out.println("===> Spring JDBC로 getUser() 기능 처리");
		Object args [] = {vo.getUid()};
		UserVO user = jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
		return user;
		
	}
	public List<UserVO> getUserList()
	{
		System.out.println("===> Spring JDBC로 getUserList() 기능 처리");
		List<UserVO> Userlist = jdbcTemplate.query(USER_LIST,new UserRowMapper());
		return Userlist;
		
	}
}


