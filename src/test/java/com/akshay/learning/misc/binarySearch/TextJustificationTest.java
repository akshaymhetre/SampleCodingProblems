package com.akshay.learning.misc.binarySearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TextJustificationTest {
    @Test
    public void shouldWork(){
        assertEquals(Arrays.asList(
                "This    is    an",
                "example  of text",
                "justification.  "
        ), new TextJustification().fullJustify(
                new String[]{
                        "This", "is", "an", "example", "of", "text", "justification."
                },
                16
        ));

        assertEquals(Arrays.asList(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        ), new TextJustification().fullJustify(
                new String[]{
                        "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"
                },
                20
        ));
    }
}