package com.quarkus.dbMongo.services.impl;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import com.quarkus.dbMongo.model.PersonDocument;
import com.quarkus.dbMongo.repository.PersonRepository;
import com.quarkus.dbMongo.services.IPersonService;
import org.bson.types.ObjectId;

@ApplicationScoped
public class PersonService implements IPersonService {

    @Inject
    PersonRepository repository;

    @Override
    public List<PersonDocument> findAll() {
        return repository.listAll();
    }

    @Override
    public PersonDocument findById(ObjectId personId) {
        return repository.findById(personId);
    }

    @Override
    public String update(PersonDocument personDocument) {
        String UpdateResponse = "";
        ObjectId idPersonValidate = repository.findById(personDocument.getId()).getId();
        if (idPersonValidate == null){
            UpdateResponse = "Persona no encontrada";
        }else{
            repository.update(personDocument);
            UpdateResponse = "Actualizado correctamente";
        }

        return UpdateResponse;
    }

    @Override
    public PersonDocument SavePerson(PersonDocument personDocument) {
        if (personDocument.getPersonId() == 0 || personDocument.getFirst_name() == ""
        || personDocument.getFirst_name() == null)
        repository.persist(personDocument);
        return repository.findById(personDocument.getId());
    }
}
