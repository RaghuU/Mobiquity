package com.mobiquity.datajpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.datajpa.dto.Atms;

@Service
public class AtmsService {

	@Autowired
	RestTemplate restTemplate;

	public List<Atms> findAll() throws JsonMappingException, JsonProcessingException {

		String responseEntity = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
		String[] res = responseEntity.split("\n");
		System.out.println(res[1]);
		List<Atms> response = new ObjectMapper().readValue(res[1], new TypeReference<List<Atms>>() {
		});
		return response;

	}

	public Iterable<Atms> findByAtmsaddressContaining(String city)
			throws JsonMappingException, JsonProcessingException {
		String responseEntity = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
		String[] res = responseEntity.split("\n");
		System.out.println(res[1]);
		List<Atms> response = new ObjectMapper().readValue(res[1], new TypeReference<List<Atms>>() {
		});
		List<Atms> citylist = response.stream().filter(a -> a.getAddress().getCity().equals(city))
				.collect(Collectors.toList());
		return citylist;
	}

}
