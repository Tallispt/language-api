package com.language.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.language.api.model.Language;

public interface LanguageRepository extends MongoRepository<Language, String> {

}
