package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.*;
import academy.devdojo.springboot2.requests.*;
import academy.devdojo.springboot2.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

import static org.springframework.http.HttpStatus.*;


/**
 * @author Joao Iora
 */
@RestController
@RequestMapping(path = "animes")
@RequiredArgsConstructor
public class AnimeController {
  
  private final AnimeService service;
  
  @GetMapping
  public ResponseEntity<Page<Anime>> findAll(Pageable pageable) {
    return ResponseEntity.ok(service.findAll(pageable));
  }
  
  @GetMapping(path = "/all")
  public ResponseEntity<List<Anime>> findAllNonPageable(){
    return ResponseEntity.ok(service.findAllNonPageable());
  }
  
  @GetMapping(path = "/{id}")
  public ResponseEntity<Anime> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
  }
  
  
  @GetMapping(path = "/find")
  public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
    return ResponseEntity.ok(service.findByName(name));
  }
  
  @PostMapping
  @ResponseStatus(value = CREATED)
  public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody anime) {
    return new ResponseEntity<>(service.save(anime), CREATED);
  }
  
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(NO_CONTENT);
  }
  
  @PutMapping
  public ResponseEntity<Void> update(@RequestBody AnimePutRequestBody anime) {
    service.update(anime);
    return new ResponseEntity<>(NO_CONTENT);
  }
  
}
