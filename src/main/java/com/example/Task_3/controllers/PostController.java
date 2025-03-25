package com.example.Task_3.controllers;

import com.example.Task_3.models.Comment;
import com.example.Task_3.models.Post;
import com.example.Task_3.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePost(@RequestBody Map<String, String> body) {
        postService.deletePost(body.get("id"));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") String id) {
        if (!postService.getPostById(id).isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(postService.getPostById(id).get());
    }

    //Get Posts by Author ID
    @GetMapping("/postsByUser/{authorID}")
    public List<Post> getPostsByAuthorID(@PathVariable("authorID") String authorID) {
        return postService.getPostsByAuthorID(authorID);
    }


    //Add Comment to post
    @PostMapping("/{postID}/comments")
    public ResponseEntity<Post> addCommentToPost(@PathVariable("postID") String postID, @RequestBody Map<String, String> body) {
        Comment comment = new Comment(body.get("text"), body.get("date"));
        Post post = postService.addCommentToPost(postID, comment);
        if (post == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(post);
    }


}
