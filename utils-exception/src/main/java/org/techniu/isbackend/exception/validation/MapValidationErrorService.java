package org.techniu.isbackend.exception.validation;

import org.techniu.isbackend.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

/**
 * Customize fields validation errors output inside the response
 */
@Service
public class MapValidationErrorService {

    public ResponseEntity mapValidationService(BindingResult bindingResult) {

        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ResponseEntity<Response>(Response.validationException().setErrors(errorMap), HttpStatus.BAD_REQUEST);
    }
}
