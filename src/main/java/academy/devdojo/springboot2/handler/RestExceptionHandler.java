package academy.devdojo.springboot2.handler;

import academy.devdojo.springboot2.exception.*;
import lombok.extern.log4j.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.stream.*;

/**
 * @author Joao Iora
 */
@ControllerAdvice
@Log4j2
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
  
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationExceptionDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    var errors = exception.getBindingResult().getFieldErrors();
    var fields = errors.stream().map(FieldError::getField).collect(Collectors.joining(","));
    var messages = errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
    return new ResponseEntity<>(ValidationExceptionDetails.builder()
                                                          .title("Bad Request Exception. Invalid fields.")
                                                          .timestamp(LocalDateTime.now())
                                                          .status(HttpStatus.BAD_REQUEST.value())
                                                          .details("Check the field(s) error.")
                                                          .developerMessage(exception.getClass().getName())
                                                          .fields(fields)
                                                          .fieldsMessage(messages)
                                                          .build(), HttpStatus.BAD_REQUEST);
  }
  
}
