package com.language.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.language.api.model.Language;
import com.language.api.repository.LanguageRepository;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

  @Autowired
  private LanguageRepository repository;

  @GetMapping
  public List<Language> getAll() {
    return repository.findAll();
  }  
  
  @GetMapping("/{id}")
  public Optional<Language> get(@PathVariable String id) {
    return repository.findById(id);
  }

  @PostMapping
  public Language insert(@RequestBody Language language) {
    return repository.save(language);
  }

  @PutMapping("/{id}")
  public Optional<Language> update(@PathVariable String id, @RequestBody Language body) {
    return repository.findById(id)
    .map(value -> {
      value.setImage(body.getImage());
      value.setTitle(body.getTitle());
      value.setRanking(body.getRanking());
      return repository.save(value);
    });
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    repository.deleteById(id);
  }
}
