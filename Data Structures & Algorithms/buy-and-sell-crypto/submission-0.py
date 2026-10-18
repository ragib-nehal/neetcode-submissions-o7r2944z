class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # we can use a two-pointer technique 
        left, right = 0, 1 # left (buy) and right (sell)
        max_profit = 0

        while right < len(prices):
            # can we profit?
            if prices[left] < prices[right]:
                profit = prices[right] - prices[left]
                max_profit = max(max_profit, profit)
            else:
                left = right # we found a very low price, and left should be our min
            
            right += 1

        return max_profit
