package hospital.com.Cache;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hospital.com.entity.Patient;
import hospital.com.repository.PatientRepository;
import jakarta.annotation.PostConstruct;

@Component
public class PatientCache {

	@Autowired
	PatientRepository patientRepository;

	Map<Long, Patient> m = new HashMap<>();

	
	public void storeData(Patient patient) {
		m.put(patient.getId(), patient);
	}
	
	
	public Patient getPatient(long id) {
		return m.get(id);
	}
	
	
	public boolean checkPatient(long id) {
		return m.containsKey(id);
	}
	
	
	//Load All Data Using LoadPatient Method ........
	//Load All Data, Method at Starting The Application 
	@PostConstruct
	public void loadPatient() {
		List<Patient> patientList = patientRepository.findAll();
	
		for(Patient p : patientList) {
			m.put(p.getId(), p);
		}
	}
	
	
	

}
