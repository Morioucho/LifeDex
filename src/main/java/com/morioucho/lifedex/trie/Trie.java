package com.morioucho.lifedex.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private final Node root;

    public Trie(){
        this.root = new Node();
    }

    public void insert(String word){
        Node curr = this.root;

        for(char letter : word.toCharArray()){
            curr = curr.getChildren().computeIfAbsent(letter, n -> new Node());
        }

        curr.setEndOfWord(true);
    }

    public boolean search(String word){
        Node curr = this.root;

        for(char letter : word.toCharArray()){
            curr = curr.getChildren().get(letter);

            if(curr == null){
                return false;
            }
        }

        return curr.isEndOfWord();
    }

    public List<String> searchByPrefix(String prefix){
        List<String> results = new ArrayList<>();
        Node curr = this.root;

        for(char letter : prefix.toCharArray()){
            curr = curr.getChildren().get(letter);

            if(curr == null){
                return results;
            }
        }

        findAllWords(curr, new StringBuilder(prefix), results);
        return results;
    }

    private void findAllWords(Node curr, StringBuilder prefix, List<String> results){
        if(curr.isEndOfWord()){
            results.add(prefix.toString());
        }

        for(char letter : curr.getChildren().keySet()){
            prefix.append(letter);
            findAllWords(curr.getChildren().get(letter), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public String toString(){
        StringBuilder strBuilder = new StringBuilder();

        for(Node curr : this.root.getChildren().values()){
            strBuilder.append(curr.toString()).append(", ");
        }

        return strBuilder.toString();
    }
}
