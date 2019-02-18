package service;

import java.util.Date;

import entity.Flight;

public interface AdminService {
	/**
	 * 添加航班
	 * @param flight
	 * @return
	 */
	boolean addFlight(Flight flight);
	/**
	 * 删除航班
	 * @param fltghtNumber
	 * @return
	 */
	boolean deleteFlight(int fltghtNumber);
	
	/**
	 * 修改航班信息
	 * 航班号不可以改
	 * @param flight
	 * @return
	 */
	Flight updateFlight(Flight flight);
	
	/**
	 * 按出发地、目的地和日期查询 多字段查询
	 */
	Flight[] findFlight(String startPlace, String endPlace, Date time);
	/**
	 * 按航班号查询
	 * @param fltghtNumber
	 * @return
	 */
	Flight findFlight(int fltghtNumber);
}
