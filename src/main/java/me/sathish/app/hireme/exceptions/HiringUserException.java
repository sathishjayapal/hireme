package me.sathish.app.hireme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class HiringUserException extends RuntimeException {


  public HiringUserException(String user_not_found) {
    super(user_not_found);

  }
}
