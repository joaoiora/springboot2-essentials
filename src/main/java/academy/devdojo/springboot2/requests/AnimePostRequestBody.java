package academy.devdojo.springboot2.requests;

import lombok.*;

import javax.validation.constraints.*;

/**
 * @author Joao Iora
 */
@Data
public class AnimePostRequestBody {
  
  @NotEmpty(message = "The Anime's Name must not be empty")
  private String name;
  
}
