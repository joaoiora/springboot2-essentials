package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.*;
import lombok.extern.log4j.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.jdbc.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import javax.validation.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Joao Iora
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName(value = "Tests for Anime Repository")
@Log4j2
class AnimeRepositoryTest {
  
  private final AnimeRepository repository;
  
  @Autowired
  AnimeRepositoryTest(final AnimeRepository repository) {
    this.repository = repository;
  }
  
  @Test
  @DisplayName(value = "Testing the save operation on a Anime")
  void testSuccessfullySavingAnAnime() {
    var anime = newAnime();
    var savedAnime = repository.save(anime);
    assertNotNull(savedAnime);
    assertNotNull(savedAnime.getId());
    assertEquals(anime.getName(), savedAnime.getName());
  }
  
  @Test
  @DisplayName(value = "Testing the update operation on a already persisted Anime")
  void testSuccessfullyUpdatingAnAnime() {
    var anime = newAnime();
    var savedAnime = repository.save(anime);
    savedAnime.setName("Hajiume no Ippo 2");
    var updatedAnime = repository.save(savedAnime);
    assertNotNull(updatedAnime);
    assertNotNull(updatedAnime.getId());
    assertEquals(updatedAnime.getName(), savedAnime.getName());
  }
  
  @Test
  @DisplayName(value = "Testing the delete operation on a already persisted Anime")
  void testSuccessfullyDeleteAnAnime() {
    var anime = newAnime();
    var savedAnime = repository.save(anime);
    repository.delete(savedAnime);
    var loadedAnime = repository.findById(savedAnime.getId());
    assertTrue(loadedAnime.isEmpty());
  }
  
  @Test
  @DisplayName(value = "Test returning a list of Animes when finding by name")
  void testFindAnimesByName() {
    var anime = newAnime();
    var savedAnime = repository.save(anime);
    String name = savedAnime.getName();
    List<Anime> animes = repository.findByName(name);
    assertFalse(animes.isEmpty());
    assertTrue(animes.contains(savedAnime));
  }
  
  @Test
  @DisplayName(value = "Test returning an empty list of Animes")
  void testFindEmptyListOfAnimes() {
    List<Anime> animes = repository.findByName("name");
    assertTrue(animes.isEmpty());
    assertNotNull(animes);
  }
  
  @Test
  @DisplayName(value = "Saving an Anime with no name should throw ConstraintValidationException")
  void testSavingAnimeWhenNameIsEmptyThrowsConstraintValidationException() {
    var anime = new Anime();
    var expectedExceptionMessage = "The Anime Name must not be empty";
    org.assertj.core.api.Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
      .isThrownBy(() -> repository.save(anime))
      .withMessageContaining(expectedExceptionMessage);
  }
  
  private Anime newAnime() {
    return Anime.builder().name("Hajime no Ippo").build();
  }
  
}