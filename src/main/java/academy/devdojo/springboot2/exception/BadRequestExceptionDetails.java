package academy.devdojo.springboot2.exception;

import lombok.*;

import java.time.*;

/**
 * @author Joao Iora
 */
@Data
@Builder
public class BadRequestExceptionDetails {
  
  private String title;
  
  private Integer status;
  
  private String details;
  
  private String developerMessage;
  
  private LocalDateTime timestamp;
  
}
