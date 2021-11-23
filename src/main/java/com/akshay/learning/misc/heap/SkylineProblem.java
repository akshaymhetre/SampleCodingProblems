package com.akshay.learning.misc.heap;

import java.util.*;

public class SkylineProblem {
    /*
    * Does not work for (as treemap is not allowing duplicate keys):
    * Input
        [[0,2,3],[2,5,3]]
        Output
        [[0,3],[2,0]]
        Expected
        [[0,3],[5,0]]
    * */
    public List<List<Integer>> getSkylineUsingTreeMap(int[][] buildings) {
        List<Pair> pairs = new ArrayList<>();
        for (int[] building:
                buildings) {
            // start point, with height negative, just to know diff between start and end
            pairs.add(new Pair(building[0], -building[2]));
            // end point
            pairs.add(new Pair(building[1], building[2]));
        }
        Collections.sort(pairs);
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Boolean> maxHeights = new TreeMap<>(Comparator.reverseOrder());
        int heightSoFar = 0;
        maxHeights.put(heightSoFar, true);
        for (Pair pair :
                pairs) {
            int currHeight = pair.height;
            int currX = pair.x;
            //starting point
            if(currHeight < 0){
                maxHeights.put(-currHeight, true);
            } else {
                maxHeights.remove(currHeight);
            }
            if(heightSoFar != maxHeights.firstKey()){
                heightSoFar = maxHeights.firstKey();
                ans.add(Arrays.asList(currX, heightSoFar));
            }
        }
        return ans;

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> pairs = new ArrayList<>();
        for (int[] building:
             buildings) {
            // start point, with height negative, just to know diff between start and end
            pairs.add(new Pair(building[0], -building[2]));
            // end point
            pairs.add(new Pair(building[1], building[2]));
        }
        Collections.sort(pairs);
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> maxHeights = new PriorityQueue<>(Comparator.reverseOrder());
        int heightSoFar = 0;
        maxHeights.offer(heightSoFar);
        for (Pair pair :
                pairs) {
            int currHeight = pair.height;
            int currX = pair.x;
            //starting point
            if(currHeight < 0){
                // only add positive heights
                maxHeights.add(-currHeight);
            } else {
                maxHeights.remove(currHeight);
            }

            final boolean isHeightChange = heightSoFar != getPeekFromQueue(maxHeights);
            if(isHeightChange){
                heightSoFar = getPeekFromQueue(maxHeights);
                ans.add(Arrays.asList(currX, heightSoFar));
            }
        }
        return ans;

    }

    private int getPeekFromQueue(PriorityQueue<Integer> maxHeights) {
        return maxHeights.peek() == null ? 0 : maxHeights.peek();
    }

    class Pair implements Comparable<Pair>{
        int x;
        int height;

        public Pair(int x, int height) {
            this.x = x;
            this.height = height;
        }

        @Override
        public int compareTo(Pair o) {
            int diff = this.x - o.x;
            return (diff == 0) ? (this.height - o.height) : diff;
        }
    }
}
