package manager;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import entity.Flight;
import exception.FlightException;

public interface FlightManager {
	List<Flight> findAllFlights() throws FlightException;

	/**
	 * 航班号查找航班
	 * 
	 * @param flightNumber
	 * @return
	 * @throws FlightException
	 */
	List<Flight> findFlightByFlightNumber(String flightNumber) throws FlightException;

	/**
	 * 添加航班
	 * 
	 * @param flight
	 * @return
	 * @throws FlightException
	 */
	boolean addFlight(Flight flight) throws FlightException;

	/**
	 * 删除航班
	 * 
	 * @param flightNumber
	 * @param takeoffTime
	 * @return
	 * @throws FlightException
	 */
	boolean deleteFlight(String flightNumber, Timestamp takeoffTime) throws FlightException;

	/**
	 * 更新航班起飞时间
	 * 
	 * @param newTime
	 * @param flightNumber
	 * @param takeoffTime
	 * @return
	 * @throws FlightException
	 */
	boolean updateFlight(Timestamp newTime, String flightNumber, Timestamp takeoffTime) throws FlightException;

	/**
	 * 按出发地、目的地和出发时间、航班号等 多字段查询（暂未实现）
	 */
	List<Flight> findFlight(String startPlace, String endPlace, String takeoffTime) throws FlightException;

	/**
	 * 根据出发地查询航班信息
	 * 
	 * @param start
	 *            出发地
	 * @return 航班数组
	 * @throws SQLException
	 */
	List<Flight> fingdFlightByStart(String start) throws FlightException;

	/**
	 * 根据目的地查询航班信息
	 * 
	 * @param end
	 *            目的地
	 * @return 航班数组
	 * @throws SQLException
	 */
	List<Flight> findFlightByEnd(String end) throws FlightException;

	/**
	 * 根据出发日期查询航班信息
	 * 
	 * @param time
	 *            出发日期
	 * @return 航班数组
	 * @throws SQLException
	 * @throws TicketBookingException
	 */
	List<Flight> findFlightByTakeoffTime(Timestamp time) throws FlightException;

	/**
	 * 在添加航班时先调用此方法向数据库里查询是否存在同一天的同航班号的航班
	 * 
	 * @param flightNumber
	 * @param date
	 * @return 若存在，则返回flight，不存在则返回null；
	 * @throws SQLException
	 */
	Flight findFlightByNumAndDate(String flightNumber, Timestamp date) throws FlightException;

	/**
	 * 更新航班的余票
	 * 
	 * @param tickets
	 * @param flight
	 * @return
	 * @throws FlightException
	 */
	boolean updateFlightTickets(int tickets, Flight flight) throws FlightException;
}
