package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.requests.*;

/**
 * @author Joao Iora
 */
public class AnimePostRequestBodyCreator {
  
  public static AnimePostRequestBody newAnimePostRequestBody() {
    return AnimePostRequestBody.builder().name(AnimeCreator.newAnimeToBeSaved().getName()).build();
  }
  
}
