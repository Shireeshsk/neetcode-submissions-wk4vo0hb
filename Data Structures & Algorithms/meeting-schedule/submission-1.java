/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->a.start-b.start);
        for(int i = 1;i<intervals.size();i++){
            Interval s1 = intervals.get(i-1);
            Interval s2 = intervals.get(i);
            if(s1.end>s2.start) return false;
        }
        return true;
    }
}
