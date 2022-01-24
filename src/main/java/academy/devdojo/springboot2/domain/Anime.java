package academy.devdojo.springboot2.domain;


import lombok.*;
import org.springframework.stereotype.*;

import javax.persistence.*;

/**
 * @author Joao Iora
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Anime {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  
}
