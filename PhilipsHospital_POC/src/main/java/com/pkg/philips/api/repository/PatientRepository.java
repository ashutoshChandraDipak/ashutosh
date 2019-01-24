package com.pkg.philips.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pkg.philips.api.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{

	public List<Patient> findByHospitalId(int hospitalId);

	

}
