package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SampleModel;
import com.example.demo.repository.SampleRepository;

@RestController
@RequestMapping(value="/", method = RequestMethod.POST)
public class HomeController {
	
	@Autowired
	SampleRepository repo;
	
	@GetMapping("/")
	public String solve() {
		return "API is working";
	}
	
	@PostMapping("/add")
	public boolean addSample(@RequestBody SampleModel sample) {
		repo.save(new SampleModel(sample.getName()));
		return true;
	}
	
	@GetMapping("/all")
	public java.util.List<SampleModel> getAll(){
		return repo.findAll();
	}
}
