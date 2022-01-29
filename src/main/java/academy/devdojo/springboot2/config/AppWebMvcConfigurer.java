package academy.devdojo.springboot2.config;

import org.springframework.context.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.*;
import org.springframework.web.method.support.*;
import org.springframework.web.servlet.config.annotation.*;

import java.util.*;

/**
 * @author Joao Iora
 */
@Configuration
public class AppWebMvcConfigurer implements WebMvcConfigurer {
  
  @Override
  public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
    var handler = new PageableHandlerMethodArgumentResolver();
    handler.setFallbackPageable(PageRequest.of(0, 5));
    resolvers.add(handler);
  }
  
}
