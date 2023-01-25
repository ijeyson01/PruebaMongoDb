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
        try {
            repository.update(personDocument);
            UpdateResponse = "Actualizado correctamente";
            ObjectId idPersonValidate = repository.findById(personDocument.getId()).getId();

        } catch (Exception e){
            UpdateResponse = "Persona no encontrada";
            System.out.println("Error: "+ e.getMessage());
        }

        return UpdateResponse;
    }

    @Override
    public String SavePerson(PersonDocument personDocument) {
        String SaveValidate = "";
        if (personDocument.getPersonId() == 0 || personDocument.getFirst_name() == ""
                || personDocument.getFirst_name() == null || personDocument.getLast_name() == ""
                || personDocument.getLast_name() == null || personDocument.getAge() == 0) {
            SaveValidate = "No se pudo guardar, revise los datos de entrada";

        } else {
            repository.persist(personDocument);
            SaveValidate = "Guardado correctamente";
        }

        return SaveValidate;
    }
}
