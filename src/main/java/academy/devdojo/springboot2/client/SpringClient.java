package academy.devdojo.springboot2.client;

import academy.devdojo.springboot2.domain.*;
import lombok.extern.log4j.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.web.client.*;

import java.util.*;

/**
 * @author Joao Iora
 */
@Log4j2
public class SpringClient {
  
  public static void main(String[] args) {
    var entity = new RestTemplate().getForEntity("http://localhost:8080/animes/2", Anime.class);
    var anime = entity.getBody();
    log.info("Anime Response Entity: " + entity);
    log.info("Anime Entity: " + anime);
    
    var anotherEntity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 3);
    var anotherAnime = anotherEntity.getBody();
    log.info("Another Anime Response Entity: " + anotherEntity);
    log.info("Another Anime Entity: " + anotherAnime);
    
    var animes = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
                                             new ParameterizedTypeReference<List<Anime>>() {
      
                                             });
    log.info(animes);
    
    var kingdom = Anime.builder().name("Kingdom").build();
    var savedKingdom = new RestTemplate().postForObject("http://localhost:8080/animes/", kingdom, Anime.class);
    log.info("Saved new Anime: {}", savedKingdom);
    
    var samuraiChamploo = Anime.builder().name("Samurai Champloo").build();
    var savedSamurai = new RestTemplate().exchange("http://localhost:8080/animes/", HttpMethod.POST,
                                                   new HttpEntity<>(samuraiChamploo),
                                                   Anime.class);
    log.info("Saved another new Anime: {}", savedSamurai);
  }
  
}