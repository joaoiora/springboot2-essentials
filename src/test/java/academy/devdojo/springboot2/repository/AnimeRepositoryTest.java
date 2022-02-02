package academy.devdojo.springboot2.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

/**
 * @author Joao Iora
 */
@DataJpaTest
@DisplayName(value = "Tests for Anime Repository")
class AnimeRepositoryTest {
  
  @Autowired
  private AnimeRepository repository;
  
  @Test
  void test() {
  
  }
  
}