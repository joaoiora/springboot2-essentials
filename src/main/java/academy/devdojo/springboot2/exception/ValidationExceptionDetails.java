package academy.devdojo.springboot2.exception;

import lombok.*;
import lombok.experimental.*;

/**
 * @author Joao Iora
 */
@Getter
@SuperBuilder
public class ValidationExceptionDetails
  extends ExceptionDetails {
  
  private final String fields;
  
  private final String fieldsMessage;
  
}
