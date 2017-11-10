package utils;

import java.util.Dictionary;
import java.util.HashMap;

public class ServerResponse {
	private ResponseStatus status = ResponseStatus.SUCCESS;
	private HashMap<String, Object> data = new HashMap<>();
	private HashMap<String, Object> errors = new HashMap<>();
	
	public ServerResponse addData(String key, Object value) {
		data.put(key, value);
		return this;
	}
	
	public ServerResponse addError(String key, Object value) {
		status = ResponseStatus.FAIL;
		errors.put(key, value);
		return this;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public HashMap<String, Object> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String, Object> errors) {
		this.errors = errors;
	}
}
