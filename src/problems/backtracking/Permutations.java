package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    /**
     * Permutations  : https://leetcode.com/problems/permutations/
     */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        permuteBacktrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void permuteBacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                permuteBacktrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Permutations II  : https://leetcode.com/problems/permutations-ii/
     * (contains duplicates)
     */

    public static List<List<Integer>> permuteWithDupe(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permuteDupeBacktrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void permuteDupeBacktrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                permuteDupeBacktrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
