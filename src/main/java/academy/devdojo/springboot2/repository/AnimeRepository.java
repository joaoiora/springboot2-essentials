package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

/**
 * @author Joao Iora
 */
public interface AnimeRepository
  extends JpaRepository<Anime, Long> {

  List<Anime> findByName(String name);
  
}
