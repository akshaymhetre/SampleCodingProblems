package com.akshay.learning.Trie;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class WordSearch2Test {
    @Test
    public void shouldWork(){
        assertEquals(Stream.of("eat","oath").sorted().collect(Collectors.toList()), new WordSearch2().findWords(
                new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"}
        ).stream().sorted().collect(Collectors.toList()));
    }
}