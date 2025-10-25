package Hashing;
import java.util.*;

public class CountFrequencyofNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,4,5,5,5,5};
        countFrequency(arr); // Time Complexity: O(n), Space Complexity: O(m) where m is the range of input numbers
        // countFrequencyBruteForce(arr); // Time Complexity: O(n^2), Space Complexity: O(1)
        countFrequencyUsingHashMap(arr); // Time Complexity: O(n), Space Complexity: O(k) where k is the number of unique elements
    }

    static void countFrequency(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int[] frequency = new int[max + 1];

        for (int num : arr) {
            frequency[num]++;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " occurs " + frequency[i] + " times");
            }
        }
    }

    static void countFrequencyBruteForce(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }
            System.out.println(arr[i] + " occurs " + count + " times");
        }
    }

    static void countFrequencyUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times");
        }
    }
    
}