package com.language.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "MainLanguages")
@NoArgsConstructor
@Data
public class Language {
  @Id
  private String id;
  private String title;
  private String image;
  private int ranking;

  public Language(String title, String image, int ranking) {
    this.title = title;
    this.image = image;
    this.ranking = ranking;
  }
}
