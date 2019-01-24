package com.pkg.philips.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pkg.philips.api.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Integer>{

}
