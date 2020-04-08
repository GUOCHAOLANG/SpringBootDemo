package leetcode;

import java.util.*;
import java.util.regex.Pattern;

/**
 * gcl
 * 2020/3/7 11:46
 */
public class Solution {
    public void rotate(int[][] matrix) {

    }
    public boolean hasGroupsSizeX(int[] deck) {
        int x = 2;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < deck.length; i++) {
            set.add(deck[i]);
        }
        for (Integer i :set){
            int tream = 0;
            for (int j = 0; j <deck.length ; j++) {
                if (i.equals(deck[j])){
                    tream++;
                }
            }
            if (tream<x){
                return false;
            }
        }

        return true;
    }
    public int majorityElement(int[] nums) {
        int tag = nums.length/2;
        Integer returnTag = 0;
        Integer returnKey = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],map.get(nums[i])==null?1:map.get(nums[i])+1);
            if (map.get(nums[i])>tag && returnTag<map.get(nums[i])){
                returnTag = map.get(nums[i]);
                returnKey = nums[i];
            }
        }
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });

        for (Map.Entry<Integer,Integer> i:map.entrySet()){
            if (i.getValue()>tag && returnTag<i.getValue()){
                returnTag = i.getValue();
                returnKey = i.getKey();
            }
        }
        return returnKey;
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {

        int m = matrix.length, n = matrix[0].length, result = Integer.MIN_VALUE;
        int[][] sum = new int[m][n];
        for (int i = 0;i < m; i++) {
            /*计算第一列 */
            sum[i][0] = matrix[i][0];
        }
        for (int i = 0;i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }
        for (int left = 0;left < n; left++) {
            for (int right = left; right < n; right++) {
                int curSum = 0, curMax = Integer.MIN_VALUE;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int i = 0; i < m; i++) {
                    curSum += sum[i][right];
                    if (left > 0) {
                        curSum -= sum[i][left - 1];
                    }
                    Integer another = set.ceiling(curSum - k);
                    if (null != another) {
                        curMax = Math.max(curMax, curSum - another);
                    }
                    set.add(curSum);
                }
                result = Math.max(result, curMax);
            }
        }
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        int t1 = 0, t2 = 0, t = 0;
        if (nums1.length == 0) {
            for (int i = 0; i < nums2.length; i++) {
                array[i] = nums2[i];
            }
        } else if (nums2.length == 0) {
            for (int i = 0; i < nums1.length; i++) {
                array[i] = nums1[i];
            }
        } else {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] <= nums2[t2]) {
                    array[t] = nums1[i];
                    t++;
                } else if (nums1[i] > nums2[t2]) {
                    while (nums1[i] > nums2[t2]) {
                        array[t] = nums2[t2];
                        t++;
                        t2++;
                        if (t2 >= nums2.length) {
                            break;
                        }
                    }
                    array[t] = nums1[i];
                    t++;
                }
                if (t2 >= nums2.length) {
                    t1 = i + 1;
                    break;
                }
            }
            for (int i = t2; i < nums2.length; i++) {
                array[t] = nums2[i];
                t++;
            }
            if (t < array.length) {
                for (int i = t1; i < nums1.length; i++) {
                    array[t] = nums1[i];
                    t++;
                }
            }

        }
        int median = array.length / 2;
        int remainder = array.length % 2;

        if (remainder != 0) {
            //奇数
            return array[median];
        } else {
            return (double) (array[median] + array[median - 1]) / 2;
        }
    }


}
