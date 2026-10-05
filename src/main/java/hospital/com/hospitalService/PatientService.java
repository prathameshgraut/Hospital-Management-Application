package hospital.com.hospitalService;

import java.util.List;

import hospital.com.entity.Patient;

public interface PatientService {
	public Patient addPatient(Patient patient);
	public Patient getPatient(long id);
	public List<Patient> getAllPatients();
	public Patient updatePatient(long id, Patient patient);
	public void deletePatientById(long id);
	public List<Patient> searchPatient(String name);
	
	

}
