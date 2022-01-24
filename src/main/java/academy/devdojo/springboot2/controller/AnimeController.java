package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.*;
import academy.devdojo.springboot2.service.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;


/**
 * @author Joao Iora
 */
@RestController
@RequestMapping(path = "animes")
@RequiredArgsConstructor
public class AnimeController {
  
  @Autowired
  private final AnimeService service;
  
  /**
   * @return
   */
  @GetMapping
  public ResponseEntity<List<Anime>> list() {
    return ResponseEntity.ok(service.findAll());
  }
  
  @GetMapping(path = "/{id}")
  public ResponseEntity<Anime> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }
  
  @PostMapping
  @ResponseStatus(value = CREATED)
  public ResponseEntity<Anime> save(@RequestBody Anime anime) {
    return ResponseEntity.ok(service.save(anime));
  }
  
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(NO_CONTENT);
  }
  
  @PutMapping
  public ResponseEntity<Void> update(@RequestBody Anime anime){
    service.update(anime);
    return new ResponseEntity<>(NO_CONTENT);
  }
  
}
