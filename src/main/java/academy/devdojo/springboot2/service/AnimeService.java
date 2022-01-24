package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

import java.util.*;

/**
 * @author Joao Iora
 */
@Service
public class AnimeService {
  
  private static final List<Anime> ANIMES = List.of(new Anime(1L, "DBZ"), new Anime(2L, "Berserk"),
                                                    new Anime(3L, "Boku No Hero"));
  
  public List<Anime> findAll() {
    return ANIMES;
  }
  
  public Anime findById(Long id) {
    return ANIMES.stream()
                 .filter(anime -> anime.getId().equals(id))
                 .findFirst()
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found."));
  }
  
  public Anime save(Anime anime) {
    return null;
  }
  
  public void delete(final Long id) {
  
  }
  
  public void update(final Anime anime) {
  
  }
  
}
