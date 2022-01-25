package academy.devdojo.springboot2.exception;

import lombok.*;
import lombok.experimental.*;

import java.time.*;

/**
 * @author Joao Iora
 */
@Data
@SuperBuilder
public class ExceptionDetails {
  
  protected String title;
  
  protected Integer status;
  
  protected String details;
  
  protected String developerMessage;
  
  protected LocalDateTime timestamp;
  
}
