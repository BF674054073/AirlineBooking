package manager.impl;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import objectfactory.ObjectFactory;
import util.Transaction;

import dao.AdminDao;
import dao.FlightDao;

import entity.Flight;
import exception.FlightException;
import manager.FlightManager;

public class FlightManagerImpl implements FlightManager {

    FlightDao flightDao = (FlightDao) ObjectFactory.getObject("flightDao");
    Transaction transaction = (Transaction) ObjectFactory.getObject("transaction");

    public boolean addFlight(Flight flight) throws FlightException {
        try {
            transaction.start();
            Flight findFlightByNumAndDate = flightDao.findFlightByNumAndDate(flight.getFlightNumber(), flight.getTakeoffTime());
            if (findFlightByNumAndDate != null) {
                transaction.rollback();
                throw new FlightException("该航班班次已存在");
            }
            boolean b = flightDao.addFlight(flight);
            if (!b) {
                transaction.rollback();
            }
            transaction.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteFlight(String flightId, Timestamp takeoffTime) throws FlightException {
        try {
            transaction.start();
            Flight flight = flightDao.findFlightByNumAndDate(flightId, takeoffTime);
            if (flight == null) {
                return false;
            }
            flightDao.deleteFlight(flightId, takeoffTime);
            transaction.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }

    public List<Flight> findAllFlights() throws FlightException {
        List<Flight> allFlights = null;
        try {
            transaction.start();
            allFlights = flightDao.findAllFlights();
            transaction.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FlightException(e.getMessage());
        }
        return allFlights;
    }

    public List<Flight> findFlightByFlightNumber(String flightNumber) throws FlightException {
        List<Flight> list = null;
        try {
            transaction.start();
            list = flightDao.findFlightByFlightNumber(flightNumber);
            transaction.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FlightException(e.getMessage());
        }
        return list;
    }

    public boolean updateFlight(Timestamp newTime, String flightNumber, Timestamp takeoffTime) throws FlightException {
        Flight flight = null;
        try {
            transaction.start();
            List<Flight> flights = flightDao.findFlightByFlightNumber(flightNumber);
            for (Flight fli : flights) {
                if (takeoffTime.compareTo(fli.getTakeoffTime()) == 0) {
                    flight = fli;
                    break;
                }
            }
            boolean b = flightDao.updateFlight(newTime, flight);
            transaction.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Flight> findFlight(String startPlace, String endPlace, String takeoffTime) throws FlightException {
        List<Flight> list = null;
        try {
            transaction.start();
            list = flightDao.findFlight(startPlace, endPlace, takeoffTime);
            transaction.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Flight> findFlightByEnd(String end) throws FlightException {
        List<Flight> flights = null;
        try {
            transaction.start();
            flights = flightDao.findFlightByEnd(end);
            transaction.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flights;
    }

    public List<Flight> fingdFlightByStart(String start) throws FlightException {
        List<Flight> list = null;
        try {
            transaction.start();
            list = flightDao.findFlightByStart(start);
            transaction.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<Flight> findFlightByTakeoffTime(Timestamp time) throws FlightException {
        List<Flight> flights = null;
        try {
            transaction.start();
            flights = flightDao.findFlightByTakeoffTime(time);
            transaction.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flights;
    }

    public Flight findFlightByNumAndDate(String flightNumber, Timestamp date) throws FlightException {
        Flight flight = null;
        try {
            transaction.start();
            flight = flightDao.findFlightByNumAndDate(flightNumber, date);
            transaction.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flight;
    }

    public boolean updateFlightTickets(int tickets, Flight flight) throws FlightException {
        boolean b = false;
        try {
            transaction.start();
            b = flightDao.updateFlightTickets(tickets, flight);
            if (!b) {
                transaction.rollback();
            }
            transaction.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }

    public static void main(String[] args) {
        FlightManagerImpl flightManagerImpl = new FlightManagerImpl();
        try {
            List<Flight> flight = flightManagerImpl.findFlight("太原", null, null);
            System.out.println("AAA");
            for (Flight f : flight
            ) {
                System.out.println(f);
            }
        } catch (FlightException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
