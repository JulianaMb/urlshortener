package com.urlshortener.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.urlshortener.model.Url;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {

}
