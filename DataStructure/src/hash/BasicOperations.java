package hash;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 7/30/13
 * Time: 3:56 PM
 */

/**
 * Time complexity of hash
 *
 * Delete O(1)
 * Insert O(1)
 * Search O(1)
 *
 */

/**
 * #1. Components in Hashing
 *
 * #1. Hash Table
 * #2. Hash Functions
 * #3. Collisions
 * #4. Collision Resolution Techniques
 *
 */


/**
 * #2. Characteristics of good hash functions
 *
 * #1. Minimize collision
 * #2. Be easy and quick to compute
 * #3. Distribute key values evenly in the hash table
 * #4. Use all the information provided in the key
 * #5. Have a high "Load Factory for a given set of keys"
 *
 */

/**
 * #3. Load Factory = (Number of elements in hash table) / (Hash Table size)
 *
 * rehash, expand hash table entries
 *
 *
 */

/**
 * #4. Collision Resolution Techniques
 *
 * Direct Chaining:
 *              An array of linked list application
 *              Separate chaining
 *
 * Open Addressing:
 *              Array based implementation
 *              Linear probing (linear search)
 *                          1. problem is Clustering
 *                          2. rehash(key) = (n+1) % tablesize
 *                          3. the probing step-size should be relatively prime to the table size
 *              Quadratic probing (non linear search)
 *                          1. rehash(key) = (n+k^2)%tablesize
 *                          2. clustering problem will be highly avoided but still exists
 *              Double hashing (use two hash functions)
 *                          1. first probe the location h1(key)
 *                          2. if collision then h2(key)
 *                          3. if collision then (2* result of step #2)(key)
 *
 */



public class BasicOperations {



}




























































