package me.sathish.app.hireme.exceptions;

import java.util.Date;
import lombok.Data;

@Data
public class HireExceptionResponse {

  private Date current_ts;
  private String message;
  private String details;

  public HireExceptionResponse(Date current_ts, String message, String details) {
    this.current_ts = current_ts;
    this.message = message;
    this.details = details;
  }
}
