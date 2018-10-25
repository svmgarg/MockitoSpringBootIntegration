package org.learn.mockito.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

  @Override
  public String convertToDatabaseColumn(List<String> list) {
    // Java 8
    return String.join(",", list);  
  }

  @Override
  public List<String> convertToEntityAttribute(String joined) {
    return new ArrayList<>(Arrays.asList(joined.split(",")));
  }

}