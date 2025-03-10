//package com.example.Task_3.services;
//
//import com.example.Task_3.models.Comment;
//import com.example.Task_3.models.Post;
//import com.example.Task_3.repositories.PostRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PostService {
//
//    private final PostRepository postRepository;
//
//    public PostService(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    public Post savePost(Post post) {
//        return postRepository.save(post);
//    }
//    public List<Post> getAllPosts() {
//        return postRepository.findAll();
//    }
//
//    public Optional<Post> getPostById(String id) {
//        return postRepository.findById(id);
//    }
//
//    public void deletePost(String id) {
//        postRepository.deleteById(id);
//    }
//
//    //Get Posts By Author ID
//
//    //Add Comment to Post
//
//}
