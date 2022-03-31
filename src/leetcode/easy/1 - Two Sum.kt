package leetcode.easy

import java.util.*

/**
Link: https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:


Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:


Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:


Input: nums = [3,3], target = 6
Output: [0,1]



Constraints:

2 <= nums.length <= 104

-109 <= nums[i] <= 109

-109 <= target <= 109

Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
class `1 - Two Sum` {
    /**
     * Brute Force
     *
     * Time: O(n²)
     * Space: O(1)
     */
    fun twoSum_1(nums: IntArray, target: Int): IntArray {
        for (firstIndex in 0..nums.size - 2) {
            for (secondIndex in firstIndex + 1..nums.size - 1) {
                val sum = nums[firstIndex] + nums[secondIndex]

                if (sum == target) return intArrayOf(firstIndex, secondIndex)
            }
        }

        return intArrayOf(-1, -1)
    }

    /**
     * HashMap with Complements
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun twoSum_2(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for (currentIndex in nums.indices) {
            val current = nums[currentIndex]
            val complement = target - current

            if (map.containsKey(complement)) {
                val complementIndex = map.get(complement)!!
                return intArrayOf(complementIndex, currentIndex)
            } else {
                map.put(current, currentIndex)
            }
        }

        return intArrayOf(-1, -1)
    }
}