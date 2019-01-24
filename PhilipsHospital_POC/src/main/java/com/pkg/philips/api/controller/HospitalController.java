package com.pkg.philips.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.philips.api.model.Hospital;
import com.pkg.philips.api.services.HospitalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class HospitalController {
	
			@Autowired
			HospitalService hospitalService;
			
			@GetMapping("/getHospitalById/{hospitalId}")
			public Optional<Hospital> getHospitalById(@PathVariable int hospitalId)
			{
				return hospitalService.getHospitalById(hospitalId);
			}
			
			@GetMapping("/getHospitals")
			public List<Hospital> getHospitalList()
			{
				return hospitalService.getListOfHospital();
			}
			
			@PostMapping("/createHospital")
			public Hospital createHospital(@RequestBody Hospital hospital)
			{
				return hospitalService.createHospital(hospital);
			}
			
			@PutMapping("/updateHospital")
			public Hospital updateHospital(@RequestBody Hospital hospital)
			{
				return hospitalService.createHospital(hospital);
			}
			
			@DeleteMapping("/deleteHospital/{hospitalId}")
			public void deleteHospital(@PathVariable int hospitalId)
			{
				 hospitalService.deleteHospital(hospitalId);
			}
	


}
