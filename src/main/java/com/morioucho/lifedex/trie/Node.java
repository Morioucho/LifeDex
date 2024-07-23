package com.morioucho.lifedex.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private Map<Character, Node> children = new HashMap<>();
    private boolean isEndOfWord;

    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Node> children) {
        this.children = children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
