package com.spring.basic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/records")
public class RecordController {
	
	@GetMapping("/viewAllRecord")
	public List<Record> showAllRecord(){
		return null;
	}

}
