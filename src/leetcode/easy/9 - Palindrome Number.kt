package leetcode.easy

/**
 *
Link: https://leetcode.com/problems/palindrome-number/

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.


Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:

-231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?
 */
class `9 - Palindrome Number` {
    /**
        Cases:
        1) Negative Numbers -> Return false
        2) Zero -> Return true
        3) If last digit is 0 -> Return false since only 0 can be palindrome with 0 as last digit
        4) Iterative case -> Return true (if palindrome) else false

        Algorithm (Iterative Case):
        Set halfNum to 0
        If halfNum equals num, return true.
        Get last digit                          -> num % 10
        Add last digit to halfNum * 10          -> halfNum * 10 + last digit
        Remove last digit from num        -> num / 10
        Repeat steps 2-5 until halfNum > num. If so, return false.

        Test Cases:
        1) x = 121
        x = 12
        halfNum = 12
        last digit = 2

        True!
        2) x = -121
        False -> Negative number cannot be palindrome

        3) x = 10
        False -> Cannot have 0 as last digit. Only 0 can.

        4) x = 11
        x = 1
        halfNum = 1
        last digit = 1
     */
    fun isPalindrome(x: Int): Boolean {
        // Case 1: Negative Numbers
        if (x < 0) return false

        // Case 2: Zero
        if (x == 0) return true

        // Case 3: Last digit is 0
        if (x % 10 == 0 && x != 0) return false

        // Case 4: Iterative Case
        var inputNum = x
        var halfNum = 0

        while (halfNum < inputNum) {
            val lastDigit = inputNum % 10
            halfNum = halfNum * 10 + lastDigit

            // Remove last digit
            inputNum /= 10
        }

        // Either they're equal OR halfNum has one digit more than x
        return inputNum == halfNum || inputNum == halfNum / 10
    }
}