package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import entity.Flight;

public interface FlightDao {

	/**
	 * 查询所有航班
	 * 
	 * @return
	 */
	List<Flight> findAllFlights() throws SQLException;

	/**
	 * 根据航班号查询航班
	 * 
	 * @param flightNumber
	 * @return
	 * @throws SQLException
	 */

	List<Flight> findFlightByFlightNumber(String flightNumber) throws SQLException;

	/**
	 * 增加航班 添加航班信息，航班编号、出发日期不能相同。
	 * 
	 * @param flight
	 * @return
	 */
	boolean addFlight(Flight flight) throws SQLException;

	/**
	 * 修改航班 根据航班号修改，航班号不可修改，可以修改起飞时间
	 * 
	 * @param flight
	 * @return
	 */
	boolean updateFlight(Timestamp newTime, Flight flight) throws SQLException;

	boolean updateFlightTickets(int tickets, Flight flight) throws SQLException;

	/**
	 * 删除航班
	 * 
	 * @param flightId
	 * @return
	 */
	boolean deleteFlight(String flightId, Timestamp takeoffTime) throws SQLException;

	/**
	 * 按出发地、目的地和出发时间、航班号等 多字段查询
	 */
	List<Flight> findFlight(String startPlace, String endPlace, String takeoffTime) throws SQLException;

	/**
	 * 根据出发地查询航班信息
	 * 
	 * @param start
	 *            出发地
	 * @return 航班数组
	 * @throws SQLException
	 */
	List<Flight> findFlightByStart(String start) throws SQLException;

	/**
	 * 根据目的地查询航班信息
	 * 
	 * @param end
	 *            目的地
	 * @return 航班数组
	 * @throws SQLException
	 */
	List<Flight> findFlightByEnd(String end) throws SQLException;

	/**
	 * 根据出发日期查询航班信息
	 * 
	 * @param time
	 *            出发日期
	 * @return 航班数组
	 * @throws SQLException
	 * @throws TicketBookingException
	 */
	List<Flight> findFlightByTakeoffTime(Timestamp time) throws SQLException;

	/**
	 * 在添加航班时先调用此方法向数据库里查询是否存在同一天的同航班号的航班
	 * 
	 * @param flightNumber
	 * @param date
	 * @return 若存在，则返回flight，不存在则返回null；
	 * @throws SQLException
	 */
	Flight findFlightByNumAndDate(String flightNumber, Timestamp date) throws SQLException;

}
