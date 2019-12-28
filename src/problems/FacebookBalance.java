package problems;

import input.DataUtil;

import java.io.BufferedReader;
import java.util.Map;
import java.util.TreeMap;

/**
    You have a room-full of balances and weights. Each balance weighs ten pounds and is considered perfectly balanced when the sum of
    weights on its left and right sides are exactly the same. You have placed some weights on some of the balances, and you have placed
    some of the balances on other balances. Given a description of how the balances are arranged and how much additional weight is on
    each balance, determine how to add weight to the balances so that they are all perfectly balanced.

    There may be more than one way to balance everything, but always choose the way that places additional weight on the lowest balances.
    The input file will begin with a single integer, N, specifying how many balances there are. Balance 0 is specified by lines 1 and 2,
    balance 1 is specified by lines 3 and 4, etc... Each pair of lines is formatted as follows:

    WL <balances> WR <balances>
    WL and WR indicate the weight added to the left and right sides, respectively.
    <balances> is a space-delimited list of the other balance that are on that side of this balance. <balances> may contain zero or more elements.
    Consider the following input:
        4
        0 1
        0 2
        0
        0 3
        3
        0
        0
        0
    Balance 0 has balance 1 on its left side and balance 2 on its right side Balance 1 has balance 3 on its right side Balance 2 has three
    pounds on its left side Balance 3 has nothing on it. Since balance 3 has nothing on it it is already perfectly balanced, and weighs a
    total of 10 pounds. Balance 2 has no other balance on it, so all we need to do is balance it by putting three pounds on its right side.
    Now it weighs a total of 16 pounds. Balance 1 has balance three on its right side, which weighs 10 pounds, so we just put 10 pounds on its left side.
    Balance 1 weighs a total of 30 pounds. Balance 0 has balance 1 on its left side (30 pounds), and balance 2 on its right side (16 pounds),
    we can balance it by adding 14 pounds to the right side.

    The output should be N lines long, with the nth line listing the weight added to the nth balance, formatted as follows:
    <index>: <weight added="" to="" left="" side=""> <weight added="" to="" right="" side="">

    So the output for this problem would be:
        0: 0 14
        1: 10 0
        2: 0 3
        3: 0 0

        (0)10
      /      \
  (1) 10     (2)10
    /  \     /  \
   0  (3)10 3    0
  /   / \
 0   0   0

 **/

public class FacebookBalance {

    static Map<Integer, Node> map = new TreeMap<>();

    private static class Node {
        int leftWeight;
        int left = -1;
        int rightWeight;
        int right = -1;
        // answer
        int correctionLeft;
        int correctionRight;

        Node(String[] left, String[] right) {
            if(left.length == 2) {
                this.left = Integer.parseInt(left[1]);
            }
            if(right.length == 2) {
                this.right = Integer.parseInt(right[1]);
            }

            this.leftWeight = Integer.parseInt(left[0]);
            this.rightWeight = Integer.parseInt(right[0]);
        }
    }
    public static void run() {

        try {
            BufferedReader reader  = DataUtil.getFile("facebook_balance.txt");
            int numOfNodes = Integer.parseInt(reader.readLine());

            for (int i=0;i<numOfNodes;i++) {
                String[] left = reader.readLine().split(" ");
                String[] right = reader.readLine().split(" ");
                Node node = new Node(left, right);
                map.put(i, node);
            }

            dfs(0);
            for (int key : map.keySet()) {
                Node n = map.get(key);
                System.out.printf("%s: %s %s\n", key, n.correctionLeft, n.correctionRight);

            }


            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int dfs(int n) {
        Node node = map.get(n);
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left) + node.leftWeight;
        int right = dfs(node.right) + node.rightWeight;
        if (right > left) {
            node.correctionLeft = right-left;
        } else if (left > right) {
            node.correctionRight = left-right;
        }

        return left + right + node.correctionRight + node.correctionLeft + 10;
    }


}


