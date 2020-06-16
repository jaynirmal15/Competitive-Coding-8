package s30Coding;
import java.util.*;

//Time Complexity :- O(m+n) where m is length of string s and n is the length of string t
//Space Complexity :- O(m+n) where m is length of string s and n is the length of string t
//LeetCode :- Yes

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
	       Map<Character, Integer> map = new HashMap<>();
	        for(int i = 0; i < t.length();i++){
	            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
	        }
	        int currMin = -1;
	        int l = 0, r = 0,formed = 0,fL = 0,fR = 0;
	        Map<Character,Integer> currWindow = new HashMap<>();
	        while(r < s.length()){
	            char c = s.charAt(r);
	            currWindow.put(c, currWindow.getOrDefault(c,0) + 1);
	            if(map.containsKey(c) && currWindow.get(c).intValue() == map.get(c).intValue()) formed++;
	            while(l <=r && formed == map.size()){
	                c = s.charAt(l);
	                if((r - l + 1) < currMin || currMin == -1){
	                    currMin = r - l+1;
	                    fL = l;
	                    fR = r;
	                }
	                currWindow.put(c,currWindow.get(c) - 1);
	                if(map.containsKey(c) && currWindow.get(c).intValue() < map.get(c).intValue()) formed--;
	                l++;
	            }
	            r++;
	        }
	        System.out.println(fL);
	        return currMin == -1 ? "" : s.substring(fL, fR+1);
	    }
}
