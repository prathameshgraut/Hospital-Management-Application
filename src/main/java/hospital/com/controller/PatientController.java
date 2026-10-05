package hospital.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hospital.com.entity.Patient;
import hospital.com.hospitalService.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@PostMapping("addPatient")
	public Patient addPatient( @RequestBody  Patient patient) {
		return patientService.addPatient(patient);
		
	}
	@GetMapping("getPatient/{id}")
	public Patient getPatient(@PathVariable  long id) {
		return patientService.getPatient(id);
	}
	
	@GetMapping("getAllPatient")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
		
	}
	@PutMapping("updatePatient/{id}")
	public Patient updatePatient(@PathVariable long id , @RequestBody Patient patient ) {
		return patientService.updatePatient(id, patient);
		
	}
	@DeleteMapping("deletePatient/{id}")
	public void deletePatient(@PathVariable long id ) {
		patientService.deletePatientById(id);
	}
	@GetMapping("searchPatient/{name}")
	public List<Patient> searchPatient(@PathVariable String name ){
		return patientService.searchPatient(name);
	}
	
	
}
