import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class LongestSubsequence {
	public static ArrayList<Integer> FindLongestSubsequence(List<Integer> input) {
		int size = input.size();
		int biggestIndex = 0;
		ArrayList<ArrayList<Integer>> res =  
                new ArrayList<ArrayList<Integer>>(size);
		for (int i = 0; i < size; i++) {
			ArrayList<Integer> seq = new ArrayList<Integer>();
			int cur = input.get(i);
			seq.add(cur);
			for (int j = i + 1; j < size; j++) {
				if(input.get(j) > cur) {
					cur = input.get(j);
					seq.add(cur);
				}
			}
			res.add(seq);
			if (seq.size() > res.get(biggestIndex).size()) {
				biggestIndex = i;
			}
		}
		return res.get(biggestIndex);
	}
	
	public static void main(String[] args) {
		// Get a random input List
		int random_int = (int)(Math.random() * (101));
		List<Integer> inputList = new ArrayList<Integer>();
		for (int i = 0; i < random_int; i++) inputList.add((int)(Math.random() * (101)));
		
		ArrayList<Integer> longestSub = FindLongestSubsequence(inputList);
		System.out.println("Input: " + inputList.toString());
		System.out.println("Output: " + longestSub.toString());
	}
}
