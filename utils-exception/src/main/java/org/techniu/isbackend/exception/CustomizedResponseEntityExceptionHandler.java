package org.techniu.isbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.techniu.isbackend.Response;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MainException.EntityNotFoundException.class)
    public final ResponseEntity handleNotFountExceptions(Exception ex) {
        Response response = Response.notFound();
        response.addErrorMsgToResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MainException.DuplicateEntityException.class)
    public final ResponseEntity handleDuplicateExceptions(Exception ex) {
        Response response = Response.duplicateEntity();
        response.addErrorMsgToResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MainException.OtherEntityException.class)
    public final ResponseEntity handleOtherExceptions(Exception ex) {
        Response response = Response.exception();
        response.addErrorMsgToResponse(ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}