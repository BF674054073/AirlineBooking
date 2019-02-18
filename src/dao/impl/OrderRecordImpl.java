package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderRecordDao;
import entity.OrderRecord;
import entity.OrderRecordMapper;

import util.JDBCUtil;

public class OrderRecordImpl implements OrderRecordDao {

	public boolean addOrderRecord(String userName, int orderNumber) throws SQLException {
		String sql = "insert into ticketRecord values(?,?)";
		int result = JDBCUtil.executeUpdate(sql, userName, orderNumber);
		return result > 0;
	}

	public boolean delbyOrderNum(int orderNumber) throws SQLException {
		String sql = "delete from ticketRecord where orderNumber=?";
		int result = JDBCUtil.executeUpdate(sql, orderNumber);
		return result > 0;
	}

	public List<OrderRecord> findAll() throws SQLException {
		List<OrderRecord> lists = new ArrayList<OrderRecord>();
		String sql = "select * from ticketRecord";
		List<Object> list = JDBCUtil.executeQuery(sql, new OrderRecordMapper());
		for (Object object : list) {
			lists.add((OrderRecord) list);
		}
		return lists;
	}

	public List<OrderRecord> findOrderNumByUserName(String userName) throws SQLException {
		List<OrderRecord> list = new ArrayList<OrderRecord>();
		String sql = "select * from ticketRecord where userName=?";
		List<Object> query = JDBCUtil.executeQuery(sql, new OrderRecordMapper(), userName);
		for (Object object : query) {
			list.add((OrderRecord) object);
		}
		return list;
	}

	public static void main(String[] args) {
		OrderRecordImpl orderRecordImpl = new OrderRecordImpl();
		try {
			List<OrderRecord> list = orderRecordImpl.findOrderNumByUserName("zhangsan");
			for (OrderRecord orderRecord : list) {
				System.out.println("AAA");
				System.out.println(orderRecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
