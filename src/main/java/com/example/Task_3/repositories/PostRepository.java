package com.example.Task_3.repositories;

import com.example.Task_3.models.Post;
import com.example.Task_3.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'author._id': ?0}")
    List<Post> findByAuthorID(String authorID);

}
