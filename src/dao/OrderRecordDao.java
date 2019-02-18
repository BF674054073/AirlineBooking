package dao;

import java.sql.SQLException;
import java.util.List;

import entity.OrderRecord;

public interface OrderRecordDao {
	boolean addOrderRecord(String userName, int orderNumber) throws SQLException;

	List<OrderRecord> findOrderNumByUserName(String userName) throws SQLException;

	List<OrderRecord> findAll() throws SQLException;

	boolean delbyOrderNum(int orderNumber) throws SQLException;
}
