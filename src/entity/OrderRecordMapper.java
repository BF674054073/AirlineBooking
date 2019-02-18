package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.RowMapperObject;

public class OrderRecordMapper implements RowMapperObject {

	public Object rowMapperObject(ResultSet rs) throws SQLException {
		OrderRecord orderRecord = new OrderRecord();
		orderRecord.setUserName(rs.getString("userName"));
		orderRecord.setOrderNumber(rs.getInt("orderNumber"));
		return orderRecord;
	}

}
