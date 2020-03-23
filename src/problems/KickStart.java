package problems;

import input.DataUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public final class KickStart {


    public static void solve() {


        Scanner in = new Scanner(DataUtil.getFile("kickstart_input.txt"));
        int numCases = in.nextInt();

        for (int i = 0; i < numCases; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            int P = in.nextInt();
            List<List<Integer>> list  = new ArrayList<>();
            String indices = "";

            for (int j=0;j<N;j++) {
                List<Integer> subList = new ArrayList();
                for (int k=0;k<K;k++) {
                    if (subList.isEmpty()) subList.add(in.nextInt());
                    else subList.add(0, in.nextInt());
                }
                list.add(subList);
                indices += K;
            }

            for (List<Integer> row : list)  {
                System.out.println(row);
            }

            System.out.println("Case #" + (i+1) + ": " + dfs(list, P, indices));
        }
    }

    private static int dfs(List<List<Integer>> list, int P, String indices) {
        if (P == 0) return 0;
        int sum = 0;
        for (int i=0;i<list.size();i++) {
            int index = Character.getNumericValue(indices.charAt(i));
            if (index >= 1) {
                String newIndices = indices.substring(0, i) + (index-1) + indices.substring(i+1);
                sum = Math.max(sum,
                        dfs(list, P-1, newIndices) + list.get(i).get(index-1));

            }
        }
        System.out.println(sum);

        return sum;
    }
}
