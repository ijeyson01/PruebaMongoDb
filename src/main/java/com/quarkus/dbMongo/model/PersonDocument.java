package com.quarkus.dbMongo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "sc_Prueba")
public class PersonDocument {

    @BsonId
    private ObjectId id;
    @NotNull
    @NotEmpty
    private int personId;
    @NotNull
    @NotEmpty
    private String first_name;
    @NotNull
    @NotEmpty
    private String last_name;
    @NotNull
    @NotEmpty
    private int age;
}
