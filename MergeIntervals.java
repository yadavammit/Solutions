import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
		MergeIntervals mi = new MergeIntervals();
		System.out.println(mi.merge(intervals));
		HashSet set = new HashSet();
		
	}

	public int[][] merge(int[][] intervals) {
		List<int[]> ls = Arrays.asList(intervals);
		Collections.sort(ls,(list1, list2) -> {
			return list1[1] - list2[0];
		});
		
		ArrayList<int[]> result = new ArrayList<int[]>();
		for(int i= 0 ; i< ls.size() - 1; i ++){
			
			if(ls.get(i)[1] > ls.get(i+1)[0]){
				result.add(new int[]{ls.get(i)[0],ls.get(i+1)[1]});
				i++;
			}else{
				result.add(new int[]{ls.get(i)[0],ls.get(i)[1]});
			}
		}
		
		return result.toArray(new int[result.size()][]);
	}
}
