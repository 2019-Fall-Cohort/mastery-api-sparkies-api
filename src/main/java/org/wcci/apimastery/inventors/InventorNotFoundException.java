package org.wcci.apimastery.inventors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InventorNotFoundException extends Exception {

	public InventorNotFoundException(String message) {
		super(message);
	}

}
