package com.quarkus.dbMongo.repository;

import javax.enterprise.context.RequestScoped;

import com.quarkus.dbMongo.model.PersonDocument;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@RequestScoped
public class PersonRepository implements PanacheMongoRepository<PersonDocument> {
}
