package com.mySpringWeb.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mySpringWeb.domain.UserVO;

public class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setUid(rs.getString("uid"));
		user.setPasswd(rs.getString("passwd"));
		user.setName(rs.getString("name"));
		user.setRole(rs.getString("role"));
		return user;
	}
	

}
