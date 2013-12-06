package LeetCode.OODesign;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/4/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */

class Cache {
    int key;
    int value;

    Cache (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Node {
    Node pre = null;
    Node next = null;
    Cache cache;

    Node (Cache cache) {
        this.cache = cache;
    }
}

public class LRUCacheTwo {

    HashMap<Integer, Node> map;
    Node head;
    int capacity;

    public LRUCacheTwo(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = null;
    }

    public int get(int key) {

        if(map.containsKey(key)){
            Node cur = map.get(key);

            //move most recent used node to head
            detachNode(cur);
            attachToHead(cur);

            return cur.cache.value;
        } else
            return -1;
    }

    public void set(int key, int value) {

        Cache cache = new Cache(key, value);

        if(map.containsKey(key)) {
            //update existing node
            Node cur = map.get(key);
            cur.cache = cache;

            detachNode(cur);
            attachToHead(cur);
        } else {
            //add a new node and remove the least recently used cache
            if(this.capacity == 0) {
                Node node = new Node(cache);
                attachToHead(node);
                Node last = head.pre;
                detachNode(last);
                map.put(key, node);
                map.remove(last.cache.key);
            //only add a new node
            } else {
                Node node = new Node(cache);
                attachToHead(node);
                map.put(key, node);
                this.capacity--;
            }
        }
    }

    private void detachNode (Node node) {
        if(node == head)
            head = node.next;
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void attachToHead (Node node) {
        if(head != null) {
            node.pre = head.pre;
            head.pre.next = node;
            node.next = head;
            head.pre = node;
            head = node;
        } else {
            head = node;
            head.pre = node;
            head.next = node;
        }
    }

    public static void main (String[] args) {

        LRUCacheTwo lruCache = new LRUCacheTwo(1);
        lruCache.set(2,1);
        System.out.println(lruCache.get(2));
        lruCache.set(3,2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));


        System.out.println();
    }


}




















