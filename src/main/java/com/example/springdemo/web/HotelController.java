package com.example.springdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.domain.Hotel;
import com.example.springdemo.domain.HotelRepository;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelRepository repository;
	
	//@RequestMapping("/all")
	private Iterable<Hotel> list(){
		return repository.findAll();
	}	
	
	@RequestMapping("/{id}")
	public Hotel show(@PathVariable("id") Long id){
    	return repository.findOne(id);
    }

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private Hotel add(){
		Hotel hotel = new Hotel("Astoria",5);
		return repository.save(hotel);
	}
	
	
}
