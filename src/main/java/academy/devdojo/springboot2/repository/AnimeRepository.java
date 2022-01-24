package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.*;
import org.springframework.data.jpa.repository.*;

/**
 * @author Joao Iora
 */
public interface AnimeRepository
  extends JpaRepository<Anime, Long> {

}
