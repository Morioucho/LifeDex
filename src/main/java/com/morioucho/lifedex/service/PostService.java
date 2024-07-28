package com.morioucho.lifedex.service;

import com.morioucho.lifedex.model.Post;
import com.morioucho.lifedex.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TrieService trieService;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post getPostByID(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post){
        post.setCreationDate(LocalDateTime.now());
        trieService.insertTitle(post.getTitle());

        return postRepository.save(post);
    }

    public List<String> searchTitleWithPrefix(String prefix){
        return trieService.searchByPrefix(prefix);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
