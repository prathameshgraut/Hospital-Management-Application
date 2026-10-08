package hospital.com.hospitalServiceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospital.com.entity.Patient;
import hospital.com.hospitalService.PatientService;
import hospital.com.repository.PatientRepository;
@Service

public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepository patientRepository;


	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatient(long id) {
		// TODO Auto-generated method stub
Optional<Patient> patient = patientRepository.findById(id);
    	
        return patient.get();
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

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
    	existingPatient.setAadharNumber(patient.getAadharNumber());
    	

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
