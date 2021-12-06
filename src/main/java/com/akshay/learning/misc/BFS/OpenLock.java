package com.akshay.learning.misc.BFS;

import java.util.*;
import java.util.stream.Collectors;

/*
*     - USe BFS
    - Add "0000"
    - Then add all combination for 4 digits in clockwise and anti-clockwise manner
        - for example, for simplicity lets consider for single digit- "0" = Clockwise -> "1" & Anti- "9"
    - if any number is in deadlock do not proceed
    * */
public class OpenLock {
    // deadends = ["0201, "0101", "0102", "1212", "2002"] target = "0202"
    public int openLock(String[] deadends, String target){
        final Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int attempts = -1;
        while(!queue.isEmpty()){
            int x = queue.size();
            attempts++;
            for (int i = 0; i < x; i++) {
                final String poll = queue.poll();
                if(visited.contains(poll)) continue;
                if(poll.equals(target)) return attempts;
                final Set<String> allCombinations = getAllCombinations(poll);
                visited.add(poll);
                queue.addAll(allCombinations);
            }
        }
        return -1;
    }

    private Set<String> getAllCombinations(String poll) {
        char[] charArray = poll.toCharArray();
        Set<String> res = new HashSet<>();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char digit = charArray[i];
            int dNum = digit - '0';
            final int clockWise = (dNum == 9) ? 0 : dNum + 1;
            final int antiClockWise = (dNum == 0) ? 9 : dNum - 1;
            res.add(getCombo(poll, i, clockWise));
            res.add(getCombo(poll, i, antiClockWise));
        }
        return res;
    }

    private String getCombo(String poll, int i, int change) {
        return poll.substring(0, i) + change + poll.substring(i + 1);
    }
}
