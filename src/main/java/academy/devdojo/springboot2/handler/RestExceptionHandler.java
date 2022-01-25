package academy.devdojo.springboot2.handler;

import academy.devdojo.springboot2.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

/**
 * @author Joao Iora
 */
@ControllerAdvice
public class RestExceptionHandler {
  
  @ExceptionHandler(value = BadRequestException.class)
  public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException exception) {
    return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                                                          .title("Bad Request Exception. Check the API documentation.")
                                                          .timestamp(LocalDateTime.now())
                                                          .status(HttpStatus.BAD_REQUEST.value())
                                                          .details(exception.getMessage())
                                                          .developerMessage(exception.getClass().getName())
                                                          .build(), HttpStatus.BAD_REQUEST);
  }
  
}
