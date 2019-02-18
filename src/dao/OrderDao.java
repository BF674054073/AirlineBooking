package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import entity.Flight;
import entity.Order;

public interface OrderDao {

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
	boolean updteOrder(String flightNumber, Timestamp takeoffTime) throws SQLException;

	/**
	 * 根据订单号查询Order
	 * 
	 * @param orderNum
	 *            订单号
	 * @return Order实体
	 * @throws SQLException
	 */
	Order findOrderByOrderNum(int orderNum) throws SQLException;

	/**
	 * 根据航班号和用户身份证号查询Order
	 * 
	 * @param flightNum
	 *            航班号
	 * @param userId
	 *            身份证号
	 * @param takeoffTime
	 *            出发时间
	 * @return Order实体
	 * @throws SQLException
	 */
	Order findOrderByFlightNumAnduserId(String flightNum, String userId, Timestamp takeoffTime) throws SQLException;

	/**
	 * 根据航班号和出发时间查询航班
	 * 
	 * @param flightNumber
	 * @param timestamp
	 * @return
	 * @throws SQLException
	 */

	List<Order> findOrderByFlightNumAndTime(String flightNumber, Timestamp timestamp) throws SQLException;

	/**
	 * 根据用户名和航班号预定机票
	 * 
	 * @param orderNum
	 *            订单号(随机8位)
	 * @param flight
	 *            航班实体
	 * @param user
	 *            用户实体
	 * @return 成功返回r>=0，失败r<0；
	 * @throws SQLException
	 * @throws OrderBookingException
	 */
	boolean addOrderbyNumAndUser(int orderNum, Flight flight, String name, String userId, String status) throws SQLException;

	/**
	 * 根据用户身份证号查询Order
	 * 
	 * @param userId
	 *            身份证号
	 * @return Order数组
	 * @throws SQLException
	 */
	Order[] findOrderByuserId(String userId) throws SQLException;

	/**
	 * 根据订单号删除订单
	 * 
	 * @param orderNumber
	 * @return
	 * @throws SQLException
	 */
	boolean delOrderByOrderNumber(int orderNumber) throws SQLException;

	/**
	 * 根据订单号,订单状态修改订单状态
	 */
	boolean updateOrderStatusByOrderNumber(int orderNumber, String status) throws SQLException;

}
