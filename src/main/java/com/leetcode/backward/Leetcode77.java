package com.leetcode.backward;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77.组合
 *
 * @author ZeroNeo
 * @version 1.0
 * @date 2026/5/15 23:36
 */
public class Leetcode77 {
    public static void main(String[] args) {
        Leetcode77 leetcode77 = new Leetcode77();

        int n = 4, k = 2;

        List<List<Integer>> result = leetcode77.combine(n, k);

        System.out.println(result);
    }

    /*
    必要元素：
        1. 结果集：为 combine 的返回值 List<List<Integer>>
        2. 组合集：为 结果集中的每组元素 List<Integer>
    必要条件：
        1. 终止递归: 结果集的长度等于 k 的时候，将组合集加入到结果集
        2. 单层递归：从 startIndex 遍历到 n，选一个数加入组合集，递归选下一个数，然后回溯
        3. 剪枝优化：剩余数字不够 k 个时，提前结束循环
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        backtrack(result, path, 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, Stack<Integer> path, int startIndex, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(result, path, i + 1, n, k);
            path.pop();
        }

    }
}
