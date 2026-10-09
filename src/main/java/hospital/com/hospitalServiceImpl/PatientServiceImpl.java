package hospital.com.hospitalServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.com.Cache.PatientCache;
import hospital.com.entity.Patient;
import hospital.com.hospitalService.PatientService;
import hospital.com.repository.PatientRepository;
@Service

public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientCache patientCache;
	
	@Autowired
	PatientRepository patientRepository;
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository=patientRepository;
		// TODO Auto-generated constructor stub
	}


	@Override
	public Patient addPatient(Patient patient) {
		if(patientRepository.existsById(patient.getId())){
			System.out.println("patient is already exist ");
			
		}
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatient(long id) {
		if(patientCache.checkPatient(id)) {
		return 	patientCache.getPatient(id);
		} 
		Patient m= patientRepository.findById(id).get();
		patientCache.storeData(m);
        return m;
	} 

	@Override
	
	
	
	public List<Patient> getAllPatients() {

	    Map<Long, Patient> cachedPatients = patientCache.getAllPatient();

	    if (cachedPatients != null && !cachedPatients.isEmpty()) {
	        return new ArrayList<Patient>(cachedPatients.values());
	    }

	    List patients = patientRepository.findAll();

	    patientCache.storeData((Patient) patients);

	    return patients;
	}
//	public Map<Long,Patient> getAllPatients() {
//		if(patientCache.getAllPatient())) {
//			return m
//		}
//		Patient temp = patientRepository.findAll().get();
//		patientCache.storeData(temp);
//	
//		return temp;
//	}

	@Override
	public Patient updatePatient(long id, Patient patient) {
		// TODO Auto-generated method stub
		Patient existingPatient = patientRepository.findById(id).get();
    	existingPatient.setName(patient.getName());
    	existingPatient.setAge(patient.getAge());
    	existingPatient.setEmail(patient.getEmail());
    	existingPatient.setPhone(patient.getPhone());
    	existingPatient.setAddress(patient.getAddress());
    	existingPatient.setWeight(patient.getWeight());
    	

    	return patientRepository.save(existingPatient);
	}

	@Override
	public void deletePatientById(long id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
		
	}

	@Override
	public List<Patient> searchPatient(String name) {
		// TODO Auto-generated method stub
		return patientRepository.findByNameContainingIgnoreCase(name);
	}
	
	
	
	
	

}