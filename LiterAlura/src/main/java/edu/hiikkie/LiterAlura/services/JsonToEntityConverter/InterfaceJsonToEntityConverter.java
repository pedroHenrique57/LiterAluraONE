package edu.hiikkie.LiterAlura.services.JsonToEntityConverter;

import java.util.List;

public interface InterfaceJsonToEntityConverter {

  <T> List<?> converterDados (String json, Class<T> classe);
}
