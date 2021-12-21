package com.akshay.learning.DP.recursive;

import com.akshay.learning.misc.BFS.WordBreak;
import com.sun.tools.javac.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordBreakTest {
    @Test
    public void shouldWork(){
        assertEquals(true, new WordBreak().wordBreak("leetcode", List.of("leet", "code")));
        assertEquals(true, new WordBreak().wordBreak("applepenapple", List.of("apple", "pen")));
        assertEquals(false, new WordBreak().wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }
}