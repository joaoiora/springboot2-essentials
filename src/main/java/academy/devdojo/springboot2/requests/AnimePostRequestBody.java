package academy.devdojo.springboot2.requests;

import lombok.*;
import org.hibernate.validator.constraints.*;

import javax.validation.constraints.NotEmpty;

/**
 * @author Joao Iora
 */
@Data
public class AnimePostRequestBody {
  
  @NotEmpty(message = "The Anime's Name must not be empty")
  private String name;
  
  @URL(message = "The URL is not valid")
  private String url;
  
}
