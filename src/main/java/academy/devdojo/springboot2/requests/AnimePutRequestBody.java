package academy.devdojo.springboot2.requests;

import lombok.*;

/**
 * @author Joao Iora
 */
@Data
@Builder
public class AnimePutRequestBody {
  
  private Long id;
  
  private String name;
  
}
