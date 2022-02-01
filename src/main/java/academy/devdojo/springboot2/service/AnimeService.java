package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.*;
import academy.devdojo.springboot2.exception.*;
import academy.devdojo.springboot2.mapper.*;
import academy.devdojo.springboot2.repository.*;
import academy.devdojo.springboot2.requests.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

/**
 * @author Joao Iora
 */
@Service
@RequiredArgsConstructor
public class AnimeService {
  
  private final AnimeRepository repository;
  
  public Page<Anime> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
  
  public List<Anime> listAllNonPageable() {
    return repository.findAll();
  }
  
  public List<Anime> findByName(String name) {
    return repository.findByName(name);
  }
  
  public Anime findByIdOrThrowBadRequestException(Long id) {
    return repository.findById(id).orElseThrow(() -> new BadRequestException("Anime Not Found"));
  }
  
  @Transactional
  public Anime save(AnimePostRequestBody animePostRequest) {
    return repository.save(new AnimeMapperImpl().toAnime(animePostRequest));
  }
  
  public void delete(final Long id) {
    repository.delete(findByIdOrThrowBadRequestException(id));
  }
  
  public void update(final AnimePutRequestBody animePutRequest) {
    Anime persisted = findByIdOrThrowBadRequestException(animePutRequest.getId());
    Anime anime = new AnimeMapperImpl().toAnime(animePutRequest);
    anime.setId(persisted.getId());
    repository.save(anime);
  }
  
}
