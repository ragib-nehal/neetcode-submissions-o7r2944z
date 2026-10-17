class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # we have to find the length of the longest substring without duplicate characters
        # sliding window + set
        chars = set()
        count = 0
        left = 0

        for right in range(len(s)):
            # remove the left most element in the current window
            # loop unitl current char is removed from the set
            while s[right] in chars:
                chars.remove(s[left])
                left += 1 
            
            chars.add(s[right])
            count = max(count, right - left + 1) # max of current count and length of our window + 1 
        
        return count


        # Time: O(n)
        # Space: O(n)