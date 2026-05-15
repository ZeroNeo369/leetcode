package com.leetcode.backward;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 46. 全排列
 *
 * @author ZeroNeo
 * @version 1.0
 * @date 2026/5/16 0:30
 */
public class Leetcode46 {
    public static void main(String[] args) {
        Leetcode46 leetcode46 = new Leetcode46();

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = leetcode46.permute(nums);

        System.out.println(result);
    }

    /*
   必要元素：
       1. 结果集：List<List<Integer>>
       2. 排列集：Stack<Integer>
       3. 标记数组：boolean[] used —— 记录哪些数字已经被选过
    必要条件：
       1. 终止递归：路径长度等于 nums.length 时，收集结果
       2. 单层递归：从 0 遍历到 nums.length，跳过已使用的元素
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, path, used);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, Stack<Integer> path, boolean[] used) {
        if (nums.length == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, result, path, used);
            path.pop();
            used[i] = false;
        }

    }
}
