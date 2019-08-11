package com.mithunkhatri.spring.mongodbcrud.repositories;

import com.mithunkhatri.spring.mongodbcrud.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends MongoRepository<Book, UUID> {

}
