package com.pkg.philips.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkg.philips.api.model.PatientExam;

public interface PatientExamRepository extends JpaRepository<PatientExam,Integer> {

}
