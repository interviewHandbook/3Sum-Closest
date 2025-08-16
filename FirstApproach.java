package com.interviewprep.leetcode.medium.threesumclosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstApproach {

	public static void main(String[] args) {
		
		int[] nums = {-1,2,1,-4};
		int target = 1;
		
		FirstApproach fa = new FirstApproach();
		int threeSumClosest = fa.threeSumClosest(nums, target);
		
		System.out.println(threeSumClosest);
	}
	
	public int threeSumClosest(int[] nums, int target) {

		int diff = 0;
		int distFromTarget = Integer.MAX_VALUE;
		int lowestSum = 0;

		Arrays.sort(nums);

		int len = nums.length;

		for(int i=0; i<len-2; i++) {

			// skip duplicates
			if(i>0 && nums[i] == nums[i-1]) {
				continue;
			}

			int j = i+1;
			int k = nums.length-1;

			while(j < k) {

				int sum = nums[i] + nums[j] + nums[k];
				diff = Math.abs(target - sum); 
				
				// minimize distanceFromTarget
				if(distFromTarget > diff){

					distFromTarget = diff;
					lowestSum = sum;
				}

				if(sum == target) 
					return sum;

				else if(sum < target)				
					j++;

				else if(sum > target)
					k--;


			} // endwhile

		}// end outer for loop


		return lowestSum;
	}

}
