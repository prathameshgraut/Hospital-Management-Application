package hospital.com.Hospitalexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @ResponseStatus "get Status Code Response to Server......"
 * 
 * */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HospitalManagementException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	/*
	 * Constructor used for variable Initilizatied
	 */

	public HospitalManagementException(String resourceName, String fieldName, Object fieldValue) {
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

}
