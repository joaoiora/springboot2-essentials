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
  
  private static final String URL = "http://localhost:8080/animes/";
  
  public static void main(String[] args) {
    var entity = new RestTemplate().getForEntity(URL + "/2", Anime.class);
    var anime = entity.getBody();
    log.info("Anime Response Entity: " + entity);
    log.info("Anime Entity: " + anime);
    
    var anotherEntity = new RestTemplate().getForEntity(URL + "/{id}", Anime.class, 3);
    var anotherAnime = anotherEntity.getBody();
    log.info("Another Anime Response Entity: " + anotherEntity);
    log.info("Another Anime Entity: " + anotherAnime);
    
    var animes = new RestTemplate().exchange(URL + "/all", HttpMethod.GET, null,
                                             new ParameterizedTypeReference<List<Anime>>() {
      
                                             });
    log.info(animes);
    
    var kingdom = Anime.builder().name("Kingdom").build();
    var savedKingdom = new RestTemplate().postForObject(URL, kingdom, Anime.class);
    log.info("Saved new Anime: {}", savedKingdom);
    
    var samuraiChamploo = Anime.builder().name("Samurai Champloo").build();
    var savedSamurai = new RestTemplate().exchange(URL, HttpMethod.POST,
                                                   new HttpEntity<>(samuraiChamploo, newJsonHeader()), Anime.class);
    log.info("Saved another new Anime: {}", savedSamurai);
    
    final Anime savedSamuraiBody = savedSamurai.getBody();
    savedSamuraiBody.setName("Samura Champloo 2");
    var updatedSamurai = new RestTemplate().exchange(URL, HttpMethod.PUT,
                                                     new HttpEntity<>(savedSamuraiBody, newJsonHeader()), Void.class);
    log.info("Updated Anime: {}", updatedSamurai);
    
    var deletedSamurai = new RestTemplate().exchange(URL + "/{id}", HttpMethod.DELETE, null, Void.class,
                                                     savedSamuraiBody.getId());
    log.info("Deleting Anime: {}", deletedSamurai);
    
  }
  
  private static HttpHeaders newJsonHeader() {
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }
  
}