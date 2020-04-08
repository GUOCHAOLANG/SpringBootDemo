package leetcode;

/**
 * gcl
 * 2020/3/7 11:45
 */
public class L1 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        Solution solution = new Solution();
        solution.rotate(nums);
        System.out.println("914====");
    }
    public static void test_914(){
        int[] nums = {1,2,3,4,4,3,2,1};
        Solution solution = new Solution();
        System.out.println("914===="+solution.hasGroupsSizeX(nums));
    }
    public static void test_169(){
        int[] nums = {3,2,3};
        Solution solution = new Solution();
        System.out.println("169===="+solution.majorityElement(nums));
    }
    private static void test_363(){
        int[][] matrix = {
                {1,0,1},
                {0,-2,3}
        };
        int[][] matrix2 = {
                {1,0,1},
                {}
        };
        int k2 = 2;
        int[][] matrix3 = {
                {2,2,-1}
        };
        int k3 = 0;

        int[][] matrix4 = {
                {2,2,-1}
        };
        int k4 = 3;
        //int[][] matrix= new[][]{{1,2,3},{1,2,3},{1,2,3}}, int k
        Solution solution = new Solution();
        System.out.println("363===="+solution.maxSumSubmatrix(matrix4,k4));
        System.out.println();
    }

    private static void test_4() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
//        int[] nums1 = new int[]{1,2};
//        int[] nums2 = new int[]{3,4};
//        int[] nums1 = new int[]{2,3};
//        int[] nums2 = new int[]{1};

        Solution solution = new Solution();
        System.out.println("4===="+solution.findMedianSortedArrays(nums1,nums2));
        System.out.println();
    }
}
