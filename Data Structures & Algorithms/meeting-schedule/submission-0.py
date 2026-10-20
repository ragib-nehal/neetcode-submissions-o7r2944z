"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        # we're given meeeting intervals
        # each interval has a start and end time
        # our input list consists of tuples/intervals in this case
        # look for overlaps in meetings, one meeting cannot begin while another is happening

        # first sort the Intervals
        intervals.sort(key = lambda i: i.start) # i is each interval

        # start at index 1, since were comparing the prev
        for i in range(1, len(intervals)):
            inter1 = intervals[i - 1]
            inter2 = intervals[i]

            if (inter2.start >= inter1.end): # second meeting starts after first
                continue
            
            else:
                return False
            
        return True 


