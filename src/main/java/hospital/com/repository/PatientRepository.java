package hospital.com.repository;

import java.util.List;                                                                 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hospital.com.entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	 // Find a patient by their unique email
    Optional<Patient> findByEmail(String email);

    // Check if an email already exists before registering a new patient
    boolean existsByEmail(String email);

    // Find a patient by their phone number
    Optional<Patient> findByPhone(String phone);

    // Check if a phone number is already registered
    boolean existsByPhone(String phone);

    // Find a patient by their unique Aadhaar number
    Optional<Patient> findByAadharNumber(String aadharNumber);

    // Check if an Aadhaar number is already registered
    boolean existsByAadharNumber(String aadharNumber);

    // Search patients by name (case-insensitive search, e.g., "john" matches "John Doe")
    List<Patient> findByNameContainingIgnoreCase(String name);
}
