package com.example.Task_3.services;

import com.example.Task_3.models.User;
import com.example.Task_3.repositories.UserRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    MongoClient mongoClient;

    @Autowired
    public UserService(UserRepository userRepository, MongoClient mongoClient) {
        this.userRepository = userRepository;
        this.mongoClient = mongoClient;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }


    //Update Username of the User
    public User updateUserUsername(String id, String username) {
        User user = userRepository.findById(id).get();
        user.setUsername(username);
        return userRepository.save(user);

//        System.out.println("id: " + id);
//        MongoDatabase mongoDatabase = this.mongoClient.getDatabase("ahmed_52_13398");
//        MongoCollection<Document> users = mongoDatabase.getCollection("users");
//        users.updateOne(
//                Filters.eq("_id", new ObjectId(id)),
//                Updates.set("username", username)
//        );
//        Optional<User> user = this.userRepository.findById(id);
//        if (user.isPresent()) {
//            return user.get();
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
    }

}
