//package com.example.Task_3.services;
//
//import com.example.Task_3.repositories.UserRepository;
//import com.mongodb.client.MongoClient;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//
//    MongoClient mongoClient;
//    public UserService(UserRepository userRepository, MongoClient mongoClient) {
//        this.userRepository = userRepository;
//        this.mongoClient = mongoClient;
//    }
//
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//    public Optional<User> findUserById(String id) {
//        return userRepository.findById(id);
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public void deleteUserById(String id) {
//        userRepository.deleteById(id);
//    }
//
//
//    //Update Username of the User
//
//}
