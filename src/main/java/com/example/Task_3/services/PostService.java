package com.example.Task_3.services;

import com.example.Task_3.models.Comment;
import com.example.Task_3.models.Post;
import com.example.Task_3.repositories.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePost(Post post) {
        //check if the author is null or not
        if (post.getAuthor() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author is Required");
        }
        Post newPost = new Post(post.getTitle(), post.getContent(), post.getAuthor());
        return postRepository.save(newPost);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(String id) {
        return postRepository.findById(id);
    }

    public void deletePost(String id) {
        postRepository.deleteById(id);
    }

    //Get Posts By Author ID
    public List<Post> getPostsByAuthorID(String authorID) {
        List<Post> posts = postRepository.findByAuthorID(authorID);
        return posts;
    }

    //Add Comment to Post
    public Post addCommentToPost(String postID, Comment newComment) {
        Optional<Post> post = postRepository.findById(postID);
        if (post.isPresent()) {
            post.get().addComment(newComment);
            return postRepository.save(post.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
    }

}
