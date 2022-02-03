package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.*;
import academy.devdojo.springboot2.service.*;
import academy.devdojo.springboot2.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.springframework.data.domain.*;
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
    PageImpl<Anime> page = new PageImpl<>(List.of(AnimeCreator.newValidAnime()));
    BDDMockito.when(service.findAll(ArgumentMatchers.any())).thenReturn(page);
  }
  
  @Test
  @DisplayName(value = "")
  void testServiceSuccessfullyReturnsListOfPageAnimes() {
    var expectedAnimeName = AnimeCreator.newValidAnime().getName();
    final Page<Anime> body = controller.list(null).getBody();
    assertNotNull(body);
    final List<Anime> bodyList = body.toList();
    assertFalse(bodyList.isEmpty());
    assertEquals(1, bodyList.size());
    assertEquals(expectedAnimeName, bodyList.get(0).getName());
  }
  
}