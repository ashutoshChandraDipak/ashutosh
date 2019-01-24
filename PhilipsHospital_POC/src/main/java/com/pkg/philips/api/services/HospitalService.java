package com.pkg.philips.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.philips.api.model.Hospital;
import com.pkg.philips.api.repository.HospitalRepository;

@Service
public class HospitalService 
{
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@PostConstruct
	public void saveDefaultHaspitalRecords()
	{
		List <Hospital> list=new ArrayList<Hospital>();
		list.add(new Hospital("Mallya Hospital","Mallya Hospital Description"));
		list.add(new Hospital("Fortis Hospital","Fortis Hospital Description"));
		list.add(new Hospital("Jamia Darussalam Hospital","Jamia Darussalam Hospital Description"));
		list.add(new Hospital("Hosmat Hospital","Hosmat Hospital Description"));
		list.add(new Hospital("Svastha Hospital","Svastha Hospital Description"));
		list.add(new Hospital("Manipal Hospital","Manipal Hospital Description"));
		list.add(new Hospital("Ayug Multi Specialty Hospital","Ayug Multi Specialty Hospital Description"));
		list.add(new Hospital("Jeevika Hospitalsl","Jeevika Hospitalsl Description"));
		list.add(new Hospital("Fortis Medcenter","Fortis Medcenter Description"));
		hospitalRepository.saveAll(list);
	}
	
	public Optional<Hospital> getHospitalById(int hospitalId)
	{
		return hospitalRepository.findById(hospitalId);
		
	}
	
	public List<Hospital> getListOfHospital()
	{
		return hospitalRepository.findAll();
		
	}
	
	public Hospital updateHospital(Hospital hospital)
	{
		return hospitalRepository.save(hospital);
		
	}
	
	public Hospital createHospital(Hospital hospital)
	{
		return hospitalRepository.save(hospital);
		
	}
	
	public void deleteHospital(int  hospitalId)
	{
		 hospitalRepository.deleteById(hospitalId);
		
	}
	
}
