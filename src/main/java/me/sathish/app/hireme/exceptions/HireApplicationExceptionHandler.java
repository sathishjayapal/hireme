package me.sathish.app.hireme.exceptions;

import java.util.Date;
import me.sathish.app.hireme.data.HiringUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class HireApplicationExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllApplicationresponse(Exception ex,
      WebRequest webRequest) {
    HireExceptionResponse response = new HireExceptionResponse (new Date (), ex.getMessage (),
        webRequest.getDescription (false));
    return new ResponseEntity<> (response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(HiringUserNotFoundException.class)
  public final ResponseEntity<Object> handleHiringUserNotFoundExceptionApplicationresponse(Exception ex,
      WebRequest webRequest) {
    HireExceptionResponse response = new HireExceptionResponse (new Date (), ex.getMessage (),
        webRequest.getDescription (false));
    return new ResponseEntity<> (response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(HiringUserException.class)
  public final ResponseEntity<Object> handleHiringUserExceptionApplicationresponse(Exception ex,
      WebRequest webRequest) {
    HireExceptionResponse response = new HireExceptionResponse (new Date (), ex.getMessage (),
        webRequest.getDescription (false));
    return new ResponseEntity<> (response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
