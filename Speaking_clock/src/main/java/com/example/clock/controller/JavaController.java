package com.example.clock.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clock.service.ClockService;

@RestController
public class JavaController {
	
	@Autowired
	private ClockService clockService;
	
	@GetMapping("/")
	public String convertDate() {
		Date date = new Date();
		
		String convertedDate = this.clockService.convertCurrentTime(date);
		
		return "{Current Time is:-"+convertedDate+" }";
	}

}
