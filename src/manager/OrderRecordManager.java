package manager;

import java.sql.SQLException;
import java.util.List;

import entity.OrderRecord;
import exception.OrderRecordException;

public interface OrderRecordManager {
	List<OrderRecord> findOrderByUsername(String userName) throws OrderRecordException;

	boolean addOrderRecord(String userName, int orderNumber) throws OrderRecordException;

	List<OrderRecord> findAll() throws OrderRecordException;

	boolean delbyorderNum(int orderNumber) throws OrderRecordException;
}
