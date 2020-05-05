package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.adService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    adService serv;

    @GetMapping("/")
    public String index(){
        return "home/index";
    }
    @GetMapping("home/contract")
    public String contractDetails(){
        return "home/contract";
    }

    @GetMapping("home/displayAddresses")
    public String displayAllAddresses(Model model){
        List<Address> list = serv.displayAllAddresses();
        model.addAttribute("addresses", list);
        return "home/displayAddresses";
    }
    @GetMapping("home/displayCustomers")
    public String displayAllCustomers(Model model){
        List<Customer> list = serv.displayAllCustomers();
        model.addAttribute("customers", list);
        return "home/displayCustomers";
    }
    @GetMapping("home/displayCar")
    public String displayAllCars(Model model){
        List<Car> list = serv.displayAllCars();
        model.addAttribute("cars", list);
        return "home/displayCar";
    }
    @GetMapping("home/displayTypes")
    public String displayAllTypes(Model model){
        List<Type> list = serv.displayAllTypes();
        model.addAttribute("types", list);
        return "home/displayTypes";
    }
    @GetMapping("home/displayRentals")
    public String displayAllRentals(Model model){
        List<Rental> list = serv.displayAllRentals();
        model.addAttribute("rentals", list);
        return "home/displayRentals";
    }
    @PostMapping("/createAddress")
    public String addAddress(@ModelAttribute Address address) {
        serv.addAddress(address);
        return "home/contract";
    }
    @PostMapping("/createCustomer") //change return
    public String addCustomer(@ModelAttribute Customer customer) {
        serv.addCustomer(customer);
        return "home/contract";
    }
    @PostMapping("/createCar")
    public String addCar(@ModelAttribute Car car){
        serv.addCar(car);
        return "home/contract";
    }
    @PostMapping("/createRental")
    public String addRental(@ModelAttribute Rental rental){
        serv.addRental(rental);
        return "home/contract";
    }
    @GetMapping("/deleteCustomer/{id}") //doesn't work!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String deleteCustomer(@PathVariable ("id") int id) {
        boolean delete = serv.deleteOneCustomer(id);
        if (!delete) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/deleteRental/{id}")
    public String deleteRental(@PathVariable ("id") int id) {
        boolean delete = serv.deleteRental(id);
        if (!delete) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/deleteAddress/{id}")
    public String deleteAddress(@PathVariable ("id") int id) {
        boolean delete = serv.deleteAddress(id);
        if (!delete) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable ("id") int id) {
        boolean delete = serv.deleteCar(id);
        if (!delete) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable ("id") int id) {
        boolean delete = serv.deleteType(id);
        if (!delete) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    @GetMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", serv.findCustomer(id));
        return "home/updateCustomer";
    }
    @PostMapping("/updateCustomer")
    public String update(@ModelAttribute Customer customer){
        serv.updateCustomer(customer);
        return "redirect:/";
    }
    @GetMapping("/updateAddress/{id}")
    public String updateAddress(@PathVariable("id") int id, Model model){
        model.addAttribute("address", serv.findAddress(id));
        return "home/updateAddress";
    }
    @PostMapping("/updateAddress")
    public String update(@ModelAttribute Address address){
        serv.updateAddress(address);
        return "redirect:/";
    }
    @GetMapping("/updateCar/{id}")
    public String updateCar(@PathVariable("id") int id, Model model){
        model.addAttribute("car", serv.findCar(id));
        return "home/updateCar";
    }
    @PostMapping("/updateCar")
    public String update(@ModelAttribute Car car){
        serv.updateCar(car);
        return "redirect:/";
    }
    @GetMapping("/updateRental/{id}")
    public String updateType(@PathVariable("id") int id, Model model){
        model.addAttribute("type", serv.findRental(id));
        return "home/updateRental";
    }
    @PostMapping("/updateRental")
    public String update(@ModelAttribute Rental rental){
        serv.updateRental(rental);
        return "redirect:/";
    }
/*
    @GetMapping("/delete/{mobilePhone}")
    public String deleteRental(@PathVariable String mobilePhone ) {
        boolean delete = serv.deleteOneCustomer(mobilePhone);
        if (delete) {
            return "home/deleteCustomer";
        } else {
            return "home/error";
        }
    }
    How to retrive from url http://localhost:8081/deleteOneCustomer?mobilePhone=12345678 only value of mobilePhone????
    how to write action in form and path for controller in that case?
     */



}
