package com.example.demo.Service;

import com.example.demo.Model.*;

import com.example.demo.Repository.adRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adService {
    @Autowired
    adRepository repository;

    public List<Address> displayAllAddresses(){
        return repository.displayAllAddresses();
    }
    public List<Customer> displayAllCustomers(){
        return repository.displayAllCustomers();
    }
    public List<Car> displayAllCars(){
        return repository.displayAllCars();
    }
    public List<Type> displayAllTypes(){
        return repository.displayAllTypes();
    }
    public List<Rental> displayAllRentals(){
        return repository.displayAllRentals();
    }
    public Address addAddress(Address address){
        return repository.addAddress(address);
    }
    public Customer addCustomer(Customer customer){
        return repository.addCustomer(customer);
    }
    public Car addCar(Car car){
        return repository.addCar(car);
    }
    public Rental addRental(Rental rental){
        return repository.addRental(rental);
    }
    public Boolean deleteRental(int id){
        return repository.deleteRental(id);
    }
    public Boolean deleteOneCustomer(int id){
        return repository.deleteOneCustomer(id);
    }
    public Boolean deleteAddress(int id){
        return repository.deleteAddress(id);
    }
    public Boolean deleteCar(int id){
        return repository.deleteCar(id);
    }
    public Boolean deleteType(int id){
        return repository.deleteType(id);
    }
    public Customer findCustomer(int id){return repository.findCustomer(id);}
    public Customer updateCustomer(Customer customer){return repository.updateCustomer(customer);}
    public Address findAddress(int id){return repository.findAddress(id);}
    public Address updateAddress(Address address){return repository.updateAddress(address);}
    public Car findCar(int id){return repository.findCar(id);}
    public Car updateCar(Car car){return repository.updateCar(car);}
    public Rental findRental(int id){return repository.findRental(id);}
    public Rental updateRental(Rental rental){return repository.updateRental(rental);}
}
