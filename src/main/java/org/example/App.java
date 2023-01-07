package org.example;

import java.util.*;

/**
 * Hello world!
 * Время раюоты О(n2)
 * Память О(1)
 */
public class App

{
    private static int[] findTwoSum_BruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    // Time complexity: O(n)
    private static int[] findTwoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (set.contains(comp)){
                return new int[]{comp, i};
            }else {
                set.add(nums[i]);
            }
        }
        return new int[]{};
    }

    // Time complexity: O(n)
    private static int[] findTwoSumTwo(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }

    // Time complexity: O(n*log(n))
    // loookin version
    private static int[] findTwoSum_Sorting(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int numToFind = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l <= r){
                int mid = l + (r - l)/2;
                if (nums[mid] == numToFind){
                    return new int[]{nums[i], nums[mid]};
                }if(numToFind < nums[mid]){
                    r = mid -1;
                }else {
                    l = mid +1;
                }
            }

        }
        return new int[] {};
    }


    // Time complexity: O(n*log(n))
    private static int[] findTwoSum_SortingTwo(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                return new int[] {nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    private static int[] findTwoSum_SortingTwoThree(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while (l < r){
            int sum = nums[l] + nums[r];
            if (sum == target){
                return new int[]{nums[l], nums[r]};
            }
        }

        return new int[] {};
    }


    public static void main( String[] args )
    {

    }
}
