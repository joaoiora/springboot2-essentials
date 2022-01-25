package academy.devdojo.springboot2.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Joao Iora
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException
  extends RuntimeException {
  
  public BadRequestException(final String message) {
    super(message);
  }
  
}
