package hospital.com.Schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import hospital.com.Cache.PatientCache;

@Component
public class PatientSchedular {
	
	@Autowired
	PatientCache patientCache;
	
	@Scheduled (cron = "*/15 * * * * *")
	public void Start_LoadPatient() {
		patientCache.loadPatient();
	}
	
	
	
}
