package dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JDBCUtil;

import dao.FlightDao;
import entity.Flight;
import entity.FlightMapper;

public class FlightDaoImpl implements FlightDao {

    public boolean addFlight(Flight flight) throws SQLException {
        String sql = "insert into flight(flightNumber,takeoffTime,flyingTime,startPlace,endPlace,tickets,price) values(?,?,?,?,?,?,?)";
        int result = JDBCUtil.executeUpdate(sql, flight.getFlightNumber(), flight.getTakeoffTime(), flight.getFlyingTime(), flight.getStartPlace(), flight.getEndPlace(), flight.getTickets(), flight
                .getPrice());
        return result > 0;
    }

    public boolean deleteFlight(String flightId, Timestamp takeoffTime) throws SQLException {
        String sql = "delete from flight where flightNumber=? and takeoffTime=?";
        int result = JDBCUtil.executeUpdate(sql, flightId, takeoffTime);
        return result > 0;
    }

    public List<Flight> findAllFlights() throws SQLException {
        List<Flight> flightList = new ArrayList<Flight>();
        String sql = "select * from flight";
        List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper());
        for (Object object : list) {
            flightList.add((Flight) object);
        }
        return flightList;
    }

    public boolean updateFlight(Timestamp newTime, Flight flight) throws SQLException {
        String sql = "update flight set takeoffTime=? where flightNumber=? and takeoffTime=?";
        int result = JDBCUtil.executeUpdate(sql, newTime, flight.getFlightNumber(), flight.getTakeoffTime());
        return result > 0;
    }

    public List<Flight> findFlightByFlightNumber(String flightNumber) throws SQLException {
        List<Flight> list = new ArrayList<Flight>();
        String sql = "select * from flight where flightNumber=?";
        List<Object> listObj = JDBCUtil.executeQuery(sql, new FlightMapper(), flightNumber);
        for (Object obj : listObj) {
            list.add((Flight) obj);
        }
        return list;
    }

    public List<Flight> findFlight(String startPlace, String endPlace, String takeoffTime) throws SQLException {
        List<Flight> flightList = new ArrayList<Flight>();
        if (startPlace.equals(null) && endPlace.equals(null)&& takeoffTime.equals(null)) {
            String sql = "select * from flight";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper());
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        if (startPlace != null && endPlace == null && takeoffTime == null) {
            String sql = "select * from flight where startPlace=?";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper(), startPlace);
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        if (startPlace == null && endPlace != null && takeoffTime == null) {
            String sql = "select * from flight where endPlace=?";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper(), endPlace);
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        if (startPlace == null && endPlace == null && takeoffTime != null) {
            String sql = "select * from flight where takeoffTime=?";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper(), takeoffTime);
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        if (startPlace != null && endPlace != null && takeoffTime == null) {
            String sql = "select * from flight where startPlace=? and endPlace=?";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper(), startPlace, endPlace);
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        if (startPlace != null && endPlace == null && takeoffTime != null) {
            String sql = "select * from flight where startPlace=? and takeoffTime=?";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper(), startPlace, takeoffTime);
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        if (startPlace == null && endPlace != null && takeoffTime != null) {
            String sql = "select * from flight where endPlace=? and takeoffTime=?";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper(), endPlace, takeoffTime);
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        if (startPlace != null && endPlace != null && takeoffTime != null) {
            String sql = "select * from flight where startPlace=? and endPlace=? and takeoffTime=?";
            List<Object> list = JDBCUtil.executeQuery(sql, new FlightMapper(), startPlace, endPlace, takeoffTime);
            for (Object object : list) {
                flightList.add((Flight) list);
            }
        }
        return flightList;
    }

    public List<Flight> findFlightByStart(String start) throws SQLException {
        List<Flight> list = new ArrayList<Flight>();
        String sql = "select * from flight where startPlace=?";
        List<Object> listObj = JDBCUtil.executeQuery(sql, new FlightMapper(), start);
        for (Object obj : listObj) {
            list.add((Flight) obj);
        }
        return list;
    }

    public List<Flight> findFlightByEnd(String end) throws SQLException {
        List<Flight> list = new ArrayList<Flight>();
        String sql = "select * from flight where endPlace=?";
        List<Object> listObj = JDBCUtil.executeQuery(sql, new FlightMapper(), end);
        for (Object obj : listObj) {
            list.add((Flight) obj);
        }
        return list;
    }

    public List<Flight> findFlightByTakeoffTime(Timestamp time) throws SQLException {
        // System.out.println(time);
        List<Flight> list = new ArrayList<Flight>();
        String sql = "select * from flight where takeoffTime=?";
        List<Object> listObj = JDBCUtil.executeQuery(sql, new FlightMapper(), time);
        for (Object object : listObj) {
            list.add((Flight) object);
        }
        return list;
    }

    public Flight findFlightByNumAndDate(String flightNumber, Timestamp date) throws SQLException {
        String sql = "select * from flight where flightNumber='" + flightNumber + "'or date_format(flight.takeoffTime,'%Y-%m-%d %H:%i:%s') LIKE CONCAT('%','" + date + "','%')";
        List<Object> list = new ArrayList<Object>();
        list = JDBCUtil.executeQuery(sql, new FlightMapper());
        Flight flight = null;
        for (Object obj : list) {
            flight = (Flight) obj;
        }
        return flight;
    }

    public boolean updateFlightTickets(int tickets, Flight flight) throws SQLException {
        String sql = "update flight set tickets=? where flightNumber=? and takeoffTime=?";
        int result = JDBCUtil.executeUpdate(sql, tickets, flight.getFlightNumber(), flight.getTakeoffTime());
        return result > 0;
    }

    public static void main(String[] args) {
        FlightDaoImpl flightDaoImpl = new FlightDaoImpl();
        try {
            List<Flight> list = flightDaoImpl.findFlight("太原", null, null);
            for (Flight flight : list) {
                System.out.println(flight);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
