package manager;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import entity.Flight;
import entity.Order;
import exception.OrderException;

public interface OrderManager {

	/**
	 * 管理员修改航班起飞时间时，同步修改订票库中的时间
	 * 
	 * @param flightNumber
	 *            航班号
	 * @param takeoffTime
	 *            起飞时间
	 * @return 成功返回r>=0，失败r<0；
	 * @throws SQLException
	 * @throws OrderBookingException
	 */
	boolean updteOrder(String flightNumber, Timestamp takeoffTime) throws OrderException;

	/**
	 * 根据订单号查询Order
	 * 
	 * @param orderNum
	 *            订单号
	 * @return Order实体
	 * @throws SQLException
	 */
	Order findOrderByOrderNum(int orderNum) throws OrderException;

	/**
	 * 根据航班号和用户身份证号查询Order
	 * 
	 * @param flightNum
	 *            航班号
	 * @param userName
	 *            身份证号
	 * @return Order实体
	 * @throws SQLException
	 */
	Order findOrderByFlightNumAnduserId(String flightNum, String userId) throws OrderException;

	/**
	 * 根据航班号查询Order
	 * 
	 * @param flightNumber
	 * @return Order数组
	 * @throws SQLException
	 */
	Order[] findOrderByFlightNum(String flightNumber) throws OrderException;

	/**
	 * 
	 * @param flight
	 *            航班信息
	 * @param name
	 *            订票人名
	 * @param userId
	 *            订票人身份证
	 * @param userName
	 *            账户名
	 * @return
	 * @throws OrderException
	 */
	int addOrderbyNumAndUser(Flight flight, String name, String userId, String userName, String status) throws OrderException;

	/**
	 * 根据用户身份证号查询Order
	 * 
	 * @param userId
	 *            身份证号
	 * @return Order数组
	 * @throws SQLException
	 */
	Order[] findOrderByuserId(String userId) throws OrderException;

	/**
	 * 根据订单号退票
	 * 
	 * @param orderNum
	 * @return 成功返回r>=0，失败r<0；
	 * @throws SQLException
	 * @throws OrderBookingException
	 */
	boolean delOrderByOrderNum(int orderNum) throws OrderException;

	/**
	 * 根据订单号修改订单状态
	 */
	boolean updateOrderStatusByOrderNumber(int orderNumber, String status) throws OrderException;

	List<Order> findOrderByFlightNumAndTime(String flightNumber, Timestamp timestamp) throws OrderException;
}
