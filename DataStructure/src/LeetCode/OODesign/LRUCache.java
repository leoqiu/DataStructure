package LeetCode.OODesign;

import heaps.adt.BinaryHeap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/25/13
 *
 * http://oj.leetcode.com/problems/lru-cache/
 *
 */


public class LRUCache {

    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> mapCounter;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Integer>();
        mapCounter = new HashMap<Integer, Integer>();
    }

    public int get(int key) {

        if(map.containsKey(key)) {
            mapCounter.put(key, mapCounter.get(key)+1);
            return map.get(key);
        }

        else
            return -1;
    }

    public void set(int key, int value) {

        if(map.containsKey(key)) {
            map.put(key, value);
        } else {

            //invalidate least used cache
            if(this.capacity == 0) {
                Iterator it = mapCounter.entrySet().iterator();
                int minKey = -1;
                int minUseTimes = Integer.MAX_VALUE;
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
                    if(entry.getValue() < minUseTimes) {
                        minUseTimes = entry.getValue();
                        minKey = entry.getKey();
                    }
                }

                map.remove(minKey);
                mapCounter.remove(minKey);
            } else {
                this.capacity--;
            }

            map.put(key, value);
            mapCounter.put(key, 0);

        }

    }

    public static void main (String[] args) {

        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2,1);
        System.out.println(lruCache.get(2));
        lruCache.set(3,2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));


        System.out.println();
    }



}






































