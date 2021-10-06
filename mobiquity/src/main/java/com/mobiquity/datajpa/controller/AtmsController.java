package com.mobiquity.datajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobiquity.datajpa.dto.Atms;
import com.mobiquity.datajpa.service.AtmsService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AtmsController {
	@Autowired
	AtmsService atmsService;

	@GetMapping("/atmslist")
	public ResponseEntity<List<Atms>> getAllEmployees(@RequestParam(required = false) String city) {
		try {
			List<Atms> atmsdata = new ArrayList<Atms>();

			if (city == null)
				atmsService.findAll().forEach(atmsdata::add);
			else
				atmsService.findByAtmsaddressContaining(city).forEach(atmsdata::add);

			if (atmsdata.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(atmsdata, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
