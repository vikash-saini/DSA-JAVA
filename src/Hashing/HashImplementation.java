package Hashing;
import java.util.*;

class Hash {
    private List<List<Integer>> table;
    private int bucketSize;

    // initializing the hash table
    public Hash(int size) {
        this.bucketSize = size;
        table = new ArrayList<>();
        for(int i=0; i<bucketSize; i++){
            table.add(new ArrayList<>());
        }
    }

    public int hashFunction(int key){
        return key % bucketSize;
    }

    public void insert(int key){
        int tableIndex = hashFunction(key);
        table.get(tableIndex).add(key);
    }
    public void remove(int key){
        int tableIndex = hashFunction(key);
        List<Integer> bucket = table.get(tableIndex);
        // Find and remove the key from the bucket
        bucket.remove(Integer.valueOf(key));
    }
    public boolean search(int key){
        int tableIndex = hashFunction(key);
        List<Integer> bucket = table.get(tableIndex);
        return bucket.contains(key);
    }

    public void display(){
        for(int i=0; i<bucketSize; i++){
            System.out.print(i + ": ");
            for(int key : table.get(i)){
                System.out.print(key + " -> ");
            }
            System.out.println("null");
        }
    }
    
}

public class HashImplementation {
    public static void main(String[] args){
        int[] keys = {15, 11, 27, 8, 12,25};
        System.out.println("Hashing Implementation");
        Hash hash = new Hash(7);
        for (int key: keys) {
            hash.insert(key);
        }
        hash.insert(5);
        hash.remove(5);
        System.out.println(hash.search(5)); // false
        System.out.println(hash.search(15)); // true
        hash.display();
    }
}
