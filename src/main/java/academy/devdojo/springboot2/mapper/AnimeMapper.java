package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.*;
import academy.devdojo.springboot2.requests.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

/**
 * @author Joao Iora
 */
@Mapper(componentModel = "spring")
public interface AnimeMapper {
  
  AnimeMapper MAPPER = Mappers.getMapper(AnimeMapper.class);
  
  Anime toAnime(AnimePostRequestBody anime);
  
  Anime toAnime(AnimePutRequestBody anime);
  
}
