/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

package LeetCode75;

import java.util.Stack;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                reversed.append(words[i]).append(" ");
            }
        }
        return reversed.toString().trim();
    }

    public String reverseWordsStack(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    stack.push(word.toString());
                    word = new StringBuilder();
                }
            }
        }
        if (word.length() > 0) {
            stack.push(word.toString());
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop()).append(" ");
        }
        return reversed.toString().trim();
    }
}