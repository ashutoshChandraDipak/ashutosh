package com.pkg.philips.api.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.philips.api.model.Patient;
import com.pkg.philips.api.repository.PatientRepository;;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	@PostConstruct
	public void savePatient() throws ParseException {

		/*
		 * DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); java.util.Date dt = new
		 * java.util.Date(); java.text.SimpleDateFormat sdf = new
		 * java.text.SimpleDateFormat("MM-dd-yyyy"); String dateOfBirth =
		 * sdf.format(dt); sdf.parse(dateOfBirth);
		 */
		LocalDate birthday = LocalDate.of(1992, Month.JANUARY, 1);
		LocalDate birthday1 = LocalDate.of(1960, Month.JANUARY, 1);
		LocalDate birthday2 = LocalDate.of(1980, Month.FEBRUARY, 1);
		LocalDate birthday3 = LocalDate.of(1960, Month.JANUARY, 1);
		LocalDate birthday4 = LocalDate.of(1973, Month.JANUARY, 1);
		LocalDate birthday5 = LocalDate.of(1960, Month.JANUARY, 1);
		LocalDate birthday6 = LocalDate.of(1923, Month.DECEMBER, 1);
		LocalDate birthday7 = LocalDate.of(1970, Month.APRIL, 1);
		LocalDate birthday8 = LocalDate.of(1930, Month.FEBRUARY, 1);
		LocalDate birthday9 = LocalDate.of(1960, Month.JANUARY, 1);
		LocalDate birthday10 = LocalDate.of(1944, Month.MARCH, 1);

		/*
		 * Patient patient =new
		 * Patient(3000,"Sunny Kumar Chaudhari",birthday,"Male",1001); LocalDate today =
		 * LocalDate.now(); //Today's date LocalDate
		 * birthday11=patient.getDateOfBirth();
		 * 
		 * Period period = Period.between(birthday, today);
		 * patient.setAge(period.getYears());
		 */

		List<Patient> list = new ArrayList<Patient>();
		list.add(new Patient("Sunny Kumar Chaudhari", birthday, "Male", 1, 26));
		list.add(new Patient("Dinesh Kumar Maurya", birthday1, "Male", 1, 58));

		list.add(new Patient( "Rohan Jain", birthday2, "Male",2,24));
		list.add(new Patient( "Sujata Adhire", birthday3, "Male",2));
		list.add(new Patient("Anshuman Chandra", birthday4, "Male", 3));
		list.add(new Patient( "Shekhar Kumar", birthday5, "Male", 4));
		list.add(new Patient( "Cahudhari Dipak Kumar", birthday6, "Male", 1004));
		list.add(new Patient( "Viswash Chauhan", birthday7, "Male", 5));
		list.add(new Patient( "Servesh Kumar Maurya", birthday8, "Male", 2));
		list.add(new Patient( "Jha Gaurav", birthday9, "Male", 2));
		list.add(new Patient("Hareram Kasyap", birthday10, "Male", 5));
		list.add(new Patient("Chottu shekhar", birthday5, "Male", 6));
		list.add(new Patient( "Madhuri Kanaujiya", birthday2, "Male", 6));
		list.add(new Patient( "HareMukund Tripathi", birthday4, "Male", 5));
		list.add(new Patient( "Sonam Kapoor", birthday9, "Female", 4));
		list.add(new Patient( "Sreya kumari", birthday3, "Female", 3));
		list.add(new Patient( "Amithabh bachhan", birthday10, "Male", 3));
		list.add(new Patient( "Abhishek Chandra", birthday2, "Male", 2));
		patientRepository.saveAll(list);
	}

	public Optional<Patient> getPatient(int id) {
		return patientRepository.findById(id);
	}

	public List<Patient> getPatientsList() {
		return patientRepository.findAll();
	}

	public List<Patient> getPatientsListBiHospitalId(Integer hospitalId) {
		List<Patient> list1 = new ArrayList<Patient>();
		List<Patient> list = patientRepository.findAll();
		for (Patient patient : list) {
			if (patient.getHospitalId() != null) {
				if (patient.getHospitalId().equals(hospitalId)) {
					list1.add(patient);
				}
			}
		}
		return patientRepository.findByHospitalId(hospitalId);
	}

	public List<Patient> createPatient(Patient patient) {
		patientRepository.save(patient);
		return patientRepository.findAll();
	}

	public List<Patient> updatePatient(Patient patient) {
		patientRepository.save(patient);
		return patientRepository.findAll();
	}

	public Optional<Patient> deletePatient(int id) {
		patientRepository.deleteById(id);
		return patientRepository.findById(id);
	}
}
