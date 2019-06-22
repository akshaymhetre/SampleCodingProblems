package com.akshay.learning.java8Streams;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValues {
    public Map<String, Integer> byLambdaStream(Map<String, Integer> map){
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                LinkedHashMap::new));
    }
}
