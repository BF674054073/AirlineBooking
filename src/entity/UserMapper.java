package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.RowMapperObject;

public class UserMapper implements RowMapperObject{

	public Object rowMapperObject(ResultSet rs) throws SQLException {
		User user = new User();
		user.setIdentityNumber(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getString("sex"));
		user.setPhoneNum(rs.getString("phoneNumber"));
		return user;
	}

}
