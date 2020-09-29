import java.util.Collections;
import java.util.TreeMap;
import org.joda.time.Interval;
class SummaryRanges {
    /** Initialize your data structure here. */
    TreeMap<Integer, Interval> treeMap = new TreeMap<>();
    public SummaryRanges() {

    }

    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);
        if (lowerKey != null && higherKey != null && treeMap.get(lowerKey).end + 1 == val
                &&  val + 1 == treeMap.get(higherKey).start ) {
            treeMap.get(lowerKey).end = treeMap.get(higherKey).end;
            treeMap.remove(higherKey);
        }else if (lowerKey != null && val <= treeMap.get(lowerKey).end + 1) {
            treeMap.get(lowerKey).end = Math.max(treeMap.get(lowerKey).end, val);
        }else if (higherKey != null && treeMap.get(higherKey).start - 1 == val) {
            treeMap.put(val, new Interval(val, treeMap.get(higherKey).end));
            treeMap.remove(higherKey);
        }else {
            treeMap.put(val,new Interval(val, val));
        }

    }

    public int[][] getIntervals() {
        Collections.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return intervals.toArray(new int[intervals.size()][]);
    }
}




/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */