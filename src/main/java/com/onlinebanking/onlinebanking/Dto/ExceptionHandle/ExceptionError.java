package com.onlinebanking.onlinebanking.Dto.ExceptionHandle;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionError {

  private String massage;
  private HttpStatus httpStatus;
  private ZonedDateTime zonedDateTime;

  public ExceptionError(String massage,
                        HttpStatus httpStatus,
                        ZonedDateTime zonedDateTime) {
    this.massage = massage;
    this.httpStatus = httpStatus;
    this.zonedDateTime = zonedDateTime;
  }
}
