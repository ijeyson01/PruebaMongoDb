package com.quarkus.dbMongo.services;

import java.util.List;

import com.quarkus.dbMongo.model.PersonDocument;
import org.bson.types.ObjectId;


public interface IPersonService {

    List<PersonDocument> findAll();

    PersonDocument findById(ObjectId personId);

    String update(PersonDocument personDocument);

    PersonDocument SavePerson(PersonDocument personDocument);

}
