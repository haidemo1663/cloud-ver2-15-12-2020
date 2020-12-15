package com.doancuoiki.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.doancuoiki.demo.Entity.Book;
public interface BookRepository extends MongoRepository<Book,String>{
}
