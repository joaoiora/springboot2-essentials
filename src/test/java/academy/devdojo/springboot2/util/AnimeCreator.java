package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.*;

/**
 * @author Joao Iora
 */
public class AnimeCreator {
  
  public static Anime newAnimeToBeSaved() {
    return Anime.builder().name("Hajime no Ippo").build();
  }
  
  public static Anime newValidAnime() {
    return Anime.builder().id(1L).name("Hajime no Ippo").build();
  }
  
  public static Anime newValidUpdatedAnime() {
    return Anime.builder().id(1L).name("Hajime no Ippo 2").build();
  }
  
}
