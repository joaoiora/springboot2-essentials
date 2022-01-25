package academy.devdojo.springboot2.domain;


import lombok.*;
import org.hibernate.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Joao Iora
 */
//@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Anime {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false)
  private String name;
  
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    final Anime anime = (Anime) o;
    return id != null && Objects.equals(id, anime.id);
  }
  
  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
  
}
