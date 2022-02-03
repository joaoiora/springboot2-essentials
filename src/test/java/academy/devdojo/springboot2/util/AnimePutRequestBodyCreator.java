package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.*;
import academy.devdojo.springboot2.requests.*;

/**
 * @author Joao Iora
 */
public class AnimePutRequestBodyCreator {
  
  public static AnimePutRequestBody newAnimePutRequestBody() {
    final Anime updatedAnime = AnimeCreator.newValidUpdatedAnime();
    return AnimePutRequestBody.builder().id(updatedAnime.getId()).name(updatedAnime.getName()).build();
  }
  
}
