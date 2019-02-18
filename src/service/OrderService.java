package service;

import entity.Order;

public interface OrderService {
	/**
	 * 订票
	 * @param id
	 * @param fltghtNumber
	 * @return
	 */
	boolean addOrder(int id, int fltghtNumber);
	
	Order updateOrder(Order order);
	
	boolean deleteOrder(int id);
	
	Order findOrderById(int id);
}
