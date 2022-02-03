package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.*;
import academy.devdojo.springboot2.requests.*;
import academy.devdojo.springboot2.service.*;
import academy.devdojo.springboot2.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Joao Iora
 */
@ExtendWith(SpringExtension.class)
class AnimeControllerTest {
  
  @InjectMocks
  private AnimeController controller;
  
  @Mock
  private AnimeService service;
  
  @BeforeEach
  void setup() {
    var animes = List.of(AnimeCreator.newValidAnime());
    var page = new PageImpl<>(animes);
    BDDMockito.when(service.findAll(ArgumentMatchers.any())).thenReturn(page);
    BDDMockito.when(service.findAllNonPageable()).thenReturn(animes);
    BDDMockito.when(service.findByIdOrThrowBadRequestException(ArgumentMatchers.anyLong()))
              .thenReturn(AnimeCreator.newValidAnime());
    BDDMockito.when(service.findByName(ArgumentMatchers.anyString())).thenReturn(animes);
    BDDMockito.when(service.save(ArgumentMatchers.any(AnimePostRequestBody.class)))
              .thenReturn(AnimeCreator.newValidAnime());
    BDDMockito.doNothing().when(service).update(ArgumentMatchers.any(AnimePutRequestBody.class));
    BDDMockito.doNothing().when(service).delete(ArgumentMatchers.anyLong());
  }
  
  @Test
  @DisplayName(value = "Testing that Find All returns a Pageable of Anime's")
  void testServiceSuccessfullyReturnsListOfPageAnimes() {
    var expectedAnimeName = AnimeCreator.newValidAnime().getName();
    final Page<Anime> body = controller.findAll(null).getBody();
    assertNotNull(body);
    final List<Anime> bodyList = body.toList();
    assertFalse(bodyList.isEmpty());
    assertEquals(1, bodyList.size());
    assertEquals(expectedAnimeName, bodyList.get(0).getName());
  }
  
  @Test
  @DisplayName(value = "Testing that Find All returns all Anime's without pagination")
  void testFindAllNonPageable() {
    var expectedAnimeName = AnimeCreator.newValidAnime().getName();
    List<Anime> animes = controller.findAllNonPageable().getBody();
    assertNotNull(animes);
    assertFalse(animes.isEmpty());
    assertEquals(1, animes.size());
    assertEquals(expectedAnimeName, animes.get(0).getName());
  }
  
  @Test
  @DisplayName(value = "Test finding an Anime by its ID")
  void testFindAnimeById() {
    var animeId = AnimeCreator.newValidAnime().getId();
    final Anime anime = controller.findById(animeId).getBody();
    assertNotNull(anime);
    assertNotNull(anime.getId());
    assertEquals(animeId, anime.getId());
  }
  
  @Test
  @DisplayName(value = "Test finding all Animes by name")
  void testFindAnimeByName() {
    var animeName = AnimeCreator.newValidAnime().getName();
    var animes = controller.findByName("anime").getBody();
    assertNotNull(animes);
    assertFalse(animes.isEmpty());
    assertEquals(1, animes.size());
    assertEquals(animeName, animes.get(0).getName());
  }
  
  @Test
  @DisplayName(value = "Test finding all Animes by name returns an empty list")
  void testFindAnimeByNameReturnsAnEmptyList() {
    BDDMockito.when(service.findByName(ArgumentMatchers.anyString())).thenReturn(Collections.emptyList());
    var animes = controller.findByName("anime").getBody();
    assertNotNull(animes);
    assertTrue(animes.isEmpty());
  }
  
  @Test
  @DisplayName(value = "Test saving an Anime using PostRequest Body")
  void testSavingAnAnime() {
    final Anime anime = AnimeCreator.newValidAnime();
    var animeId = anime.getId();
    var savedAnime = controller.save(AnimePostRequestBodyCreator.newAnimePostRequestBody()).getBody();
    assertNotNull(savedAnime);
    assertNotNull(savedAnime.getId());
    assertEquals(animeId, savedAnime.getId());
    assertEquals(anime, savedAnime);
  }
  
  @Test
  @DisplayName(value = "Test updating an existing Anime using Put Request Body")
  void testUpdatingAnAnime() {
    org.assertj.core.api.Assertions.assertThatCode(
      () -> controller.update(AnimePutRequestBodyCreator.newAnimePutRequestBody())).doesNotThrowAnyException();
    
    ResponseEntity<Void> entity = controller.update(AnimePutRequestBodyCreator.newAnimePutRequestBody());
    assertNotNull(entity);
    assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
  }
  
  @Test
  @DisplayName(value = "Test the deletion of an Anime")
  void testDeletingAnAnime() {
    org.assertj.core.api.Assertions.assertThatCode(() -> controller.delete(1L)).doesNotThrowAnyException();
    ResponseEntity<Void> entity = controller.delete(1L);
    assertNotNull(entity);
    assertEquals(HttpStatus.NO_CONTENT, entity.getStatusCode());
  }
  
}