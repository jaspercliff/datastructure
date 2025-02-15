package com.jasper;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // 输入的3个数字
        List<List<Integer>> result = permute(nums); // 获取所有排列
        for (List<Integer> permutation : result) {
            System.out.println(permutation); // 输出每个排列
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, new ArrayList(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] used) {
        // 终止条件：如果路径长度等于数组长度，说明找到一个完整排列
        if (path.size() == nums.length) {
            result.add(new ArrayList(path)); // 必须创建新列表，否则会被后续修改
            return;
        }

        // 遍历所有可能的选项
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // 剪枝：跳过已使用的数字
            }

            // 1. 做出选择
            path.add(nums[i]);    // 将当前数字加入路径
            used[i] = true;       // 标记该数字已被使用

            // 2. 递归进入下一层决策树
            backtrack(result, path, nums, used);

            // 3. 撤销选择（回溯的核心步骤）
            path.remove(path.size() - 1); // 移除路径中最后一个数字
            used[i] = false;              // 重置该数字的使用状态
        }
    }
}