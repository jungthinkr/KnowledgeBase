import algorithms.backtracking.Permutations;

import java.util.List;

public class main {
    public static void main(String[] args) {
        List<List<Integer>> list = Permutations.permuteWithDupe(new int[]{1,2,3,4});
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }
}
