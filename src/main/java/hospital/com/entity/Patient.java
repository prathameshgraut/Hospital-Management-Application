package hospital.com.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
//Specifies that this class is a JPA entity mapped to a database table 
@Entity
//Names the table in PostgreSQL as "patient" 
@Table(name = "patient")
public class Patient {
	 // Primary Key with auto-increment strategy (IDENTITY in PostgreSQL) 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 // Maps "id" to "_id" when serialized to/deserialized from JSON
	 @JsonProperty("_id")
	 private long id;
	 
	 // Patient's full name (mandatory field) 
	 @Column(nullable = false)
	 private String name;
	 
	 // Patient's age in years 
	 @Column(nullable = false)
	 private int age;
	 
	 // Patient's weight in kilograms 
	 @Column(nullable = false)
	 private int weight;
	 
	 // Phone number stored as a String to preserve leading zeros and country codes 
	 @Column(nullable = false)
	 private String phone;
	 
	 // Email must be unique across all patients and cannot be null
	 @Column(nullable = false, unique = true)
	 private String email;
	 
	 // Aadhaar number (12-digit unique identity number stored as String)
	 @Column(name = "aadhar_number", nullable = false, unique = true, length = 12)
	 private String aadharNumber;
	 
	 // Address field using TEXT type to allow longer text entries
	 @Column(nullable = false, columnDefinition = "TEXT")
	 private String address = "";
	 
	 // Timestamp when the record is created (cannot be modified after creation)
	 @Column(name = "created_at", nullable = false, updatable = false)
	 private LocalDateTime createdAt;

	 // Timestamp when the record was last modified
     @Column(name = "updated_at", nullable = false)
	 private LocalDateTime updatedAt;

     // Automatically runs right before saving a new record into the database
     @PrePersist
     protected void onCreate() {
         this.createdAt = LocalDateTime.now();
         this.updatedAt = LocalDateTime.now();
     }
     
     // Automatically runs right before updating an existing record in the database
     @PreUpdate
     protected void onUpdate() {
         this.updatedAt = LocalDateTime.now();
     }
     
     // Default no-args constructor: STRICTLY REQUIRED by JPA/Hibernate
     public Patient() {}

     // Parameterized constructor used when creating a new patient                                                                                                                      
     // (id, createdAt, and updatedAt are excluded because they are handled automatically)
	 public Patient(String name, int age, int weight, String phone, String email, String aadharNumber, String address) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.phone = phone;
		this.email = email;
		this.aadharNumber = aadharNumber;
		this.address = address;
	 }
	 
	 // --- Getters & Setters ---                                                                                                                                                       
     
     // Read-only getter for ID (set automatically by database)
	 public long getId() {
		 return id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public int getAge() {
		 return age;
	 }

	 public void setAge(int age) {
		 this.age = age;
	 }

	 public int getWeight() {
		 return weight;
	 }

	 public void setWeight(int weight) {
		 this.weight = weight;
	 }

	 public String getPhone() {
		 return phone;
	 }

	 public void setPhone(String phone) {
		 this.phone = phone;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getAddress() {
		 return address;
	 }

	 public void setAddress(String address) {
		 this.address = address;
	 }

	 public String getAadharNumber() {
		 return aadharNumber;
	 }

	 public void setAadharNumber(String aadharNumber) {
		 this.aadharNumber = aadharNumber;
	 }

	 // Read-only getter for creation timestamp
	 public LocalDateTime getCreatedAt() {
		 return createdAt;
	 }

	 // Read-only getter for last updated timestamp
	 public LocalDateTime getUpdatedAt() {
		 return updatedAt;
	 }
     
     
}
