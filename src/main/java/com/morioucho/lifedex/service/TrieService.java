package com.morioucho.lifedex.service;

import com.morioucho.lifedex.trie.Trie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrieService {
    private Trie trie;

    @PostConstruct
    public void init(){
        this.trie = new Trie();
    }

    public void insertTitle(String title){
        trie.insert(title);
    }

    public List<String> searchByPrefix(String prefix){
        return trie.searchByPrefix(prefix);
    }
}
