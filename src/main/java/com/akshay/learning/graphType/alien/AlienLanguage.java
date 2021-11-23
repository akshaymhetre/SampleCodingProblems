package com.akshay.learning.graphType.alien;

// ba,ac,cb -> bac
// ba, ac, cz, cd, acd -> baczd
//

/*
* Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

Examples:

Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
Output: Order of characters is 'b', 'd', 'a', 'c'
Note that words are sorted and in the given language "baa"
comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input:  words[] = {"caa", "aaa", "aab"}
Output: Order of characters is 'c', 'a', 'b'
* */

import java.util.*;

/*
 Initial Setup:
 Given: class Vertex { val label: Char }, class Graph { val adjList: Map<Vertex, List<Vertex>> }
* Algo:
* - Iterate all characters from all words and add as vertex to graph
* - Compare *TWO ADJACENT WORDS* char by char till you find two different characters, then add directed edge from those two characters
* - Get topological sort
      - Iterative is easier with stack, just push vertex and on pop print and add all edges
* */
public class AlienLanguage {
    public Set<Character> getAlphabets(List<String> words){

        Graph<Character> graph = new Graph<>();
        addAllCharactersAsVertices(words, graph);
        // Find mismatch between adjacent words and add edges
        addDirectedEdges(words, graph);
        return getTopologicalSortIterative(graph);
    }

    private LinkedHashSet<Character> getTopologicalSortRecursive(Graph<Character> graph) {
        LinkedHashSet<Vertex<Character>> visited = new LinkedHashSet<>();
        LinkedHashSet<Character> alphabets = new LinkedHashSet<>();
        // Run sort for all vertices : (There could be no edges between two, hence)
        for(Vertex<Character> v: graph.getVertices()){
            alphabets.addAll(recursiveTopologicalSort(v, graph, visited));
        }
        return alphabets;
    }

    private Set<Character> recursiveTopologicalSort(Vertex<Character> v, Graph<Character> graph, LinkedHashSet<Vertex<Character>> visited) {
        if(!visited.contains(v)){
            List<Vertex<Character>> edgedVertices = graph.getEdgedVertices(v);
            if(edgedVertices.isEmpty()){
                visited.add(v);
                return new LinkedHashSet<>(v.label);
            } else {
                LinkedHashSet<Character> objects = new LinkedHashSet<>();
                for (Vertex<Character> ev: edgedVertices) {
                    Set<Character> otherChars = recursiveTopologicalSort(ev, graph, visited);
                    visited.add(v);
                    objects.add(v.label);
                    objects.addAll(otherChars);
                }
                return objects;
            }
        }
        return new LinkedHashSet<>();
    }

    private LinkedHashSet<Character> getTopologicalSortIterative(Graph<Character> graph) {
        LinkedHashSet<Vertex<Character>> visited = new LinkedHashSet<>();
        LinkedHashSet<Character> alphabets = new LinkedHashSet<>();
        // Run sort for all vertices : (There could be no edges between two, hence)

        //Stack<Vertex<Character>> stack = new Stack<>();
        /*
           Imp Note:
           - Deque is much faster compare to stack as stack extends Vector and hence thread safe
             Besides, stack is not interface.
           - ArrayDeque is much better compare to LinkedList as adding and removing element at the ends is much faster plus it provides random access with O(1)
         */
        Deque<Vertex<Character>> stack = new ArrayDeque<>();
        for(Vertex<Character> v: graph.getVertices()){
            stack.push(v);
            while(!stack.isEmpty()){
                Vertex<Character> pop = stack.pop();
                if(!visited.contains(pop)) {
                    visited.add(pop);
                    alphabets.add(pop.label);
                    graph.getEdgedVertices(v).forEach(stack::push);
                }
            }
        }
        return alphabets;
    }

    private Set<Character> iterativeTopologicalSort(Vertex<Character> v, Graph<Character> graph, LinkedHashSet<Vertex<Character>> visited) {
        if(!visited.contains(v)){
            List<Vertex<Character>> edgedVertices = graph.getEdgedVertices(v);
            if(edgedVertices.isEmpty()){
                visited.add(v);
                return new LinkedHashSet<>(v.label);
            } else {
                LinkedHashSet<Character> objects = new LinkedHashSet<>();
                for (Vertex<Character> ev: edgedVertices) {
                    Set<Character> otherChars = recursiveTopologicalSort(ev, graph, visited);
                    visited.add(v);
                    objects.add(v.label);
                    objects.addAll(otherChars);
                }
                return objects;
            }
        }
        return new LinkedHashSet<>();
    }

    private void addDirectedEdges(List<String> words, Graph<Character> graph) {
        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i+1);
            int min = Math.min(word1.length(), word2.length());
            for (int j = 0; j < min; j++) {
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.addDirectedEdge(word1.charAt(j), word2.charAt(j));
                    break;
                }
            }
        }
    }

    private void addAllCharactersAsVertices(List<String> words, Graph<Character> graph) {
        words.forEach(word -> word.chars().mapToObj(c -> (char) c).forEach(graph::addVertex));
    }
}
