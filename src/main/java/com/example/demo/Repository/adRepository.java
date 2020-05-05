package com.example.demo.Repository;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class adRepository {
    @Autowired
    JdbcTemplate template;
//DISPLAY
    public List<Address> displayAllAddresses(){
        String sql = "SELECT * FROM addresses";
        RowMapper<Address> rowMapper = new BeanPropertyRowMapper<>(Address.class);
        return template.query(sql, rowMapper);
    }
    public List<Customer> displayAllCustomers(){
        String sql = "SELECT * FROM customers";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }
    public List<Car> displayAllCars(){
        String sql = "SELECT * FROM cars";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql,rowMapper);
    }
    public List<Type> displayAllTypes(){
        String sql = "SELECT * FROM types";
        RowMapper<Type> rowMapper = new BeanPropertyRowMapper<>(Type.class);
        return template.query(sql,rowMapper);
    }
    public List<Rental> displayAllRentals(){
        String sql ="SELECT * FROM rentals";
        RowMapper<Rental> rowMapper = new BeanPropertyRowMapper<>(Rental.class);
        return template.query(sql, rowMapper);
    }
    //ADD
    public Address addAddress(Address address){
        String sql ="INSERT INTO addresses (streetName, zipCode, city) VALUES (?,?,?)";
        template.update(sql, address.getStreetName(), address.getZipCode(), address.getCity());
        return null;
    }
    public Customer addCustomer(Customer customer){
        String sql ="INSERT INTO customers (firstName, lastName, mobilePhone, email, driverLicenceNumber, driverSinceDate, address_id) VALUES (?,?,?,?,?,?,?)";
        template.update(sql, customer.getFirstName(), customer.getLastName(), customer.getMobilePhone(), customer.getEmail(), customer.getDriverLicenceNumber(), customer.getDriverSinceDate(), customer.getAddress_id());
        return null;
    }
    public Car addCar(Car car){
        String sql = "INSERT INTO cars (brand, model, plate, regDate, odometer, fuelType, type_id) VALUES (?,?,?,?,?,?,?)";
        template.update(sql, car.getBrand(),car.getModel(), car.getPlate(), car.getRegDate(), car.getOdometer(), car.getFuelType(),
                car.getType_id());
        return null;
    }
    public Rental addRental(Rental rental){
        String sql = "INSERT INTO rentals (fromDate, fromTime, toDate, toTime, maxKM, km, customer_id, car_id) VALUES(?,?,?,?,?,?,?,?)";
        template.update(sql, rental.getFromDate(), rental.getFromTime(), rental.getToDate(), rental.getToTime(),
                rental.getMaxKM(), rental.getKm(), rental.getCustomer_id(), rental.getCar_id());
        return null;
    }
    //DELETE
    public Boolean deleteRental(int id){
        String sqlR = "DELETE FROM rentals WHERE rentals.rental_id = ?";
        return template.update(sqlR, id) < 0;
    }
    public Boolean deleteOneCustomer(int id){ //doesn't work'
        String sqlR = "DELETE FROM customers WHERE customers.customer_id = ?";
        return template.update(sqlR, id) < 0;
    }
    public Boolean deleteAddress(int id){ 
        String sqlR = "DELETE FROM addresses WHERE addresses.address_id = ?";
        return template.update(sqlR, id) < 0;
    }
    public Boolean deleteCar(int id){ //doesn't work'
        String sqlR = "DELETE FROM cars WHERE cars.car_id = ?";
        return template.update(sqlR, id) < 0;
    }
    public Boolean deleteType(int id){ //doesn't work'
        String sqlR = "DELETE FROM cars WHERE cars.car_id = ?";
        return template.update(sqlR, id) < 0;
    }
    public Customer findCustomer(int id){
        String sql = "SELECT * FROM customers WHERE customers.customer_id=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer c = template.queryForObject(sql,rowMapper,id);
        return c;
    }
    public Customer updateCustomer(Customer customer){ //why id needed????????
        String sql = "UPDATE customers SET firstName=?, lastName=?, mobilePhone=?, email=?, driverLicenceNumber=?, driverSinceDate=?, address_id=? WHERE customers.customer_id=?";
        template.update(sql,customer.getFirstName(), customer.getLastName(), customer.getMobilePhone(), customer.getEmail(), customer.getDriverLicenceNumber(), customer.getDriverSinceDate(), customer.getAddress_id(),customer.getCustomer_id());
        return null;
    }
    public Address findAddress(int id){
        String sql = "SELECT * FROM addresses WHERE addresses.address_id=?";
        RowMapper<Address> rowMapper = new BeanPropertyRowMapper<>(Address.class);
        Address a = template.queryForObject(sql,rowMapper,id);
        return a;
    }
    public Address updateAddress(Address address){
        String sql = "UPDATE addresses SET streetName=?, zipCode=?, city=? WHERE addresses.address_id=?";
        template.update(sql,address.getStreetName(), address.getZipCode(), address.getCity(), address.getAddress_id());
        return null;
    }
    public Car findCar(int id){
        String sql = "SELECT * FROM cars WHERE cars.car_id=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car c = template.queryForObject(sql,rowMapper,id);
        return c;
    }
    public Car updateCar(Car car){ //why id needed????????
        String sql = "UPDATE cars SET brand=?, model=?, plate=?, regDate=?, odometer=?, fuelType=?, type_id=? WHERE cars.car_id=?";
        template.update(sql,car.getBrand(),car.getModel(), car.getPlate(), car.getRegDate(), car.getOdometer(), car.getFuelType(),
                car.getType_id(),car.getCar_id());
        return null;
    }
    public Rental findRental(int id){
        String sql = "SELECT * FROM rentals WHERE rentals.rental_id=?";
        RowMapper<Rental> rowMapper = new BeanPropertyRowMapper<>(Rental.class);
        Rental r = template.queryForObject(sql,rowMapper,id);
        return r;
    }
    public Rental updateRental(Rental rental){ //why id needed????????
        String sql = "UPDATE rentals SET fromDate=?, fromTime=?, toDate=?, toTime=?, maxKM=?, km=?, customer_id=?, car_id=? WHERE rentals.rental_id=?";
        template.update(sql,rental.getFromDate(), rental.getFromTime(), rental.getToDate(), rental.getToTime(),
                rental.getMaxKM(), rental.getKm(), rental.getCustomer_id(), rental.getCar_id(),rental.getRental_id());
        return null;
    }
/*
    public Boolean deleteOneCustomer(String mobilePhone) { //doesn't work'
        String sql = ("SELECT * FROM customers WHERE customers.mobilePhone=?");
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer c = template.queryForObject(sql, rowMapper, mobilePhone);

        String sqlA = "DELETE FROM addresses WHERE addresses.address_id = ?";
        template.update(sqlA, c.getAddress_id());

        String sqlR = "DELETE FROM rentals WHERE rentals.customer_id = ?";
        template.update(sqlR, c.getCustomer_id());

        String sqlC = "DELETE FROM customers WHERE customers.mobilePhone = ?";
        return template.update(sqlC, mobilePhone) < 0;
    }

 */
}
